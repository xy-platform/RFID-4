package com.r.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReaderThread implements Runnable {

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(8002);
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("系统：绑定并监听8002端口！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket = serverSocket.accept();
			ReaderData.SOCKET_READER_TAG = socket;
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("系统：标签连接成功！");
			new ReceiveTagThread().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
