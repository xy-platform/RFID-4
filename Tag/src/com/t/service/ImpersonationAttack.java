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
			TagData.JTA.append("ϵͳ����ǩ�����ǷǷ���ǩ�������ֶ��Ǽ�ð����������������" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
