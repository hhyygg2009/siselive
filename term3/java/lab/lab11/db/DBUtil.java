package db;
import java.sql.*;

import util.Config;
public class DBUtil {
	Connection c=null;
	int x;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public Connection getConnection() throws Exception{
			String url,user,pwd;
			url=Config.getValue("url");user=Config.getValue("user");pwd=Config.getValue("pwd");
			Class.forName(Config.getValue("driver"));
			c = DriverManager.getConnection(url,user,pwd);
			return c;		
	}
	
	public void closeAll() throws SQLException {
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(c!=null)
			c.close();		
	}
	public ResultSet executeQuery(String sql,String [] p) throws SQLException  {
		ps=c.prepareStatement(sql);
		if(p!=null)
		for(int i=0;i<p.length;i++)
			ps.setString(i+1, p[i]);
		rs=ps.executeQuery();
		return rs;
	}
	
	public int executeUpdate(String sql,String [] p) throws SQLException  {
		ps=c.prepareStatement(sql);
		if(p!=null)
		for(int i=0;i<p.length;i++)
			ps.setString(i+1, p[i]);
		int x=ps.executeUpdate();
		return x;
	}
}

