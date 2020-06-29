package lab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class DBUpdate {
	public DBUpdate() throws SQLException{			
			Statement stmt =        db.getStatement()        ;
			// 查询数据表userdetails中的id、username字段信息，查询结果放入rs
			stmt.executeUpdate("insert into users(id,name,pwd,pclass) values('1840706001','张三','1234','None'),('1840707002','李四','5678','None') ")        ;
			ResultSet rs = stmt.executeQuery("select id,name,pwd,pclass from users where id ='1840706001'or id='1840707002'");
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2) +" "+ rs.     getString(3)+" "+ rs.     getString(4)    );
			}
			stmt.executeUpdate("update users set pwd='706001' where id='1840706001'");
			stmt.executeUpdate("update users  set pwd='707002' where id='1840707002'");
			System.out.println("查询成功！");
			
			 rs = stmt.executeQuery("select id,name,pwd,pclass from users where id ='1840706001'or id='1840707002'");
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2) +" "+ rs.     getString(3)+" "+ rs.     getString(4)    );
			}		
	}
}






class DBquery {
	public DBquery() throws SQLException{
		
			Statement stmt=db.getStatement();
			// 查询数据表userdetails中的id、username字段信息，查询结果放入rs
			ResultSet rs =         stmt.executeQuery("select id,name,pclass from users where pclass='AYU01'")        ;
			System.out.println("查询成功！");
			// 遍历访问结果集中的数据
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2)     );
			}
			// 关闭结果集
			     rs.close()     ;		
	}
}

public class db{
	static Statement stmt;
	static Connection conn;
	public  db() {
		try {
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立数据库连接
			conn =         DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=computer_dept","test","123456")        	;
			System.out.println("连接成功！");
			// 创建Statment对象
			 stmt =         conn.createStatement()        ;
			// 查询数据表userdetails中的id、username字段信息，查询结果放入rs

			// 关闭结果集

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
		//关闭Statement对象
		stmt.close();
		//关闭连接
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

