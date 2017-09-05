package com.t.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import com.t.dao.ChannelDataDao;
import com.t.dao.TagDao;
import com.t.domain.ChannelData;
import com.t.domain.Tag;

public class TagResponse {
	
	public void response() {
		try {
			DataOutputStream dos = new DataOutputStream(TagData.SOCKET.getOutputStream());
			TagDao tagDao = new TagDao();
			Tag tag = tagDao.findOneTagByName(TagData.TAGNAME);
			String id = tag.getId();
			String s = tag.getS();
			String hash = tag.getHash();
			String r = TagData.R;
			String h_id_r_s = EncryptionAlgorithm.encryption(id + r + s);
			String data = "010332" + hash + h_id_r_s;
			ChannelData channelData = new ChannelData(RandomString.getRandomHexString(32), TagData.TAGNAME, data, new Date());
			ChannelDataDao channelDataDao = new ChannelDataDao();
			channelDataDao.addOneChannelData(channelData);
			dos.writeUTF(data);
			dos.flush();
			TagData.JTA.append("\n");
			TagData.JTA.append("±êÇ©->¶ÁÐ´Æ÷£º" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
