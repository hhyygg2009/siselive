package lab8;
import java.io.*;//����java.io���е�������
import java.util.*;
public class FileTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str=sc.next();		
		File file = new File(str);// �������е�һ��������Ϊ�ļ���Ŀ¼��
		
		if (file.exists())
			if (file. isFile()) {// ������ļ�,����ʾ���й���Ϣ
				System.out.println("����·����" + file. getAbsolutePath());
				System.out.println("�ļ����ȣ�" + file.length()+ " �ֽ�");
			} else {// ��ΪĿ¼,���г���Ŀ¼�µ������ļ�����Ŀ¼��
				System.out.println("Ŀ¼��" + file + ", ��Ŀ¼�µ��ļ�����Ŀ¼��:");
				String lists[] = file. list();// ����ָ��Ŀ¼�������ļ���Ŀ¼
				for (int i = 0; i < lists.length;i++) {
					System.out.println("\t" + lists[i]);
				}
		}else{
		System.out.println("ָ�������ݲ�����");
}
}
}
