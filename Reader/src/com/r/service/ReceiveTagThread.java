package com.r.service;

import java.io.DataInputStream;
import java.io.IOException;

public class ReceiveTagThread extends Thread {

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(ReaderData.SOCKET_READER_TAG.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				String data = dis.readUTF();
				String type = data.substring(2, 4);
				if(type.equals("03")) {
					String tagResponse = data.substring(6, data.length());
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("标签->读写器：" + data);
					new ForwardTagResponse().forward(tagResponse);
				} else {
					ReaderData.JTA.append("\n");
					ReaderData.JTA.append("标签->读写器：非法数据！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
