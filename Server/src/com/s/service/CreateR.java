package com.s.service;

import java.io.DataOutputStream;
import java.io.IOException;

public class CreateR {
	
	public void createR() {
		try {
			DataOutputStream dos = new DataOutputStream(ServerData.SOCKET.getOutputStream());
			String r = RandomString.getRandomHexString(32);
			ServerData.R = r;
			String data = "010116" + r;
			dos.writeUTF(data);
			dos.flush();
			ServerData.JTA.append("\n");
			ServerData.JTA.append("��̨������->��д����" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
