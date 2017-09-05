package com.t.service;

import java.io.DataOutputStream;
import java.io.IOException;

import com.t.dao.ChannelDataDao;
import com.t.domain.ChannelData;

public class ReplayAttack {

	public void replayAttack() {
		try {
			DataOutputStream dos = new DataOutputStream(TagData.SOCKET.getOutputStream());
			ChannelDataDao channelDataDao = new ChannelDataDao();
			ChannelData channelData = channelDataDao.findOneChannelData();
			String data = channelData.getData();
			dos.writeUTF(data);
			dos.flush();
			TagData.JTA.append("\n");
			TagData.JTA.append("系统：标签类型是非法标签，攻击手段是重放攻击，其中数据是" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
