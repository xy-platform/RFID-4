package com.r.test;

import org.junit.Test;

import com.r.dao.ChannelDataDao;
import com.r.domain.ChannelData;

public class ChannelDataDaoTest {

	@Test
	public void testFindAllChannelData() {
		ChannelDataDao channelDataDao = new ChannelDataDao();
		ChannelData channelData = channelDataDao.findOneChannelData();
		System.out.println(channelData);
	}

}
