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
			TagData.JTA.append("系统：读写器认证通过！");
			TagData.JTA.append("\n");
			TagData.JTA.append("系统：" + TagData.TAGNAME + "已解锁并更新了" + TagData.TAGNAME + "的S和H(ID||S)数据");
			TagData.JTA.append("，其中更新后S是" + s);
			TagData.JTA.append("，H(ID||S)是" + hash);
		} else {
			TagData.JTA.append("\n");
			TagData.JTA.append("系统：读写器认证不通过！");
		}
	}
	
}
