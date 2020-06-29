package lab9;
import java.io.*;
import java.util.*;
import java.math.*;
public class l7 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String sa[]=s.split("\\.");
		String s1=sa[0],s2=sa[1],s3;
		RandomAccessFile rb[]=new RandomAccessFile[3];
		for(int i=0;i<3;i++) {
			s3=s1+"_"+i+"."+s2;			
			rb[i]=new RandomAccessFile(s3,"rw");			
		}		
		RandomAccessFile ra =new RandomAccessFile(s,"r");
		long size=ra.length();		
		int x;
		while((x=ra.read())!=-1) {
			long pos=ra.getFilePointer();
			if(pos<size/3){				
				rb[0].write(x);
			}
			else if(pos>=size/3&&pos<(size/3*2)){				
				rb[1].write(x);				
			}
			else {				
				rb[2].write(x);
			}
		}
		for(int i=0;i<3;i++) 
			rb[i].close();		
		System.out.println("ok");
	}
}
