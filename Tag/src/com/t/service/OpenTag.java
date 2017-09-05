package com.t.service;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class OpenTag {
	
	public void open() {
		try {
			Socket socket = new Socket("127.0.0.1", 8002);
			TagData.SOCKET = socket;
			TagData.JTA.append("\n");
			TagData.JTA.append("系统：读写器连接成功！");
			new ReceiveThread().start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
