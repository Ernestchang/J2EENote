package com.bingoogol.algorithm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bingoogol.algorithm.dto.AlgorithmDto;
import com.bingoogol.algorithm.dto.Json;
import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.model.Algorithm;
import com.bingoogol.algorithm.model.Channel;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.model.UserAlgorithm;
import com.bingoogol.algorithm.service.IAlgorithmService;
import com.bingoogol.algorithm.service.IChannelService;
import com.bingoogol.algorithm.service.IUserAlgorithmService;

@Controller
@RequestMapping("/algorithm")
public class AlgorithmController {
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IAlgorithmService algorithmService;
	@Autowired
	private IUserAlgorithmService userAlgorithmService;

	@RequestMapping(value = "/front/add", method = RequestMethod.GET)
	public String frontAdd(Model model) {
		return "front/addalgorithm";
	}

	@RequestMapping(value = "/front/add", method = RequestMethod.POST)
	public String frontAdd(AlgorithmDto algorithmDto, MultipartFile thesis, MultipartFile algorithm, HttpSession session) throws IOException {
		Channel channel = channelService.getChannel(algorithmDto.getCid());
		Algorithm algorithm2 = algorithmDto.getAlgorithm();
		algorithm2.setChannel(channel);
		algorithm2.setUser((User) session.getAttribute("loginUser"));
		algorithm2.setDateCreated(new Date());
		algorithm2.setDateModified(new Date());
		algorithm2.setStatus(1);
		String thesisExt = FilenameUtils.getExtension(thesis.getOriginalFilename());
		String algorithmExt = FilenameUtils.getExtension(algorithm.getOriginalFilename());
		algorithm2.setNewAlgirithmName(String.valueOf("algorithm" + new Date().getTime()) + "." + algorithmExt);
		algorithm2.setNewThesisName(String.valueOf("thesis" + new Date().getTime()) + "." + thesisExt);
		algorithm2.setOldAlgirithmName(FilenameUtils.getBaseName(algorithm.getOriginalFilename()) + "." + algorithmExt);
		algorithm2.setOldThesisName(FilenameUtils.getBaseName(thesis.getOriginalFilename()) + "." + thesisExt);
		String realPath = session.getServletContext().getRealPath("/");
		algorithmService.addAlgorithm(realPath, algorithm2, thesis.getInputStream(), algorithm.getInputStream());
		System.out.println(algorithm2.toString());
		return "redirect:/";
	}

	@RequestMapping("/front/find/{con}")
	public String find(@PathVariable String con, Integer pcid, Pager pager, Model model) throws UnsupportedEncodingException {
		System.out.println(pager.toString());
		model.addAttribute("pagerJson", algorithmService.find(pager, pcid, con));
		model.addAttribute("pcid", pcid);
		model.addAttribute("con", con);
		return "front/findalgorithm";
	}

	@RequestMapping("/front/detail/{id}")
	public String detailAlgorithm(@PathVariable Integer id, Model model, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("/");
		String path = realPath + "/resources/upload/";

		Algorithm algorithm = algorithmService.getAlgorithm(id);
		FileInputStream fis = new FileInputStream(path + algorithm.getNewThesisName());
		HWPFDocument hwpfd = new HWPFDocument(fis);
		WordExtractor wordExtractor = new WordExtractor(hwpfd);
		String[] paragraph = wordExtractor.getParagraphText();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < paragraph.length; i++) {
			sb.append(paragraph[i] + "<br>");
		}
		model.addAttribute("word", sb.toString());
		model.addAttribute("algorithm", algorithm);
		return "front/detailalgorithm";
	}

	@RequestMapping(value = "/front/isPermission/{id}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String isPermission(@PathVariable Integer id, HttpSession session) {
		Json json = new Json();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			json.setSuccess(false);
			json.setMsg("请先登陆");
		} else {
			UserAlgorithm userAlgorithm = userAlgorithmService.get(user.getId(), id);
			Algorithm algorithm = algorithmService.getAlgorithm(id);
			if (userAlgorithm != null || algorithm.getUser().getId() == user.getId()) {
				json.setSuccess(true);
				json.setObj(1);
			} else {
				if (user.getScore() > algorithm.getScore()) {
					json.setSuccess(true);
					json.setObj(0);
				} else {
					json.setSuccess(false);
					json.setMsg("对不起，您的积分不足！");
				}
			}
		}

		return JSON.toJSONString(json);
	}

	public Json permission(Integer id, HttpSession session) {
		Json json = new Json();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			json.setSuccess(false);
			json.setMsg("请先登陆");
		} else {
			UserAlgorithm userAlgorithm = userAlgorithmService.get(user.getId(), id);
			Algorithm algorithm = algorithmService.getAlgorithm(id);
			if (userAlgorithm != null || algorithm.getUser().getId() == user.getId()) {
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
				json.setMsg("对不起，您的还没有购买该算法，请先购买！");
			}
		}
		return json;
	}

	@RequestMapping(value = "/front/addUserAlgorithm/{id}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String addUserAlgorithm(@PathVariable Integer id, HttpSession session) {
		Json json = new Json();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			json.setSuccess(false);
			json.setMsg("请先登陆");
		} else {
			Algorithm algorithm = algorithmService.getAlgorithm(id);
			if (user.getScore() >= algorithm.getScore()) {
				userAlgorithmService.add(user, algorithm);
				json.setSuccess(true);
				System.out.println("111111111111");
			} else {
				json.setSuccess(false);
				json.setMsg("对不起，您的积分不足！");
				System.out.println("2222222222");
			}
		}
		return JSON.toJSONString(json);
	}

	@RequestMapping("/front/downloadThesis/{id}")
	public void downloadThesis(@PathVariable Integer id, HttpServletResponse response, HttpSession session) throws Exception {
		Algorithm algorithm = algorithmService.getAlgorithm(id);
		OutputStream os = response.getOutputStream();
		Json json = permission(id, session);
		
		try {
			if(json.isSuccess()) {
				String realPath = session.getServletContext().getRealPath("/");
				String path = realPath + "/resources/upload/";
				File file = new File(path + algorithm.getNewThesisName());
				response.reset();
				response.setHeader("Content-Disposition", "attachment;filename=1.doc");
				response.setContentType("application/octet-stream; charset=utf-8");
				os.write(FileUtils.readFileToByteArray(file));
			} else {
				os.write(json.getMsg().getBytes());
			}
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	@RequestMapping("/front/downloadAlgorithm/{id}")
	public void downloadAlgorithm(@PathVariable Integer id, HttpServletResponse response, HttpSession session) throws Exception {
		Algorithm algorithm = algorithmService.getAlgorithm(id);
		String realPath = session.getServletContext().getRealPath("/");
		String path = realPath + "/resources/upload/";
		File file = new File(path + algorithm.getNewAlgirithmName());
		OutputStream os = response.getOutputStream();
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename=" + algorithm.getOldAlgirithmName());
			response.setContentType("application/octet-stream; charset=utf-8");
			os.write(FileUtils.readFileToByteArray(file));
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
}
