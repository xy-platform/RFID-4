package com.r.service;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnServer {
	
	public void conn() {
		try {
			Socket socket = new Socket("127.0.0.1", 8001);
			ReaderData.SOCKET_SERVER_READER = socket;
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("系统：后台服务器连接成功！");
			new ReceiveServerThread().start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
