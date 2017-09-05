package com.t.service;

import java.io.DataOutputStream;
import java.io.IOException;

public class ImpersonationAttack {

	public void impersonationAttack() {
		try {
			DataOutputStream dos = new DataOutputStream(TagData.SOCKET.getOutputStream());
			String data = "010332" + RandomString.getRandomHexString(64);
			dos.writeUTF(data);
			dos.flush();
			TagData.JTA.append("\n");
			TagData.JTA.append("系统：标签类型是非法标签，攻击手段是假冒攻击，其中数据是" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
