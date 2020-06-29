package lab10;


//����SQL Server 2008/2012���ݿ�,���������֤

import java.sql.Connection;
import java.util.regex.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//����javax.swing���е���

class MyDB {
	private Connection con = null;
	private Statement stmt = null;
	private static final String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=computer_dept;user=javase;password=javase";

	public MyDB() {
		// �������ݿ�
		try {
			Class.forName(drivername);
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean query(String s_id, String s_pwd) {// ��ѯָ����ѧ���Ƿ����
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

// ����
public class Validation_1 {
	public static void main(String[] args) {
		MyDB mydb = new MyDB();
		boolean result = false;

		String id, pwd;
		id = JOptionPane.showInputDialog("�������ʺ�:");
		JPasswordField pwd_field = new JPasswordField();
		JOptionPane.showConfirmDialog(null, pwd_field, "����������", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);// ���ð���������ȷ�Ͽ�
		pwd = new String(pwd_field.getPassword());
		Pattern p = Pattern.compile("[\'\"|\b(or|and)\b]+");
		Matcher m = p.matcher(pwd);
		Matcher m1 = p.matcher(id);
		if(m.find()||m1.find())
			pwd="";
		id="";
		
		result = mydb.query(id, pwd);// ͨ����֤�Ƿ�Ϊ�Ϸ��û�
		
		if (!result) {
			JOptionPane.showMessageDialog(null, "�㲻�ǺϷ��û���");
		} else {
			JOptionPane.showMessageDialog(null, "���ǺϷ��û���");
		}
		System.out.println("����������ϣ�");
	}
}
