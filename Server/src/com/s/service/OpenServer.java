package com.s.service;

public class OpenServer {

	public void open() {
		ServerThread serverThread = new ServerThread();
		Thread thread = new Thread(serverThread);
		thread.start();
	}
	
}
