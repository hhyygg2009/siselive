package lab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class DBUpdate {
	public DBUpdate() throws SQLException{			
			Statement stmt =        db.getStatement()        ;
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs
			stmt.executeUpdate("insert into users(id,name,pwd,pclass) values('1840706001','����','1234','None'),('1840707002','����','5678','None') ")        ;
			ResultSet rs = stmt.executeQuery("select id,name,pwd,pclass from users where id ='1840706001'or id='1840707002'");
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2) +" "+ rs.     getString(3)+" "+ rs.     getString(4)    );
			}
			stmt.executeUpdate("update users set pwd='706001' where id='1840706001'");
			stmt.executeUpdate("update users  set pwd='707002' where id='1840707002'");
			System.out.println("��ѯ�ɹ���");
			
			 rs = stmt.executeQuery("select id,name,pwd,pclass from users where id ='1840706001'or id='1840707002'");
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2) +" "+ rs.     getString(3)+" "+ rs.     getString(4)    );
			}		
	}
}






class DBquery {
	public DBquery() throws SQLException{
		
			Statement stmt=db.getStatement();
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs
			ResultSet rs =         stmt.executeQuery("select id,name,pclass from users where pclass='AYU01'")        ;
			System.out.println("��ѯ�ɹ���");
			// �������ʽ�����е�����
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2)     );
			}
			// �رս����
			     rs.close()     ;		
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
			 stmt =         conn.createStatement()        ;
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs

			// �رս����

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public Statement getStatement() {
		return stmt;
	}
	static public void close() throws SQLException {
		//�ر�Statement����
		stmt.close();
		//�ر�����
		conn.close();
	}
	
	public static void main(String[] args) {
		try {
		new db();
		new DBquery();
		new DBUpdate();
		close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

