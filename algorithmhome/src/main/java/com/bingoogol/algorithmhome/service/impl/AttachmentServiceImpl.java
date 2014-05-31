package com.bingoogol.algorithmhome.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingoogol.algorithmhome.dao.AttachmentDao;
import com.bingoogol.algorithmhome.exception.IllegalClientException;
import com.bingoogol.algorithmhome.service.AttachmentService;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {
	@Resource
	private AttachmentDao attachmentDao;

	@Override
	public Map<String, Object> getAttachmentById(String id) {
		try {
			return attachmentDao.getAttachmentById(id);
		} catch (EmptyResultDataAccessException e) {
			System.err.println("getAttachmentById");
			throw new IllegalClientException("请通过正确的方式访问本网站");
		}
	}

	@Override
	public String getHashByid(String id) {
		try {
			return attachmentDao.getHashById(id);
		} catch (EmptyResultDataAccessException e) {
			System.err.println("getHashByid");
			throw new IllegalClientException("请通过正确的方式访问本网站");
		}
	}

}
