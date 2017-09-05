package com.t.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.t.domain.ServerTag;

import cn.itcast.jdbc.TxQueryRunner;

public class ServerTagDao {

	private QueryRunner qr = new TxQueryRunner();
	
	public List<ServerTag> findAllServerTag() {
		try {
			String sql = "select * from t_rfid_server_tag";
			return qr.query(sql, new BeanListHandler<ServerTag>(ServerTag.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
