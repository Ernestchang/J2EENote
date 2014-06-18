/**
 * 这是一个客户端程序，可以连接服务器端
 */
package com.test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*;

public class MyClient1 {

	
	public static void main(String[] args) {
		MyClient1 mc1 = new MyClient1();
	}
	
	public MyClient1() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			// Socket()就是去连接某个服务器端，127.0.0.1表示服务器的ip，9991就是端口
			Socket s = new Socket("127.0.0.1",9991);
			// 如果s连接成功，就可以发送数据给服务器
			// 我们通过pw向s写数据，true表示即使刷新
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("你好吗，我是客户端");
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			String request = br.readLine();
			System.out.println("我是客户端，我收到服务器回送的信息：" + request);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();					
				}
				if(isr != null) {
					isr.close();
				}
				if(pw != null) {
					pw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
