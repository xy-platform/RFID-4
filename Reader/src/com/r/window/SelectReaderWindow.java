package com.r.window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.r.dao.ReaderDao;
import com.r.domain.Reader;
import com.r.service.ReaderData;

public class SelectReaderWindow extends JFrame {
	
	public SelectReaderWindow() {
		setTitle("ѡ���д��");
		setSize(250, 70);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		setLayout(flowLayout);	
		JLabel label = new JLabel("��д����");
		JComboBox selectReader=new JComboBox();
		selectReader.addItem("--��ѡ��--");
		ReaderDao readerDao = new ReaderDao();
		List<Reader> readerList = readerDao.findAllReader();
		for (Reader reader : readerList) {
			selectReader.addItem(reader.getName());
		}
		JButton submit = new JButton("ȷ��");
		add(label);
		add(selectReader);
		add(submit);
		validate();
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String) selectReader.getSelectedItem();
				if(!name.equals("--��ѡ��--")) {
					ReaderData.READERNAME = name;
					String type = readerDao.findReaderTypeByName(name);
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("ϵͳ��ѡ���д���ɹ������ж�д��������" + name);
					ReaderData.JTA.append("����д��������" + type);
				}
				dispose();
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
