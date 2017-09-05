package com.s.service;

import java.io.DataInputStream;
import java.io.IOException;

class ReceiveThread extends Thread {
	
	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(ServerData.SOCKET.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				String data = dis.readUTF();
				String type = data.substring(2, 4);
				if (type.equals("04")) {
					String tagResponse = data.substring(6, data.length());
					String tag_hash = tagResponse.substring(0, 32);
					String tag_h_id_r_s = tagResponse.substring(32, tagResponse.length());
					ServerData.JTA.append("\n");
					ServerData.JTA.append("读写器->后台服务器：" + data);
					new TagAuthentication().authentication(tag_hash, tag_h_id_r_s);
				} else {
					ServerData.JTA.append("\n");
					ServerData.JTA.append("读写器->后台服务器：非法数据！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
