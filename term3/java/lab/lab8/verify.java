package lab8;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class verify {
	static void readname(File f,Set s) {
		if(f.isFile()) {
			Pattern p = Pattern.compile(("\\d{10}"));
			Matcher m = p.matcher(f.getName());
			
			if(m.find()) {
			s.add(m.group(0));
			}
		}
		else {
			File files[]=f.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// 对文件名进行过滤，文件名的后缀为.java 或.txt
					return (name.endsWith(".doc") || name.endsWith(".docx")||dir.isDirectory());
				}
			});
			for(File x:files) {
				readname(x,s);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <String>set = new TreeSet<>();
		File f = new File("D:\\hr\\第三学期\\Java程序设计基础(2018级)\\小课实验\\实验8 文件与输入输出流(1)\\AYT");
		readname(f,set);
		Iterator i = set.iterator();
		System.out.println("已交作业人数为"+set.size()+"人\n学号为:");
		while(i.hasNext()) {
			
			System.out.println(i.next());
		}
	}

}
