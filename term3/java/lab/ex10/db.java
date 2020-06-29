package ex10;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;


class DBUpdate {
	public static void updateCount() {
		try {
			
		int labs=17;
		Connection conn =        db.getConn()        ;
		Statement stmt = conn.createStatement();
		String sql="update lab_reports set count=";
		for(int i = 1;i<=labs;i++) {
			sql+="+lab_"+i;
		}
		
		if(stmt.executeUpdate(sql)>0)
			System.out.println("update count success");
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	public static void update(String num,String nlab){		
		try {
			Connection conn =        db.getConn()        ;
			String sql ="update lab_reports set "+nlab+"=1 where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs
			
			stmt.setString(1, num);
			if(stmt.executeUpdate()>0)
				System.out.println("����ɹ���"+nlab+" "+num);
			else {
				System.out.println("failed"+nlab+" "+num);
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}

}
}


 class readhomework {
	static String dirname;//����γ�
	static void readname(File f,Map<String,String> stulist) {
		if (f.isFile()) {
			Pattern p = Pattern.compile("\\d{10}_[\\u4e00-\\u9fff]{2,4}");
			Matcher m = p.matcher(f.getName());

			if (m.find()) {
				String ss[]=m.group(0).split("_");//0ѧ��1	����	
				if(stulist.containsKey(ss[0]))
					DBUpdate.update(ss[0], dirname);								
			}
		} else {
			if(f.isDirectory())
				dirname=f.getName();//��ǰĿ¼
			File files[] = f.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// ���ļ������й��ˣ��ļ����ĺ�׺Ϊ.java ��.txt
					return (name.endsWith(".doc") || name.endsWith(".docx")
							|| dir.isDirectory());
				}
			});
			for (File x : files) {
				readname(x,stulist);
				
			}
		}
	}
	static void readcsv(String f, Map<String, String> stulist) {//��ȡcsv�����ݵ�map����
		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			String s, ss[];
			
			while ((s = br.readLine()) != null) {
				ss = s.split("\t");
				stulist.put(ss[0], ss[1]);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



public class db{
	static Statement stmt;
	static Connection conn;
	public  db() {
		try {
			// ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// �������ݿ�����
			conn =         DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=computer_dept","test","123456")        	;
			System.out.println("���ӳɹ���");
			// ����Statment����
			 
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs

			// �رս����

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public Connection getConn() {
		return conn;
	}
	static public void close() throws SQLException {
		//�ر�Statement����
		//�ر�����
		conn.close();
	}
	
	public static void main(String[] args) {
		try {
		new db();

		// TODO Auto-generated method stub
		Map<String, String> handin = new HashMap<>();
		Map<String, String> stulist = new HashMap<>();
		File dir = new File(
				"D:\\hr\\����ѧ��\\Java������ƻ���(2018��)\\С��ʵ��\\ʵ��9 �ļ������������(2)\\AYT02\\lab_7");
		String fcsv = "D:\\hr\\����ѧ��\\Java������ƻ���(2018��)\\С��ʵ��\\ʵ��9 �ļ������������(2)\\AYT02\\AYT02ѧ������.txt";
		
		readhomework.readcsv(fcsv, stulist);
		readhomework.readname(dir,stulist);
		DBUpdate.updateCount();
		System.out.println("ok");
		
		
		
		
		close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}