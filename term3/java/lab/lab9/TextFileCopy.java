package lab9;

//�ı��ļ��ĸ���
import java.io.*;

public class TextFileCopy {
	public static void main(String[] args) {
		try {
			// ����������:���ļ��ַ���-->������
			FileReader fr = new FileReader(args[0]);                //�������еĵ�һ��������ΪԴ�ļ���
			BufferedReader br = new BufferedReader(fr);                // ��������������������
			
			// ���������:���ļ��ַ���-->������
			 FileWriter fw = new FileWriter(args[1]);                              // �������еĵڶ���������ΪĿ�����
			BufferedWriter bw = new BufferedWriter(fw);                              // �������������������
			/* �����[5]  */int s;
			while (   (s=br.read())!=-1   ) {
				/* �����[7]  */bw.write(s);
			}
		/* �����[8]  */bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�ļ��������!");
	}
}
