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
		setTitle("RFID����ϵͳ-��̨������");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("�ļ�");
		JMenu tool = new JMenu("����");
		JMenu help = new JMenu("����");
		menubar.add(file);
		menubar.add(tool);
		menubar.add(help);
		JMenuItem open = new JMenuItem("������̨������");
		JMenuItem exit = new JMenuItem("�˳�");
		JMenuItem run = new JMenuItem("��ʼ��֤");
		JMenuItem clear = new JMenuItem("����ı�");
		JMenuItem about = new JMenuItem("��������");
		file.add(open);
		file.addSeparator();
		file.add(exit);
		tool.add(run);
		tool.addSeparator();
		tool.add(clear);
		help.add(about);
		setJMenuBar(menubar);
		JTextArea jta = new JTextArea("ϵͳ����ӭʹ��RFID����ϵͳ��");
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
				int n = JOptionPane.showConfirmDialog(null, "ȷ���˳���", "�˳�", JOptionPane.YES_NO_OPTION);
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
					JOptionPane.showMessageDialog(null, "����ͨ��̨�������Ͷ�д����ͨ����·��", "ͨ����·", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("ϵͳ����ӭʹ��RFID����ϵͳ��");
			}
		});
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "RFID����ϵͳ����һ�׻���Hash������RFID��ȫ��֤Э���о��ķ���ϵͳ��ϵ\nͳ��������ģ�飬��̨����������д���ͱ�ǩ��ģ����ʵ������RFIDϵͳ����\nͨ���Ľ��㷨ģ�����ȫЭ�����֤���̡�", "��������", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
