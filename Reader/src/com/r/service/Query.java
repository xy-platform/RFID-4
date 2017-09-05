package com.r.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import com.r.dao.ChannelDataDao;
import com.r.domain.ChannelData;

public class Query {
	
	public void query(String r) {
		try {
			DataOutputStream dos = new DataOutputStream(ReaderData.SOCKET_READER_TAG.getOutputStream());
			String data = "010216" + r;
			ChannelData channelData = new ChannelData(RandomString.getRandomHexString(32), ReaderData.READERNAME, data, new Date());
			ChannelDataDao channelDataDao = new ChannelDataDao();
			channelDataDao.addOneChannelData(channelData);
			dos.writeUTF(data);
			dos.flush();
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("��д��->��ǩ��" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
