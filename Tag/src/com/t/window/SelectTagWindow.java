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
		setTitle("选择标签");
		setSize(230, 70);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		setLayout(flowLayout);	
		JLabel label = new JLabel("标签：");
		JComboBox selectTag=new JComboBox();
		selectTag.addItem("--请选择--");
		TagDao tagDao = new TagDao();
		List<Tag> tagList = tagDao.findAllTag();
		for (Tag tag : tagList) {
			selectTag.addItem(tag.getName());
		}
		JButton submit = new JButton("确定");
		add(label);
		add(selectTag);
		add(submit);
		validate();
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String) selectTag.getSelectedItem();
				if(!name.equals("--请选择--")) {
					TagData.TAGNAME = name;
					Tag tag = tagDao.findOneTagByName(name);
					TagData.JTA.append("\n");
					TagData.JTA.append("系统：选择标签成功，其中标签名称是" + name);
					TagData.JTA.append("，标签类型是" + tag.getType());
					TagData.JTA.append("，ID是" + tag.getId());
					TagData.JTA.append("，S是" + tag.getS());
					TagData.JTA.append("，H(ID||S)是" + tag.getHash());
				}
				dispose();
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
