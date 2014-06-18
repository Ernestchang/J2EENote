/**
 * �����Ƿ�������ĳ���ͻ��˵�ͨ���߳�
 */
package com.server.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;

public class SerConClientThread extends Thread {
	
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public SerConClientThread(Socket s) {
		// �ѷ������Ϳͻ��˵����Ӹ���s
		this.s = s;
	}
	
	public void run() {
		while(true) {
			// ������߳̾Ϳ��Խ��ܿͻ��˵���Ϣ
			try {
				ois = new ObjectInputStream(s.getInputStream());
				Message ms = (Message)ois.readObject();
				// ȡ�ý����ϵ�ͨѶ�߳�
				SerConClientThread sct = ManageClientThread.getClientThread(ms.getGetter());
				oos = new ObjectOutputStream(sct.s.getOutputStream());
				oos.writeObject(ms);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
