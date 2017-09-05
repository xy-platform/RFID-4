package com.r.service;

import java.io.DataOutputStream;
import java.io.IOException;

public class ForwardTagResponse {
	
	public void forward(String tagResponse) {
		try {
			DataOutputStream dos = new DataOutputStream(ReaderData.SOCKET_SERVER_READER.getOutputStream());
			String data = "010432" + tagResponse;
			dos.writeUTF(data);
			dos.flush();
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("读写器->后台服务器：" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
