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
		setTitle("选择读写器");
		setSize(250, 70);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		setLayout(flowLayout);	
		JLabel label = new JLabel("读写器：");
		JComboBox selectReader=new JComboBox();
		selectReader.addItem("--请选择--");
		ReaderDao readerDao = new ReaderDao();
		List<Reader> readerList = readerDao.findAllReader();
		for (Reader reader : readerList) {
			selectReader.addItem(reader.getName());
		}
		JButton submit = new JButton("确定");
		add(label);
		add(selectReader);
		add(submit);
		validate();
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String) selectReader.getSelectedItem();
				if(!name.equals("--请选择--")) {
					ReaderData.READERNAME = name;
					String type = readerDao.findReaderTypeByName(name);
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("系统：选择读写器成功，其中读写器名称是" + name);
					ReaderData.JTA.append("，读写器类型是" + type);
				}
				dispose();
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
