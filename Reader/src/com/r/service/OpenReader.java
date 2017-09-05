package com.r.service;

public class OpenReader {
	
	public void open() {
		ReaderThread readerThread = new ReaderThread();
		Thread thread = new Thread(readerThread);
		thread.start();
	}
	
}
