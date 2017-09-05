package com.t.service;

import com.t.dao.TagDao;
import com.t.domain.Tag;

public class ReaderAuthentication {

	public void authentication(String reader_h_id_r_s) {
		TagDao tagDao = new TagDao();
		Tag tag = tagDao.findOneTagByName(TagData.TAGNAME);
		String s = EncryptionAlgorithm.encryption(TagData.R + tag.getS());
		String hash = EncryptionAlgorithm.encryption(tag.getId() + s);
		String tag_h_id_r_s = EncryptionAlgorithm.encryption(tag.getId() + TagData.R + s);;
		if (reader_h_id_r_s.equals(tag_h_id_r_s)) {
			tagDao.updateTagSAndHashById(tag.getId(), s, hash);
			TagData.JTA.append("\n");
			TagData.JTA.append("ϵͳ����д����֤ͨ����");
			TagData.JTA.append("\n");
			TagData.JTA.append("ϵͳ��" + TagData.TAGNAME + "�ѽ�����������" + TagData.TAGNAME + "��S��H(ID||S)����");
			TagData.JTA.append("�����и��º�S��" + s);
			TagData.JTA.append("��H(ID||S)��" + hash);
		} else {
			TagData.JTA.append("\n");
			TagData.JTA.append("ϵͳ����д����֤��ͨ����");
		}
	}
	
}
