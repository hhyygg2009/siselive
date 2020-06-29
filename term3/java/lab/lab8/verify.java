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
					// ���ļ������й��ˣ��ļ����ĺ�׺Ϊ.java ��.txt
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
		File f = new File("D:\\hr\\����ѧ��\\Java������ƻ���(2018��)\\С��ʵ��\\ʵ��8 �ļ������������(1)\\AYT");
		readname(f,set);
		Iterator i = set.iterator();
		System.out.println("�ѽ���ҵ����Ϊ"+set.size()+"��\nѧ��Ϊ:");
		while(i.hasNext()) {
			
			System.out.println(i.next());
		}
	}

}
