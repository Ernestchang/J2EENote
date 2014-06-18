/**
 * 客户端
 */
package com.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyClient3 extends JFrame implements ActionListener,KeyListener  {

	ServerSocket ss = null;
	Socket s = null;
	
	InputStreamReader isr = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	String infoFromServer = null;
	String response = null;
	
	JTextArea jta = null;
	JTextField jtf = null;
	JButton jb = null;
	JScrollPane jsp = null;
	JPanel jp = null;
	
	Date date = null;
	DateFormat format = null;
	
	public static void main(String[] args) {
		MyClient3 ms3 = new MyClient3();
	}
	public MyClient3() {
		
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
		this.setTitle("客户端");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
		
		try {
			s = new Socket("127.0.0.1",9993);
			pw = new PrintWriter(s.getOutputStream(),true);
			// 先接收客户端发来的信息
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			while (true) {
				// 接收从服务器端发来的信息
				infoFromServer = br.readLine();
				date = new Date();
				jta.append(" 服务器端  "+ format.format(date) + "\r\n " + infoFromServer + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("发送")) {
			response = jtf.getText();
			date = new Date();
			jta.append(" 客户端  "+ format.format(date) + "\r\n " + response + "\r\n");
			jtf.setText("");
			pw.println(response);
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			response = jtf.getText();
			date = new Date();
			jta.append(" 服务器端  "+ format.format(date) + "\r\n " + response + "\r\n");
			jtf.setText("");
			pw.println(response);
		}
	}
	public void keyReleased(KeyEvent e) {}

}
