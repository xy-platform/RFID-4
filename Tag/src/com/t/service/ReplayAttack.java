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
			TagData.JTA.append("ϵͳ����ǩ�����ǷǷ���ǩ�������ֶ����طŹ���������������" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
