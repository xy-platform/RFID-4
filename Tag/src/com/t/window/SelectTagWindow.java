package com.t.window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.t.dao.TagDao;
import com.t.domain.Tag;
import com.t.service.TagData;

public class SelectTagWindow extends JFrame {
	
	public SelectTagWindow() {
		setTitle("ѡ���ǩ");
		setSize(230, 70);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		setLayout(flowLayout);	
		JLabel label = new JLabel("��ǩ��");
		JComboBox selectTag=new JComboBox();
		selectTag.addItem("--��ѡ��--");
		TagDao tagDao = new TagDao();
		List<Tag> tagList = tagDao.findAllTag();
		for (Tag tag : tagList) {
			selectTag.addItem(tag.getName());
		}
		JButton submit = new JButton("ȷ��");
		add(label);
		add(selectTag);
		add(submit);
		validate();
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String) selectTag.getSelectedItem();
				if(!name.equals("--��ѡ��--")) {
					TagData.TAGNAME = name;
					Tag tag = tagDao.findOneTagByName(name);
					TagData.JTA.append("\n");
					TagData.JTA.append("ϵͳ��ѡ���ǩ�ɹ������б�ǩ������" + name);
					TagData.JTA.append("����ǩ������" + tag.getType());
					TagData.JTA.append("��ID��" + tag.getId());
					TagData.JTA.append("��S��" + tag.getS());
					TagData.JTA.append("��H(ID||S)��" + tag.getHash());
				}
				dispose();
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
