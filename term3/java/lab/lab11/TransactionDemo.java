import java.sql.*;
import db.DBUtil;
public class TransactionDemo {
	public static void main(String args[]) throws ClassNotFoundException {
		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		Connection conn = null;
		try {
			conn = db.getConnection();
			// 获取事务自动提交状态
			boolean autoCommit =     conn.getAutoCommit()     ;
			System.out.println("事务自动提交状态：" + autoCommit);
			if (autoCommit) {
				// 关闭自动提交,开启事务
				      conn.setAutoCommit(false)     ;
			} 

			// 创建Statement对象
			Statement stmt = conn.createStatement();

			// 多条DML批处理语句
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(40,'user40','123456',0)");
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(41,'user41','123456',0)");
			// 由于主键约束，下述语句将抛出异常
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(41,'user41','123456',0)");
			// 如果顺利执行则在此提交
			 conn.commit();
			// 恢复原有事务提交状态
			 conn.setAutoCommit(autoCommit);
			// 关闭连接
			db.closeAll();
		} catch (Exception e) {
			// 出现异常
			if (conn != null) {
				try {
					// 回滚
					     conn.rollback()     ;
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
}
