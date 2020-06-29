import java.sql.*;
import db.DBUtil;//导入MySQL操作封装的库
public class MetaDataDemo {
	public static void main(String[] args) throws SQLException {
		String selectSql = "select * from users";
		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		try {
			// 通过工具类获取数据库连接
			Connection conn = db.getConnection();

			// 通过Connection对象来创建DatabaseMetaData对象
			DatabaseMetaData dmd =      conn.getMetaData()     ;
			System.out.println("数据库产品名：" +      dmd.getDatabaseProductName()     );
			System.out.println("驱动类型名：" +      dmd.getDriverName()     );
			System.out.println("数据库URL：" +      dmd.getURL()     );

			// 执行查询
			ResultSet rs = db.executeQuery(selectSql, null);
			//通过ResultSet对象来创建ResultSetMetaData对象
			ResultSetMetaData rsmd =     rs.getMetaData()     ;
			System.out.println("\n总共有：" +      rsmd.getColumnCount()      + "个字段");

			System.out.println("序号\t字段名\t\t字段数据类型\t字段长度");
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(i + "\t" +      rsmd.getColumnName(i)      + "\t\t" +      rsmd.getColumnTypeName(i)      + "\t"
						+      rsmd.getColumnDisplaySize(i)     );
			}
			// 关闭连接
			     db.closeAll()     ;
		} catch (Exception e) {
			db.closeAll();
			e.printStackTrace();
		}
	}
}
