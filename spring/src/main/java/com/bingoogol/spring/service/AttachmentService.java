package com.bingoogol.spring.service;

import java.util.Map;



public interface AttachmentService {
	public Map<String, Object> getAttachmentById(String id);

	public String getHashByid(String id);
}
