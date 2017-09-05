package com.s.service;

import java.io.DataOutputStream;
import java.io.IOException;

import com.s.dao.TagDao;
import com.s.domain.Tag;

public class TagAuthentication {

	public void authentication(String tag_hash, String tag_h_id_r_s) {
		TagDao tagDao = new TagDao();
		Tag tag = tagDao.findOneTagByHash(tag_hash);
		if (tag != null) {
			String id_r_s = tag.getId() + ServerData.R + tag.getS();
			String reader_h_id_r_s = EncryptionAlgorithm.encryption(id_r_s);
			if (tag_h_id_r_s.equals(reader_h_id_r_s)) {
				ServerData.JTA.append("\n");
				ServerData.JTA.append("ϵͳ����ǩ��֤ͨ����");
				String s = EncryptionAlgorithm.encryption(ServerData.R + tag.getS());
				String hash = EncryptionAlgorithm.encryption(tag.getId() + s);
				tagDao.updateTagSAndHashById(tag.getId(), s, hash);
				try {
					DataOutputStream dos = new DataOutputStream(ServerData.SOCKET.getOutputStream());
					String data = "010516" + EncryptionAlgorithm.encryption(tag.getId() + ServerData.R + s);
					dos.writeUTF(data);
					dos.flush();
					ServerData.JTA.append("\n");
					ServerData.JTA.append("��̨������->��д����" + data);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				ServerData.JTA.append("\n");
				ServerData.JTA.append("ϵͳ����ǩ��֤��ͨ����");
			}
		} else {
			ServerData.JTA.append("\n");
			ServerData.JTA.append("ϵͳ����ǩ��֤��ͨ����");
		}
	}
	
}
