/**
 * 功能，是一个服务器端，在9992端口监听
 * 可以通过控制台，输入回送给客户端的信息
 */
package com.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer2 {

	public static void main(String[] args) {
		MyServer2 ms2 = new MyServer2();
	}

	public MyServer2() {
		InputStreamReader isr1 = null;
		InputStreamReader isr2 = null;
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		PrintWriter pw = null;
		String infoFromClient = null;
		String response = null;
		try {
			// 在9992端口监听
			System.out.println("服务器2在9992端口监听");
			ServerSocket ss = new ServerSocket(9992);
			// 等待连接
			Socket s = ss.accept();
			// 先接收客户端发来的信息
			isr1 = new InputStreamReader(s.getInputStream());
			br1 = new BufferedReader(isr1);
			// 接收从控制台输入的信息
			isr2 = new InputStreamReader(System.in);
			br2 = new BufferedReader(isr2);
			pw = new PrintWriter(s.getOutputStream(),true);
			while (true) {
				// 接收从客户端发来的信息
				infoFromClient = br1.readLine();
				if (infoFromClient.equals("拜拜")) {
					System.out.println("对话结束");
					s.close();
					break;
				}
				System.out.println("客户端说：" + infoFromClient);
				// 接收从控制台输入的信息
				System.out.println("输入你希望对客户端说的话");
				response = br2.readLine();
				// 把从控制台接收的信息会送给客户端
				pw.println(response);
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
