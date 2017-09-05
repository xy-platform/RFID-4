package com.t.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.t.domain.Tag;

import cn.itcast.jdbc.TxQueryRunner;

public class TagDao {

	private QueryRunner qr = new TxQueryRunner();
	
	public void addOneTag(Tag tag) {		
		try {
			String sql = "insert into t_rfid_tag_tag values(?,?,?,?,?,?)";
			Object[] params = {
					tag.getTid(),
					tag.getName(),
					tag.getType(),
					tag.getId(),
					tag.getS(),
					tag.getHash()
			};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Tag> findAllTag() {
		try {
			String sql = "select * from t_rfid_tag_tag order by name asc";
			return qr.query(sql, new BeanListHandler<Tag>(Tag.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tag findOneTagByName(String name) {
		try {
			String sql = "select * from t_rfid_tag_tag where name=?";
			Object[] params = { name };
			return qr.query(sql, new BeanHandler<Tag>(Tag.class), params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTagSAndHashById(String id, String s, String hash) {
		try {
			String sql = "update t_rfid_tag_tag set s=?,hash=? where id=?";
			Object[] params = { s, hash, id };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
