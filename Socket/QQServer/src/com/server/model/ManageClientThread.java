package com.server.model;

import java.util.HashMap;

public class ManageClientThread {
	public static HashMap<String,SerConClientThread> hm = new HashMap<String,SerConClientThread>();
	// ��hm�����һ���ͻ���ͨѶ�߳�
	public static void addClientThread(String sender,SerConClientThread sct) {
		hm.put(sender, sct);
	}
	public static SerConClientThread getClientThread(String sender) {
		return (SerConClientThread)hm.get(sender);
	}
}
