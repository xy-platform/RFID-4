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
			ReaderData.JTA.append("ϵͳ���󶨲�����8002�˿ڣ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket = serverSocket.accept();
			ReaderData.SOCKET_READER_TAG = socket;
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("ϵͳ����ǩ���ӳɹ���");
			new ReceiveTagThread().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
