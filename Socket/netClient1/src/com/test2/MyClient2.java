package com.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient2 {

	public static void main(String[] args) {
		MyClient2 mc2 = new MyClient2();
	}
	public MyClient2() {
		InputStreamReader isr1 = null;
		InputStreamReader isr2 = null;
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		PrintWriter pw = null;
		String infoFromServer = null;
		String response = null;
		try {
			// 连接服务器
			Socket s = new Socket("127.0.0.1",9992);
			// 先接收服务器发来的信息
			isr1 = new InputStreamReader(s.getInputStream());
			br1 = new BufferedReader(isr1);
			// 接收从控制台输入的信息
			isr2 = new InputStreamReader(System.in);
			br2 = new BufferedReader(isr2);
			pw = new PrintWriter(s.getOutputStream(),true);
			while(true) {
				// 客户端先从控制台接收
				System.out.println("请输入你想对服务器说的话");
				response = br2.readLine();
				// 发送给服务器
				pw.println(response);
				if(response.equals("拜拜")) {
					System.out.println("对话结束");
					s.close();
					break;
				}
				// 接收从服务器发来的信息
				infoFromServer = br1.readLine();
				System.out.println("服务器2说：" + infoFromServer);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br1 != null) {
					br1.close();
				}
				if (isr1 != null) {
					isr1.close();
				}
				if (br2 != null) {
					br2.close();
				}
				if (isr2 != null) {
					isr2.close();
				}
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
