package lab16;

//�ͻ��˳���
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String args[]) {
		try {
			Socket sock = new Socket("127.0.0.1", 6666);// ����Socket����,��ַ��˿�Ҫ��Ӧ��������ֵ
			//�õ��������˷��͹������ֽ���������Ϣ�������а�װ
			BufferedReader in = new BufferedReader(new InputStreamReader(sock
					.getInputStream()));
			String s = in.readLine();
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			System.out.println("error!");
		}
	}
}
