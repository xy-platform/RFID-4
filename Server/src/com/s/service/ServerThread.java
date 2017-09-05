package com.s.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(8001);
			ServerData.JTA.append("\n");
			ServerData.JTA.append("系统：绑定并监听8001端口！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket = serverSocket.accept();
			ServerData.SOCKET = socket;
			ServerData.JTA.append("\n");
			ServerData.JTA.append("系统：读写器连接成功！");
			new ReceiveThread().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
