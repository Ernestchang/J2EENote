/**
 * 演示对象序列化
 */
package com.test4;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.common.User;

public class Myserver {

	ServerSocket ss;
	Socket s;
	User u;
	ObjectInputStream ois;
	public static void main(String[] args) {
		Myserver ms4 = new Myserver(); 
	}
	
	public Myserver() {
		try {
			System.out.println("在9994端口监听");
			ss = new ServerSocket(9994);
			s = ss.accept();
			ois = new ObjectInputStream(s.getInputStream());
			u = (User) ois.readObject();
			System.out.println("用户名：" + u.getName() + "  密码：" + u.getPass());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(s != null) {
					s.close();
				}
				if(ss != null) {
					ss.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
