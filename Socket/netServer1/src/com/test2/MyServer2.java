/**
 * ���ܣ���һ���������ˣ���9992�˿ڼ���
 * ����ͨ������̨��������͸��ͻ��˵���Ϣ
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
			// ��9992�˿ڼ���
			System.out.println("������2��9992�˿ڼ���");
			ServerSocket ss = new ServerSocket(9992);
			// �ȴ�����
			Socket s = ss.accept();
			// �Ƚ��տͻ��˷�������Ϣ
			isr1 = new InputStreamReader(s.getInputStream());
			br1 = new BufferedReader(isr1);
			// ���մӿ���̨�������Ϣ
			isr2 = new InputStreamReader(System.in);
			br2 = new BufferedReader(isr2);
			pw = new PrintWriter(s.getOutputStream(),true);
			while (true) {
				// ���մӿͻ��˷�������Ϣ
				infoFromClient = br1.readLine();
				if (infoFromClient.equals("�ݰ�")) {
					System.out.println("�Ի�����");
					s.close();
					break;
				}
				System.out.println("�ͻ���˵��" + infoFromClient);
				// ���մӿ���̨�������Ϣ
				System.out.println("������ϣ���Կͻ���˵�Ļ�");
				response = br2.readLine();
				// �Ѵӿ���̨���յ���Ϣ���͸��ͻ���
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
