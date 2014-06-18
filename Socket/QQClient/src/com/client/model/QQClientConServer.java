/**
 * 这是客户端连接服务器后台
 */
package com.client.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;

public class QQClientConServer {
	public static Socket s;
	Message ms;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	// 发送第一次请求
	public boolean sendLoginInfoToServer(Object o) {
		boolean b = false;
		try {
			s = new Socket("127.0.0.1",9999);
			oos = new ObjectOutputStream(s.getOutputStream());
			System.out.println();
			oos.writeObject(o);
			ois = new ObjectInputStream(s.getInputStream());
			ms = (Message)ois.readObject();
			if(ms.getMesType().equals("1")) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public void sendInfoToServer(Object o) {
		try {
			s = new Socket("127.0.0.1",9999);
			
		} catch (Exception e) {
			
		} finally {
			
		}
	}
}
