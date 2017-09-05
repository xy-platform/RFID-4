package com.r.service;

import java.io.DataOutputStream;
import java.io.IOException;

public class ImpersonationAttack {

	public void impersonationAttack() {
		try {
			DataOutputStream dos = new DataOutputStream(ReaderData.SOCKET_READER_TAG.getOutputStream());
			String data = "010616" + RandomString.getRandomHexString(32);
			dos.writeUTF(data);
			dos.flush();
			ReaderData.JTA.append("\n");
			ReaderData.JTA.append("系统：读写器类型是非法读写器，攻击手段是假冒攻击，其中数据是" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
