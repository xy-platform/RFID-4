package com.r.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.r.service.ConnServer;
import com.r.service.ImpersonationAttack;
import com.r.service.OpenReader;
import com.r.service.ReaderData;
import com.r.service.ReplayAttack;

public class ReaderWindow extends JFrame {
	
	public ReaderWindow() {
		setTitle("RFID仿真系统-读写器");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("文件");
		JMenu tool = new JMenu("工具");
		JMenu help = new JMenu("帮助");
		menubar.add(file);
		menubar.add(tool);
		menubar.add(help);
		JMenuItem open = new JMenuItem("启动读写器");
		JMenuItem connDB = new JMenuItem("连接后台服务器");
		JMenuItem exit = new JMenuItem("退出");
		JMenuItem selectReader = new JMenuItem("选择读写器");
		JMenuItem impersonationAttack = new JMenuItem("假冒攻击");
		JMenuItem replayAttack = new JMenuItem("重放攻击");
		JMenuItem clear = new JMenuItem("清除文本");
		JMenuItem about = new JMenuItem("关于我们");
		file.add(open);
		file.add(connDB);
		file.addSeparator();
		file.add(exit);
		tool.add(selectReader);
		tool.addSeparator();
		tool.add(impersonationAttack);
		tool.add(replayAttack);
		tool.addSeparator();
		tool.add(clear);
		help.add(about);
		setJMenuBar(menubar);
		JTextArea jta = new JTextArea("系统：欢迎使用RFID仿真系统！");
		jta.setLineWrap(true);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(jsp, BorderLayout.CENTER);
		validate();
		ReaderData.JTA = jta;
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenReader().open();
			}
		});
		connDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConnServer().conn();
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "确认退出吗？", "退出", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		selectReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectReaderWindow();
			}
		});
		impersonationAttack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ImpersonationAttack().impersonationAttack();
			}
		});
		replayAttack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReplayAttack().replayAttack();
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("系统：欢迎使用RFID仿真系统！");
			}
		});
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "RFID仿真系统，是一套基于Hash函数的RFID安全认证协议研究的仿真系统。系\n统包括三个模块，后台服务器、读写器和标签，模拟真实环境的RFID系统，并\n通过改进算法模拟出安全协议的认证过程。", "关于我们", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
