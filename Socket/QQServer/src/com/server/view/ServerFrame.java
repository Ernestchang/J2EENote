/**
 * ���Ƿ������˵Ŀ��ƽ��棬��������������������رշ�����
 * ���Թ���ͼ���û�
 */
package com.server.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.server.model.MyQQServer;

public class ServerFrame extends JFrame implements ActionListener {
	
	JPanel jp1;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		ServerFrame sf = new ServerFrame();
	}
	
	public ServerFrame() {
		jp1 = new JPanel();
		jb1 = new JButton("����������");
		jb1.addActionListener(this);
		jb2 = new JButton("�رշ�����");
		jb2.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			new MyQQServer();
			System.out.println("new MyQQServer();");
		} else if(e.getSource() == jb2) {
			System.exit(0);
		}
	}
}
