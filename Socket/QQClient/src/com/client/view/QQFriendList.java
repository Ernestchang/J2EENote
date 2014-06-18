package com.client.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QQFriendList extends JFrame implements ActionListener,MouseListener {

	//  第一张卡片
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane hyjsp;
	JLabel hys[];
    //  第二张卡片
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
	JScrollPane msrjsp;
	JLabel msrs[];
    //  第三张卡片
	JPanel jphmd1,jphmd2,jphmd3;
	JButton jphmd_jb1,jphmd_jb2,jphmd_jb3;
	JScrollPane hmdjsp;
	JLabel hmds[];
	
	CardLayout cl;
	String ownerId;
	
	public QQFriendList(String ownerId) {
		this.ownerId = ownerId;
		this.setTitle(this.ownerId);
		initjphy();
		initmsr();
		inithmd();
		cl = new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");		
		this.add(jphmd1,"3");		
		this.setIconImage(new ImageIcon("image/qq.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(200,400);
		this.setVisible(true);
		
	}
	
	// 处理第一张卡片（显示好友列表）
	public void initjphy() {
		jphy_jb1 = new JButton("我的好友");
		jphy_jb1.addActionListener(this);
		jphy_jb2 = new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		jphy_jb3 = new JButton("黑名单");
		jphy_jb3.addActionListener(this);
		
		jphy1 = new JPanel(new BorderLayout());
		// 假定有50个好友
		jphy2 = new JPanel(new GridLayout(50,1,5,5));
		// 给jphy2初始化50个好友
		hys = new JLabel[50];
		for(int i = 0;i < hys.length;i++) {
			hys[i] = new JLabel("我的好友" + (i + 1),new ImageIcon("image/hy.png"),JLabel.LEFT);
			hys[i].addMouseListener(this);
			jphy2.add(hys[i]);
		}
		hyjsp = new JScrollPane(jphy2);
		
		jphy3 = new JPanel(new GridLayout(2,1));
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		
		
		jphy1.add(jphy_jb1,"North");
		jphy1.add(hyjsp,"Center");
		jphy1.add(jphy3,"South");
	}
	// 处理第二张卡片（显示陌生人列表）
	public void initmsr() {
		jpmsr_jb1 = new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2 = new JButton("陌生人");
		jpmsr_jb2.addActionListener(this);
		jpmsr_jb3 = new JButton("黑名单");
		jpmsr_jb3.addActionListener(this);
		
		jpmsr1 = new JPanel(new BorderLayout());
		// 假定有20个陌生人
		jpmsr2 = new JPanel(new GridLayout(20,1,5,5));
		// 给jpmsr2初始化20个陌生人
		msrs = new JLabel[20];
		for(int i = 0;i < msrs.length;i++) {
			msrs[i] = new JLabel("陌生人" + (i + 1),new ImageIcon("image/msr.png"),JLabel.LEFT);
			msrs[i].addMouseListener(this);
			jpmsr2.add(msrs[i]);
		}
		msrjsp = new JScrollPane(jpmsr2);
		
		jpmsr3 = new JPanel(new GridLayout(2,1));
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(msrjsp,"Center");
		jpmsr1.add(jpmsr_jb3,"South");
	}
	// 处理第三张卡片（显示黑名单列表）
	public void inithmd() {
		jphmd_jb1 = new JButton("我的好友");
		jphmd_jb1.addActionListener(this);
		jphmd_jb2 = new JButton("陌生人");
		jphmd_jb2.addActionListener(this);
		jphmd_jb3 = new JButton("黑名单");
		jphmd_jb3.addActionListener(this);
		
		jphmd1 = new JPanel(new BorderLayout());
		// 假定有20个黑名单
		jphmd2 = new JPanel(new GridLayout(20,1,5,5));
		// 给jphmd2初始化20个黑名单人员
		hmds = new JLabel[20];
		for(int i = 0;i < hmds.length;i++) {
			hmds[i] = new JLabel("黑名单" + (i + 1),new ImageIcon("image/hmd.png"),JLabel.LEFT);
			hmds[i].addMouseListener(this);
			jphmd2.add(hmds[i]);
		}
		hmdjsp = new JScrollPane(jphmd2);
		
		jphmd3 = new JPanel(new GridLayout(3,1));
		jphmd3.add(jphmd_jb1);
		jphmd3.add(jphmd_jb2);
		jphmd3.add(jphmd_jb3);
		
		jphmd1.add(jphmd3,"North");
		jphmd1.add(hmdjsp,"Center");
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			// 得到该好友的编号
			String chatterId = ((JLabel)e.getSource()).getText();
			QQChat qqChat = new QQChat(this.ownerId,chatterId);
			Thread t = new Thread(qqChat);
			t.start();
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.red);
	}

	public void mouseExited(MouseEvent e) {
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.black);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jphy_jb2) {
			cl.show(this.getContentPane(),"2");
		} else if(e.getSource() == jphy_jb3) {
			cl.show(this.getContentPane(),"3");
		} else if(e.getSource() == jpmsr_jb1) {
			cl.show(this.getContentPane(),"1");
		} else if(e.getSource() == jpmsr_jb3) {
			cl.show(this.getContentPane(),"3");
		} else if(e.getSource() == jphmd_jb1) {
			cl.show(this.getContentPane(),"1");
		} else if(e.getSource() == jphmd_jb2) {
			cl.show(this.getContentPane(),"2");
		}
	}

}
