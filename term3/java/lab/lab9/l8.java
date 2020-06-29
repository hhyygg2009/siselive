package lab9;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class l8 {
	static String dirname;
	static void readname(File f, Map <String, String>handin) {
		if (f.isFile()) {
			Pattern p = Pattern.compile("\\d{10}_[\\u4e00-\\u9fff]{2,4}");
			Matcher m = p.matcher(f.getName());

			if (m.find()) {
				String s=m.group(0);
				String ss[]=s.split("_");				
				handin.put(ss[0], ss[1]);
			}
		} else {
			if(f.isDirectory()) {
				dirname=f.getName();
				System.out.println("��ǰĿ¼:"+dirname);
			}
			File files[] = f.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// ���ļ������й��ˣ��ļ����ĺ�׺Ϊ.java ��.txt
					return (name.endsWith(".doc") || name.endsWith(".docx")
							|| dir.isDirectory());
				}
			});
			for (File x : files) {
				readname(x, handin);
			}
		}
	}
	static void readcsv(String f, Map<String, String> stulist, Map <String, String>handin) {

		try (BufferedWriter fin = new BufferedWriter(
				new FileWriter("finished.csv"));
				BufferedWriter unfinished = new BufferedWriter(
						new FileWriter("unfinished.csv"));
				BufferedReader br = new BufferedReader(new FileReader(f));) {

			String s, ss[];
			BufferedWriter tmp;
			while ((s = br.readLine()) != null) {
				ss = s.split("\t");
				stulist.put(ss[0], ss[1]);
				tmp = unfinished;
				if (handin.containsKey(ss[0]))
					tmp = fin;

				tmp.write("" + ss[0] + "\t" + ss[1]);
				tmp.newLine();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	static void checkdone(Map<String, String> stulist, Map <String, String>handin) {
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("wrongclass.csv"))) {
				Iterator<String> it = handin.keySet().iterator();

			while (it.hasNext()) {
				String tmp = it.next();
				if (!stulist.containsKey(tmp)) {
					bw.write(tmp+"\t"+handin.get(tmp));
					bw.newLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> handin = new HashMap<>();
		Map<String, String> stulist = new HashMap<>();
		File dir = new File(
				"D:\\hr\\����ѧ��\\Java������ƻ���(2018��)\\С��ʵ��\\ʵ��9 �ļ������������(2)\\AYT02\\lab_7");
		String fcsv = "D:\\hr\\����ѧ��\\Java������ƻ���(2018��)\\С��ʵ��\\ʵ��9 �ļ������������(2)\\AYT02\\AYT02ѧ������.txt";
		readname(dir, handin);
		readcsv(fcsv, stulist, handin);
		checkdone(stulist, handin);
		System.out.println("ok");

	}

}