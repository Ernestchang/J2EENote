package com.bingoogol.algorithm.web.controller;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {

	@RequestMapping("/test1")
	public String test1(Model model) throws Exception {
		FileInputStream fis = new FileInputStream("e:/test/1.doc");
		HWPFDocument hwpfd = new HWPFDocument(fis);
		WordExtractor wordExtractor = new WordExtractor(hwpfd);
		String[] paragraph = wordExtractor.getParagraphText();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < paragraph.length; i++) {
			sb.append(paragraph[i] + "<br>");
		}
		model.addAttribute("word", sb.toString());
		return "test";
	}
}
