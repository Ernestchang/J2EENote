package com.bingoogol.algorithmhome.dao;

import java.util.Map;

public interface AttachmentDao {
	public int addAttachment(String id, String name, String hash);

	public Map<String, Object> getAttachmentById(String id);

	public String getHashById(String id);
}
