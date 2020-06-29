package lab10;



import      java.sql.Connection     ;//导入Connection接口
import      java.sql.DriverManager     ;//导入DriverManager类
import      java.sql.ResultSet     ;//导入ResultSet接口
import      java.sql.PreparedStatement     ;//导入Statement接口
import javax.swing.*;
import java.sql.SQLException;

public class l4 {
	public static void main(String[] args) {
		try {
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立数据库连接
			Connection conn =         DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=computer_dept","test","123456")        	;
			System.out.println("连接成功！");
			// 创建Statment对象
			PreparedStatement stmt =         conn.prepareStatement("select * from users where id=? and pwd=?")        ;
			// 查询数据表userdetails中的id、username字段信息，查询结果放入rs
			String id;
			do {
			 id=javax.swing.JOptionPane.showInputDialog("请输入账号");
			String pwd=javax.swing.JOptionPane.showInputDialog("请输入密码");
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				javax.swing.JOptionPane.showMessageDialog(null,"你是合法用户");
				break;
			}
			else
				javax.swing.JOptionPane.showMessageDialog(null,"你不是合法用户");
			}while(true);
			
			// 遍历访问结果集中的数据
			String email=javax.swing.JOptionPane.showInputDialog("请输入email");
			// 关闭结果集
			String phone=javax.swing.JOptionPane.showInputDialog("请输入手机号");
			PreparedStatement st = conn.prepareStatement("update users set email=?,mobile=? where id=?");
			//关闭Statement对象
			st.setString(1, email);
			st.setString(2, phone);
			st.setString(3, id);
			st.execute();
			javax.swing.JOptionPane.showMessageDialog(null,"手机号码"+phone+"已存入");
			
			stmt.close();
			//关闭连接
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


