package com.r.test;

import org.junit.Test;

import com.r.dao.ReaderDao;
import com.r.domain.Reader;
import com.r.service.RandomString;

public class ReaderDaoTest {

	@Test
	public void testAddOneReader() {
		ReaderDao readerDao = new ReaderDao();
		for(int i = 1; i <= 10; ++i) {
			readerDao.addOneReader(new Reader(RandomString.getRandomHexString(32), 
					"�Ϸ���д��" + i, "�Ϸ���д��"));
		}
	}

}
