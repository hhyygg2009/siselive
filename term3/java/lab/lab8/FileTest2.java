package lab8;
import java.io.*;//����java.io���е�������
import java.util.*;
public class FileTest2 {
	public static void main(String args[]) {
	
		File file = new File("c:/");// �������е�һ��������Ϊ�ļ���Ŀ¼��
		File f[]=file.listFiles();
		for (File x:f) {
			if(x.isFile()) {
				System.out.println("�ļ���" + x+ ", ��С"+ x.length()+ " �ֽ�");				
			}
			else {
				System.out.println("��Ŀ¼��" + x);
			}
		
		}
	}
}
