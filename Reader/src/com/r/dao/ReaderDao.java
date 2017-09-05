package com.r.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.r.domain.Reader;

import cn.itcast.jdbc.TxQueryRunner;

public class ReaderDao {

	private QueryRunner qr = new TxQueryRunner();
	
	public void addOneReader(Reader reader) {		
		try {
			String sql = "insert into t_rfid_reader_reader values(?,?,?)";
			Object[] params = {
					reader.getTid(),
					reader.getName(),
					reader.getType()
			};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reader> findAllReader() {
		try {
			String sql = "select * from t_rfid_reader_reader order by name asc";
			return qr.query(sql, new BeanListHandler<Reader>(Reader.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String findReaderTypeByName(String name) {
		try {
			String sql = "select type from t_rfid_reader_reader where name=?";
			Object[] params = { name };
			Object obj = qr.query(sql, new ScalarHandler(), params);
			return obj == null? null: obj.toString();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
