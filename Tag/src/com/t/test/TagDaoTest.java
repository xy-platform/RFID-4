package com.t.test;

import java.util.List;

import org.junit.Test;

import com.t.dao.ServerTagDao;
import com.t.dao.TagDao;
import com.t.domain.ServerTag;
import com.t.domain.Tag;
import com.t.service.RandomString;

public class TagDaoTest {

	@Test
	public void testAddOneTag() {
		TagDao tagDao = new TagDao();
		ServerTagDao serverTagDao = new ServerTagDao();
		List<ServerTag> serverTagList = serverTagDao.findAllServerTag();
		int num = 1;
		for(ServerTag serverTag : serverTagList) {
			if (num > 10) {
				break;
			}
			String tid = RandomString.getRandomHexString(32);
			String name = "合法标签" + num;
			String type = "合法标签";
			String id = serverTag.getId();
			String s = serverTag.getS();
			String hash = serverTag.getHash();
			Tag tag = new Tag(tid, name, type, id, s, hash);
			tagDao.addOneTag(tag);
			++num;
		}
	}

}
