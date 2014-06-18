/**
 * ����qq�����������ڼ������ȴ�ĳ��qq�ͻ���������
 */
package com.server.model;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.common.Message;
import com.common.User;

public class MyQQServer {
	ServerSocket ss;
	Socket s;
	SerConClientThread scct;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public MyQQServer() {
		
		try {
			// ��9999����
			ss = new ServerSocket(9999);
			
			// �������ȴ�����
			while(true) {				
				s = ss.accept();
				System.out.println("�����������ɹ�");
				// ���տͻ��˷�������Ϣ
				ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();
				Message ms = new Message();
				oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("2")) {
					ms.setMesType("1");
					oos.writeObject(ms);
					// ����͵���һ���̣߳��ø��߳���ÿͻ��˱���ͨѶ
					scct = new SerConClientThread(s);
					ManageClientThread.addClientThread(u.getUserId(), scct);
					// ������ÿͻ���ͨ�ŵ��߳�
					scct.start();
				} else {
					ms.setMesType("2");
					oos.writeObject(ms);
					s.close();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
