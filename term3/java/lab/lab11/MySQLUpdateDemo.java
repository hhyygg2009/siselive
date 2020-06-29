import db.DBUtil;
import java.sql.*;
public class MySQLUpdateDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rs;
		DBUtil db = new DBUtil();
		Connection c = db.getConnection();
		String sql = "insert into teachers values(?,?,?,?,?)";
		String p[] = {"1001","张大山","1","32","zs@sise.com.cn"};
		String p1[] = {"1002","王小米","0","25","wxm@sise.com.cn"};
		//db.executeUpdate(sql, p);
		//db.executeUpdate(sql, p1);
		String sql1= "update teachers set age=age+1";
		String sql2="delete from teachers where gender=0";
		String sql3="select * from teachers";
		db.executeUpdate(sql1, null);
		 rs=db.executeQuery(sql3, null);
		while(rs.next()) {
			System.out.println(			rs.getInt(1)+" "+
			rs.getString(2)+" "+
			rs.getCharacterStream(3)+" "+
			rs.getInt(4)+" "+
			rs.getString(5));
		}
		db.executeUpdate(sql2, null);
		rs=db.executeQuery(sql3, null);
		while(rs.next()) {
			System.out.println(			rs.getInt(1)+" "+
			rs.getString(2)+" "+
			rs.getCharacterStream(3)+" "+
			rs.getInt(4)+" "+
			rs.getString(5));
		}
	}

}
