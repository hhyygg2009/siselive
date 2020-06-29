package lab8;
import java.util.*;
import java.io.*;
public class copy {
	
	public static void main (String args[]) throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("请输入源文件的路径与文件名:");
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
		System.out.println("从源文件复制了"+b+"字节\n文件复制用时"+time+"毫秒");	
	}
	

}
