/**
 * 功能是服务器和某个客户端的通信线程
 */
package com.server.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;

public class SerConClientThread extends Thread {
	
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public SerConClientThread(Socket s) {
		// 把服务器和客户端的连接赋给s
		this.s = s;
	}
	
	public void run() {
		while(true) {
			// 这里该线程就可以接受客户端的信息
			try {
				ois = new ObjectInputStream(s.getInputStream());
				Message ms = (Message)ois.readObject();
				// 取得接受认得通讯线程
				SerConClientThread sct = ManageClientThread.getClientThread(ms.getGetter());
				oos = new ObjectOutputStream(sct.s.getOutputStream());
				oos.writeObject(ms);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
