package com.r.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.r.domain.ChannelData;

import cn.itcast.jdbc.TxQueryRunner;

public class ChannelDataDao {

	private QueryRunner qr = new TxQueryRunner();
	
	public void addOneChannelData(ChannelData channelData) {		
		try {
			String sql = "insert into t_rfid_channel_data values(?,?,?,?)";
			Object[] params = {
					channelData.getTid(),
					channelData.getSender(),
					channelData.getData(),
					channelData.getDatetime()
			};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ChannelData findOneChannelData() {
		try {
			String sql = "select * from t_rfid_channel_data where data like '010616%' ORDER BY datetime DESC LIMIT 1";
			return qr.query(sql, new BeanHandler<ChannelData>(ChannelData.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
