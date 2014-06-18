package com.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.client.model.QQClientUser;
import com.common.User;

public class QQClientLogin extends JFrame implements ActionListener {

	// 定义北部
	JLabel jl1;
	// 定义中部
	JPanel jp2,jp3;
	JTextField jtf;
	JPasswordField jpf;
	JLabel jp2_jl1,jp3_jl1,jp3_jl2;
	JCheckBox jcb1,jcb2;
	// 定义南部
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	public static void main(String[] args) {
		QQClientLogin qcl = new QQClientLogin();
	}
	
	public QQClientLogin() {
		
		// 北部
		jl1 = new JLabel(new ImageIcon("image/top.png"));
		
		// 中部
		jp2 = new JPanel();
		jp2.setBackground(new Color(208,217,225));
		jp2_jl1 = new JLabel(new ImageIcon("image/left.png"),JLabel.CENTER);
		jp3 = new JPanel();
		jp3.setBackground(new Color(208,217,225));
		jp3.setLayout(new GridLayout(3,3,6,6));
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);
		jp3_jl1 = new JLabel("注册账号");
		jp3_jl1.setForeground(new Color(100,171,224));
		jp3_jl2 = new JLabel("找回密码");
		jp3_jl2.setForeground(new Color(100,171,224));
		jcb1 = new JCheckBox("记住密码");
		jcb1.setBackground(new Color(208,217,225));
		jcb2 = new JCheckBox("自动登录");
		jcb2.setBackground(new Color(208,217,225));
		jp3.add(jtf);
		jp3.add(jp3_jl1);
		jp3.add(jpf);
		jp3.add(jp3_jl2);
		jp3.add(jcb1);
		jp3.add(jcb2);
		jp2.add(new JLabel("   "));
		jp2.add(jp2_jl1);
		jp2.add(new JLabel("        "));
		jp2.add(jp3);
		// 南部
		jp1 = new JPanel();
		jp1.setBackground(new Color(208,217,225));
		jp1_jb1 = new JButton(new ImageIcon("image/jb1.png"));
		jp1_jb1.setPreferredSize(new Dimension(65, 19));
		jp1_jb2 = new JButton(new ImageIcon("image/jb2.png"));
		jp1_jb2.setPreferredSize(new Dimension(65, 19));
		jp1_jb3 = new JButton(new ImageIcon("image/jb3.png"));
		jp1_jb3.addActionListener(this);
		jp1_jb3.setPreferredSize(new Dimension(65, 19));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(new JLabel("                                                "));
		jp1.add(jp1_jb3);
		this.setTitle("QQ2012");
		this.setIconImage(new ImageIcon("image/qq.png").getImage());
		this.add(jl1,"North");
		this.add(jp2);
		this.add(jp1,"South");
		this.setSize(380,280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jp1_jb3) {
			QQClientUser qqClientUser = new QQClientUser();
			User u = new User();
			u.setUserId(jtf.getText().trim());
			u.setPasswd(new String(jpf.getPassword()));
			if(qqClientUser.checkUser(u)) {
				new QQFriendList(u.getUserId());
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
			}
		}
	}
	

}
