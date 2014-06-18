/**
 * 这是qq服务器，他在监听，等待某个qq客户端来连接
 */
package com.server.model;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.common.Message;
import com.common.User;

public class MyQQServer {
	ServerSocket ss;
	Socket s;
	SerConClientThread scct;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public MyQQServer() {
		
		try {
			// 在9999监听
			ss = new ServerSocket(9999);
			
			// 阻塞，等待连接
			while(true) {				
				s = ss.accept();
				System.out.println("服务器启动成功");
				// 接收客户端发来的信息
				ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();
				Message ms = new Message();
				oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("2")) {
					ms.setMesType("1");
					oos.writeObject(ms);
					// 这里就单开一个线程，让该线程与该客户端保持通讯
					scct = new SerConClientThread(s);
					ManageClientThread.addClientThread(u.getUserId(), scct);
					// 启动与该客户端通信的线程
					scct.start();
				} else {
					ms.setMesType("2");
					oos.writeObject(ms);
					s.close();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
