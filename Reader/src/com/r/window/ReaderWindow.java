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
		setTitle("RFID����ϵͳ-��д��");
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
		JMenuItem open = new JMenuItem("������д��");
		JMenuItem connDB = new JMenuItem("���Ӻ�̨������");
		JMenuItem exit = new JMenuItem("�˳�");
		JMenuItem selectReader = new JMenuItem("ѡ���д��");
		JMenuItem impersonationAttack = new JMenuItem("��ð����");
		JMenuItem replayAttack = new JMenuItem("�طŹ���");
		JMenuItem clear = new JMenuItem("����ı�");
		JMenuItem about = new JMenuItem("��������");
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
		JTextArea jta = new JTextArea("ϵͳ����ӭʹ��RFID����ϵͳ��");
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
				int n = JOptionPane.showConfirmDialog(null, "ȷ���˳���", "�˳�", JOptionPane.YES_NO_OPTION);
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
