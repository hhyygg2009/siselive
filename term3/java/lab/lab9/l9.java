package lab9;
import jxl.*;
import java.util.*;
import java.io.*;
public class l9  {
	public static void main(String []args) throws Exception{
		File f = new File("D:\\hr\\����ѧ��\\Java������ƻ���(2018��)\\С��ʵ��\\ʵ��9 �ļ������������(2)\\ѧ��ѡ�μ�¼.xls");
		Sheet s = Workbook.getWorkbook(f).getSheet(0);
		for(int i=0;i<3;i++) {
			String ss[]=readline(s,i);
			for(String tmp : ss) {
				System.out.printf("%1$21s",tmp);
			}
			System.out.println();
		}
	}
	
	static String [] readline(Sheet s,int r) {
		int c = s.getColumns();
		String ss[]=new String[c];		
		for(int j=0;j<c;j++) {
			ss[j]=s.getCell(j,r).getContents();
		}
		return ss;
	}
}
