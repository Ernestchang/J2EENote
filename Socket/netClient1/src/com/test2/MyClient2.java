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
			// ���ӷ�����
			Socket s = new Socket("127.0.0.1",9992);
			// �Ƚ��շ�������������Ϣ
			isr1 = new InputStreamReader(s.getInputStream());
			br1 = new BufferedReader(isr1);
			// ���մӿ���̨�������Ϣ
			isr2 = new InputStreamReader(System.in);
			br2 = new BufferedReader(isr2);
			pw = new PrintWriter(s.getOutputStream(),true);
			while(true) {
				// �ͻ����ȴӿ���̨����
				System.out.println("����������Է�����˵�Ļ�");
				response = br2.readLine();
				// ���͸�������
				pw.println(response);
				if(response.equals("�ݰ�")) {
					System.out.println("�Ի�����");
					s.close();
					break;
				}
				// ���մӷ�������������Ϣ
				infoFromServer = br1.readLine();
				System.out.println("������2˵��" + infoFromServer);
				
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
