package lab9;

import java.io.*;
import java.util.*;
import java.math.*;
public class l7_1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String sa[]=s.split("\\.");
		String s1=sa[0],s2=sa[1],s3;
		RandomAccessFile rb[]=new RandomAccessFile[3];
		RandomAccessFile ra =new RandomAccessFile(s,"rw");
		
		for(int i=0;i<3;i++) {
			s3=s1+"_"+i+"."+s2;			
			rb[i]=new RandomAccessFile(s3,"rw");
			int x;
			while((x=rb[i].read())!=-1) {
				ra.write(x);
			}			
		}
		ra.close();		
		System.out.println("ok");
	}
}

