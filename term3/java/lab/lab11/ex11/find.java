package ex11;
import db.DBUtil;

import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
public class find {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
//		Scanner sc=new Scanner(System.in);
		db.getConnection();
		String p[]=new String[4];
		int j=0;
		for(int i=1;i<=2;i++) 
		{
//			System.out.println("�������"+i+"���ֶε�����");
//			p[j]=sc.nextLine();
			p[j]=javax.swing.JOptionPane.showInputDialog("�������"+i+"���ֶε�����");
			j++;
//			System.out.println("�������"+i+"���ֶε�ֵ");
			p[j]=javax.swing.JOptionPane.showInputDialog("�������"+i+"���ֶε�ֵ");
//			p[j]=sc.nextLine();
			j++;
		}
//		System.out.println("�������ϵ���ӷ�");
//		String key=sc.nextLine();
		String key = javax.swing.JOptionPane.showInputDialog("�������ϵ���ӷ�");
	
		String sql ="select * from courses where "+p[0]+"='"+p[1]+"' "+key+" "+p[2]+"='"+p[3]+"'";
		System.out.println(sql);
		ResultSet rs=db.executeQuery(sql, null);
		while(rs.next()) {
			String str="";
			for(int i=1;i<=5;i++) 
			{
				str+=rs.getString(i)+" ";
			}
			System.out.println(str);
		}
		
	}

}
