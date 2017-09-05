package com.t.service;

import java.io.DataInputStream;
import java.io.IOException;

class ReceiveThread extends Thread {
	
	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(TagData.SOCKET.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				String data = dis.readUTF();
				String type = data.substring(2, 4);
				if (type.equals("02")) {
					String r = data.substring(6, data.length());
					TagData.R = r;
					TagData.JTA.append("\n");
					TagData.JTA.append("读写器->标签：" + data);
					new TagResponse().response();
				} else if (type.equals("06")) {
					String reader_h_id_r_s = data.substring(6, data.length());
					TagData.JTA.append("\n");
					TagData.JTA.append("读写器->标签：" + data);
					new ReaderAuthentication().authentication(reader_h_id_r_s);
				} else {
					TagData.JTA.append("\n");
					TagData.JTA.append("读写器->标签：非法数据！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
