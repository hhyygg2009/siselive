package lab8;
import java.util.*;
import java.io.*;
public class copy {
	
	public static void main (String args[]) throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("������Դ�ļ���·�����ļ���:");
		String sin=in.next();
		FileInputStream fin = new FileInputStream(sin);
		String sout=in.next();
		FileOutputStream fout = new FileOutputStream(sout);
		int x,b=0;
		long time = System.currentTimeMillis();
		while((x=fin.read())!=-1) {			
			fout.write(x);
			b++;
		}
		time=System.currentTimeMillis()-time;
		System.out.println("��Դ�ļ�������"+b+"�ֽ�\n�ļ�������ʱ"+time+"����");	
	}
	

}
