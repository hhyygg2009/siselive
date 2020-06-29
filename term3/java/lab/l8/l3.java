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
			System.out.println("源文件："+args[0]+"目标文件:"+args[1]+"\n拷贝:"+r1.length()+"用时:"+(System.currentTimeMillis()-t)+"毫秒");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
