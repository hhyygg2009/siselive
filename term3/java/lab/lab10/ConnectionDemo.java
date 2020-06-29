package lab10;

import      java.sql.Connection     ;//导入Connection接口
import      java.sql.DriverManager     ;//导入DriverManager类
import      java.sql.ResultSet     ;//导入ResultSet接口
import      java.sql.Statement     ;//导入Statement接口
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
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立数据库连接
			Connection conn =         DriverManager.getConnection(dri,user,pwd)        	;
			System.out.println("连接成功！");
			// 创建Statment对象
			Statement stmt =         conn.createStatement()        ;
			// 查询数据表userdetails中的id、username字段信息，查询结果放入rs
			ResultSet rs =         stmt.executeQuery("select id,username from userdetails")        ;
			System.out.println("查询成功！");
			// 遍历访问结果集中的数据
			while (        rs.next()        ) {
				System.out.println(rs.     getString(1)     +" "+ rs.     getString(2)     );
			}
			// 关闭结果集
			     rs.close()     ;
			//关闭Statement对象
			stmt.close();
			//关闭连接
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

