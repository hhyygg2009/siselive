package lab16;

//�������˳���
import java.net.*;//����java.net���е�������
import java.io.*;
public class Server {
	public static void main(String args[]) {
		int i = 0;// ����
		try {
			ServerSocket ss = new ServerSocket (6666);// ����ServerSocket����
			System.out.println("������������......");
			while (true) {
				Socket socket = ss.accept();// �ȴ��ͻ�������,������Socket����
				i++;// ����
				System.out.println("�ѽ�����������" + i);
				//���ؿͻ��˵�����ֽ�����������PrintStream����
				PrintStream out = new PrintStream(socket.getOutputStream());
				out.println("��ӭ���ʷ�����!");
				out.close();
				socket.close();//�ر�socket
				if (i>=4)//���������ڵ���4ʱ,�����������˳�
					break;
			}
		} catch (IOException e) {//�����쳣
			System.out.println(e);
		}
	}
}

