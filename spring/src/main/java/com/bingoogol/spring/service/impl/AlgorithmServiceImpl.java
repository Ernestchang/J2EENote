package com.bingoogol.spring.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingoogol.spring.dao.AlgorithmDao;
import com.bingoogol.spring.dao.AttachmentDao;
import com.bingoogol.spring.dto.AddAlgorithmDto;
import com.bingoogol.spring.dto.Pager;
import com.bingoogol.spring.dto.PagerJson;
import com.bingoogol.spring.exception.IllegalClientException;
import com.bingoogol.spring.service.AlgorithmService;

@Service
@Transactional
public class AlgorithmServiceImpl implements AlgorithmService {
	@Resource
	private AlgorithmDao algorithmDao;
	@Resource
	private AttachmentDao attachmentDao;

	@Override
	public boolean addAlgorithm(AddAlgorithmDto addAlgorithmDto) {
		String codeid = UUID.randomUUID().toString();
		String iodataid = UUID.randomUUID().toString();
		String thesisid = UUID.randomUUID().toString();
		if(attachmentDao.addAttachment(codeid, addAlgorithmDto.getCodeName(), addAlgorithmDto.getCodeHash()) + attachmentDao.addAttachment(iodataid, addAlgorithmDto.getIodataName(), addAlgorithmDto.getIodataHash()) + attachmentDao.addAttachment(thesisid, addAlgorithmDto.getThesisName(), addAlgorithmDto.getThesisHash()) == 3) {
			addAlgorithmDto.setCode(codeid);
			addAlgorithmDto.setIodata(iodataid);
			addAlgorithmDto.setThesis(thesisid);
			addAlgorithmDto.setId(UUID.randomUUID().toString());
			if(algorithmDao.addAlgorithm(addAlgorithmDto) == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Map<String, Object> getAlgorithmById(String id) {
		try {
			return algorithmDao.getAlgorithmById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new IllegalClientException("请通过正确的方式访问本网站");
		}
	}

	@Override
	public List<Map<String, Object>> notvertifylist(String uid) {
		return algorithmDao.notvertifylist(uid);
	}

	@Override
	public boolean changeStatus(String id, String mender, int status) {
		if(algorithmDao.changeStatus(id, mender,status) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> listchannel2(int cid) {
		return algorithmDao.listchannel2(cid);
	}

	@Override
	public PagerJson listchannel3(Pager pager, int cid) {
		if (pager.getPage() < 1) {
			pager.setPage(1);
		}
		if (pager.getRows() < 1) {
			pager.setRows(6);
		}
		return algorithmDao.listchannel3(pager, cid);
	}

	@Override
	public PagerJson find(Pager pager, String key) {
		return algorithmDao.find(pager, key);
	}

}
