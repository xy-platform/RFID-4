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
			ServerData.JTA.append("ϵͳ���󶨲�����8001�˿ڣ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket = serverSocket.accept();
			ServerData.SOCKET = socket;
			ServerData.JTA.append("\n");
			ServerData.JTA.append("ϵͳ����д�����ӳɹ���");
			new ReceiveThread().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
