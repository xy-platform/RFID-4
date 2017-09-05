package com.s.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.s.domain.Tag;

import cn.itcast.jdbc.TxQueryRunner;

public class TagDao {

	private QueryRunner qr = new TxQueryRunner();
	
	public void addOneTag(Tag tag) {		
		try {
			String sql = "insert into t_rfid_server_tag values(?,?,?,?)";
			Object[] params = {
					tag.getTid(),
					tag.getId(),
					tag.getS(),
					tag.getHash()
			};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tag findOneTagByHash(String hash) {
		try {
			String sql = "select * from t_rfid_server_tag where hash=?";
			Object[] params = { hash };
			return qr.query(sql, new BeanHandler<Tag>(Tag.class), params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTagSAndHashById(String id, String s, String hash) {
		try {
			String sql = "update t_rfid_server_tag set s=?,hash=? where id=?";
			Object[] params = { s, hash, id };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
