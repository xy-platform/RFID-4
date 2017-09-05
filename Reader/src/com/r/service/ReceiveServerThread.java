package com.r.service;

import java.io.DataInputStream;
import java.io.IOException;

public class ReceiveServerThread extends Thread {

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(ReaderData.SOCKET_SERVER_READER.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				String data = dis.readUTF();
				String type = data.substring(2, 4);
				if (type.equals("01")) {
					String r = data.substring(6, data.length());
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("后台服务器->读写器：" + data);
					new Query().query(r);
				} else if(type.equals("05")) {
					String serverResponse = data.substring(6, data.length());
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("后台服务器->读写器：" + data);
					new ForwardServerResponse().forward(serverResponse);
				} else {
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("后台服务器->读写器：非法数据！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
