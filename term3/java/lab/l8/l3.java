package l8;
import java.io.*;
public class l3 {
	public static void main(String [] args) {
		try {
			RandomAccessFile r =new RandomAccessFile(args[0],"r");
			RandomAccessFile r1 =new RandomAccessFile(args[1],"rw");
			long t=System.currentTimeMillis();
			int x;
			while((x=r.read())!=-1) {
				r1.write(x);
			}
			System.out.println("Դ�ļ���"+args[0]+"Ŀ���ļ�:"+args[1]+"\n����:"+r1.length()+"��ʱ:"+(System.currentTimeMillis()-t)+"����");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
