/**
 * 因为客户端要处于读取状态，因此我们把它做成一个线程
 */
package com.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.client.model.QQClientConServer;
import com.common.Message;

public class QQChat extends JFrame implements ActionListener,KeyListener,Runnable {

	Socket s;
	
	String sender;
	String getter;
	String info;
	String sendTime;
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JScrollPane jsp;
	JPanel jp;
	
	Date date;
	DateFormat format;
	
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public QQChat(String ownerId,String chatterId) {
		this.sender = ownerId;
		this.getter = chatterId;
		format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		jta = new JTextArea();
		jta.setEditable(false);
		jsp = new JScrollPane(jta);
		
		jtf = new JTextField(15);
		jtf.addKeyListener(this);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jb.addKeyListener(this);
		jb.setActionCommand("发送");
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle(this.sender + "正在和" + this.getter + "聊天");
		this.setIconImage(new ImageIcon("image/qq.png").getImage());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("发送")) {
			info = jtf.getText();
			date = new Date();
			sendTime = format.format(date);
			jta.append(this.sender + " " + sendTime + "\r\n " + info + "\r\n");
			jtf.setText("");
			Message ms = new Message();
			ms.setSender(this.sender);
			ms.setSendTime(this.sendTime);
			ms.setGetter(this.getter);
			ms.setInfo(this.info);
			try {
				oos = new ObjectOutputStream(QQClientConServer.s.getOutputStream());
				oos.writeObject(ms);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			info = jtf.getText();
			date = new Date();
			sendTime = format.format(date);
			jta.append(this.sender + " " + sendTime + "\r\n " + info + "\r\n");
			jtf.setText("");
			Message ms = new Message();
			ms.setSender(this.sender);
			ms.setSendTime(this.sendTime);
			ms.setGetter(this.getter);
			ms.setInfo(this.info);
			try {
				oos = new ObjectOutputStream(QQClientConServer.s.getOutputStream());
				oos.writeObject(ms);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void keyReleased(KeyEvent e) {}

	public void run() {
		while(true) {
			// 读取
			try {
				ois = new ObjectInputStream(QQClientConServer.s.getInputStream());
				Message ms = (Message)ois.readObject();
				jta.append(ms.getSender() + " " + ms.getSendTime() + "\r\n " + ms.getInfo() + "\r\n");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
