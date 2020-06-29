package lab9;
import jxl.*;
import java.util.*;
import java.io.*;
public class l9  {
	public static void main(String []args) throws Exception{
		File f = new File("D:\\hr\\第三学期\\Java程序设计基础(2018级)\\小课实验\\实验9 文件与输入输出流(2)\\学生选课记录.xls");
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
