/**
 * 演示对象序列化
 */
package com.test4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.User;

public class MyClient {

	Socket s;
	User u;
	ObjectOutputStream oos;
	public static void main(String[] args) {
		MyClient mc4 = new MyClient();
	}
	public MyClient() {
		
		try {
			s = new Socket("127.0.0.1",9994);
			oos = new ObjectOutputStream(s.getOutputStream());
			u = new User();
			u.setName("王浩");
			u.setPass("bingo");
			oos.writeObject(u);
			System.out.println(u.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
				if(s != null) {
					s.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
