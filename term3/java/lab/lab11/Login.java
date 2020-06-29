import java.sql.*;
import javax.swing.*;//导入javax.swing包中的类
class DB {
	private Connection con = null;
	private Statement stmt = null;
	private static final String drivername = "com.mysql.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/computer_dept?characterEncoding=utf-8";
	String userName = "root";// 登录数据库用户名
	String password = "hhyygg";// 用户密码

	public DB() {
		// 连接数据库
		try {
			// 加载驱动程序
			Class.forName(drivername);
			con = DriverManager.getConnection(url,userName,password);

			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean query(String id, String password) {// 查询指定的学生是否存在
		boolean result = false;
		try {
			String sql = "select * from users where id='" + id	+ "' and pwd='" + password + "'";
			System.out.println("sql:"+sql);
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
		System.out.println("result:"+result);
		return result;
	}

	public boolean update_mobile_email(String id, String mobile, String email) {// 写入手机号码和email
		boolean result = false;
		try {
		//代码段1，请将代码补充完整
		if(stmt.executeUpdate("update users set mobile="+mobile+",email="+email+" where num="+id)>0)
			result= true;
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean query2(String id, String password) {// 使用预处理语句来判定输入信息的学生是否存在
		boolean result = false;
		ResultSet rs=null;
		PreparedStatement ps;
		try {
		//代码段2，请将代码补充完整
		ps=con.prepareStatement("select num from users where num=? and password=?");
		ps.setString(1, id);
		ps.setString(2, password);
		rs=ps.executeQuery();
			if(rs.next())
				result=true;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

// 主类
public class Login {
	public static void main(String[] args) {
		DB mydb = new DB();
		boolean result = false;
		String id, pwd;
		int count=0;//输入账号、密码的次数不超过3次
		do {
			// 用到了一些Swing图形界面知识
			id = JOptionPane.showInputDialog("请输入帐号:");
			JPasswordField pwd_field = new JPasswordField();
			JOptionPane.showConfirmDialog(null, pwd_field, "请输入密码", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);// 设置包含密码框的确认框
			pwd = new String(pwd_field.getPassword());
			count++;
			
			//result = mydb.query(id, pwd);// 验证是否为合法用户
			result = mydb.query2(id, pwd);// 验证是否为合法用户		

			if (!result) {
				if (count<3)
				JOptionPane.showMessageDialog(null, "你不是合法用户，请重新输入帐号、密码！");
				else
				JOptionPane.showMessageDialog(null, "你不是合法用户，输入次数已达到上限3次！");					
			} else {
			JOptionPane.showMessageDialog(null, "你是合法用户，请输入手机号码、email地址！");
			}
		} while (!result && count<3);
		if (!result && count>=3){
			JOptionPane.showMessageDialog(null, "你不是合法用户，不允许进行相关操作！");
			return ;
		}
		// 合法用户进一步输入手机和email信息
		String mobile = JOptionPane.showInputDialog("请输入你的手机号码:");
		String email = JOptionPane.showInputDialog("请输入你的email:");
		// 将输入的手机和email信息存入数据库中
		if (mydb.update_mobile_email(id, mobile, email)) {
			JOptionPane.showMessageDialog(null, "输入手机号码和email已存放到数据库中！");
		} else {
			JOptionPane.showMessageDialog(null, "很遗憾,你输入的手机号码和email未能存放到数据库中！");
		}
	}
}
