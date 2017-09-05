package com.t.window;

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

import com.t.service.ImpersonationAttack;
import com.t.service.OpenTag;
import com.t.service.ReplayAttack;
import com.t.service.TagData;

public class TagWindow extends JFrame {
	
	public TagWindow() {
		setTitle("RFID����ϵͳ-��ǩ");
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
		JMenuItem connR = new JMenuItem("���Ӷ�д��");
		JMenuItem exit = new JMenuItem("�˳�");
		JMenuItem selectTag = new JMenuItem("ѡ���ǩ");
		JMenuItem impersonationAttack = new JMenuItem("��ð����");
		JMenuItem replayAttack = new JMenuItem("�طŹ���");
		JMenuItem clear = new JMenuItem("����ı�");
		JMenuItem about = new JMenuItem("��������");
		file.add(connR);
		file.addSeparator();
		file.add(exit);
		tool.add(selectTag);
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
		TagData.JTA = jta;
		connR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenTag().open();
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
		selectTag.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTagWindow();
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
