package com.r.service;

import java.io.DataOutputStream;
import java.io.IOException;

import com.r.dao.ChannelDataDao;
import com.r.domain.ChannelData;

public class ReplayAttack {

	public void replayAttack() {
		try {
			DataOutputStream dos = new DataOutputStream(ReaderData.SOCKET_READER_TAG.getOutputStream());
			ChannelDataDao channelDataDao = new ChannelDataDao();
			ChannelData channelData = channelDataDao.findOneChannelData();
			String data = channelData.getData();
			dos.writeUTF(data);
			dos.flush();
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("ϵͳ����д�������ǷǷ���д���������ֶ����طŹ���������������" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
