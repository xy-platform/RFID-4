package com.s.window;

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

import com.s.service.CreateR;
import com.s.service.OpenServer;
import com.s.service.ServerData;

public class ServerWindow extends JFrame {
	
	public ServerWindow() {
		setTitle("RFID仿真系统-后台服务器");
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
		JMenuItem open = new JMenuItem("启动后台服务器");
		JMenuItem exit = new JMenuItem("退出");
		JMenuItem run = new JMenuItem("开始认证");
		JMenuItem clear = new JMenuItem("清除文本");
		JMenuItem about = new JMenuItem("关于我们");
		file.add(open);
		file.addSeparator();
		file.add(exit);
		tool.add(run);
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
		ServerData.JTA = jta;
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenServer().open();
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
		run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ServerData.SOCKET != null) {
					new CreateR().createR();
				} else {
					JOptionPane.showMessageDialog(null, "请连通后台服务器和读写器的通信链路！", "通信链路", JOptionPane.WARNING_MESSAGE);
				}
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
