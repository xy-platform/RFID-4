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
			ReaderData.JTA.append("ϵͳ����д�������ǷǷ���д���������ֶ��Ǽ�ð����������������" + data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
