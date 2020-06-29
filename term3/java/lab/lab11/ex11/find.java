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
//			System.out.println("请输入第"+i+"个字段的名称");
//			p[j]=sc.nextLine();
			p[j]=javax.swing.JOptionPane.showInputDialog("请输入第"+i+"个字段的名称");
			j++;
//			System.out.println("请输入第"+i+"个字段的值");
			p[j]=javax.swing.JOptionPane.showInputDialog("请输入第"+i+"个字段的值");
//			p[j]=sc.nextLine();
			j++;
		}
//		System.out.println("请输入关系连接符");
//		String key=sc.nextLine();
		String key = javax.swing.JOptionPane.showInputDialog("请输入关系连接符");
	
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
