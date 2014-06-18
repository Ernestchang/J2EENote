/**
 * ����һ���ͻ��˳��򣬿������ӷ�������
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
			// Socket()����ȥ����ĳ���������ˣ�127.0.0.1��ʾ��������ip��9991���Ƕ˿�
			Socket s = new Socket("127.0.0.1",9991);
			// ���s���ӳɹ����Ϳ��Է������ݸ�������
			// ����ͨ��pw��sд���ݣ�true��ʾ��ʹˢ��
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("��������ǿͻ���");
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			String request = br.readLine();
			System.out.println("���ǿͻ��ˣ����յ����������͵���Ϣ��" + request);
			
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
