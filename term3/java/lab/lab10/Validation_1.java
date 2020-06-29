package lab10;


//连接SQL Server 2008/2012数据库,进行身份验证

import java.sql.Connection;
import java.util.regex.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//导入javax.swing包中的类

class MyDB {
	private Connection con = null;
	private Statement stmt = null;
	private static final String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=computer_dept;user=javase;password=javase";

	public MyDB() {
		// 连接数据库
		try {
			Class.forName(drivername);
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean query(String s_id, String s_pwd) {// 查询指定的学生是否存在
		boolean result = false;
		try {
			String sql = "select * from users where id='" + s_id + "' and pwd='" + s_pwd + "'";
			System.out.println("sql:" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				result = false;
			} else {
				result = true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("result:" + result);
		return result;
	}
}

// 主类
public class Validation_1 {
	public static void main(String[] args) {
		MyDB mydb = new MyDB();
		boolean result = false;

		String id, pwd;
		id = JOptionPane.showInputDialog("请输入帐号:");
		JPasswordField pwd_field = new JPasswordField();
		JOptionPane.showConfirmDialog(null, pwd_field, "请输入密码", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);// 设置包含密码框的确认框
		pwd = new String(pwd_field.getPassword());
		Pattern p = Pattern.compile("[\'\"|\b(or|and)\b]+");
		Matcher m = p.matcher(pwd);
		Matcher m1 = p.matcher(id);
		if(m.find()||m1.find())
			pwd="";
		id="";
		
		result = mydb.query(id, pwd);// 通过验证是否为合法用户
		
		if (!result) {
			JOptionPane.showMessageDialog(null, "你不是合法用户！");
		} else {
			JOptionPane.showMessageDialog(null, "你是合法用户！");
		}
		System.out.println("程序运行完毕！");
	}
}
