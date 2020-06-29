package lab10;

import      java.sql.Connection     ;//����Connection�ӿ�
import      java.sql.DriverManager     ;//����DriverManager��
import      java.sql.ResultSet     ;//����ResultSet�ӿ�
import      java.sql.Statement     ;//����Statement�ӿ�
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;

public class ConnectionDemo {
	public static void main(String[] args) {
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("jdbc.prop"));
			String dri=p.getProperty("dri");
			String user=p.getProperty("user");
			String pwd=p.getProperty("pwd");
			// ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// �������ݿ�����
			Connection conn =         DriverManager.getConnection(dri,user,pwd)        	;
			System.out.println("���ӳɹ���");
			// ����Statment����
			Statement stmt =         conn.createStatement()        ;
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs
			ResultSet rs =         stmt.executeQuery("select id,username from userdetails")        ;
			System.out.println("��ѯ�ɹ���");
			// �������ʽ�����е�����
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2)     );
			}
			// �رս����
			     rs.close()     ;
			//�ر�Statement����
			stmt.close();
			//�ر�����
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e )
		{
			e.printStackTrace();
		}
	}
}

