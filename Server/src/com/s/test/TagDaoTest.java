package com.s.test;

import org.junit.Test;

import com.s.dao.TagDao;
import com.s.domain.Tag;
import com.s.service.EncryptionAlgorithm;
import com.s.service.RandomString;

public class TagDaoTest {

	@Test
	public void testAddOneTag() {
		TagDao tagDao = new TagDao();
		for(int i = 0; i < 100; ++i) {
			String tid = RandomString.getRandomHexString(32);
			String id = RandomString.getRandomHexString(32);
			String s = RandomString.getRandomHexString(32);
			String hash = EncryptionAlgorithm.encryption(id + s);
			tagDao.addOneTag(new Tag(tid, id, s, hash));
		}
	}

}
