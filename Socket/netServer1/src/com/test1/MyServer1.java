/**
 * 这是第一个服务器端程序，让它在9999端口监听
 * 可以接收从客户端发来的信息
 */
package com.test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {
	
	public static void main(String[] args) {
		MyServer1 ms1 = new MyServer1();
	}
	
	public MyServer1() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			// 在9999端口监听
			// 只能启动一个：java.net.BindException: Address already in use: JVM_Bind
			ServerSocket ss = new ServerSocket(9991);
			System.out.println("我是服务器，在9991端口监听");
			// 等待某个客户端来连接，该函数会返回一个Scoket连接
			Socket s = ss.accept();
			// 要读取s中传递的数据
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			String info = br.readLine();
			System.out.println("服务器接收到：" + info);
			
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("我是服务端，你也好");
			
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
