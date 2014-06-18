/**
 * ���ǵ�һ���������˳���������9999�˿ڼ���
 * ���Խ��մӿͻ��˷�������Ϣ
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
			// ��9999�˿ڼ���
			// ֻ������һ����java.net.BindException: Address already in use: JVM_Bind
			ServerSocket ss = new ServerSocket(9991);
			System.out.println("���Ƿ���������9991�˿ڼ���");
			// �ȴ�ĳ���ͻ��������ӣ��ú����᷵��һ��Scoket����
			Socket s = ss.accept();
			// Ҫ��ȡs�д��ݵ�����
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			String info = br.readLine();
			System.out.println("���������յ���" + info);
			
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("���Ƿ���ˣ���Ҳ��");
			
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
