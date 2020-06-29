import java.sql.*;
import javax.swing.*;//����javax.swing���е���
class DB {
	private Connection con = null;
	private Statement stmt = null;
	private static final String drivername = "com.mysql.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/computer_dept?characterEncoding=utf-8";
	String userName = "root";// ��¼���ݿ��û���
	String password = "hhyygg";// �û�����

	public DB() {
		// �������ݿ�
		try {
			// ������������
			Class.forName(drivername);
			con = DriverManager.getConnection(url,userName,password);

			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean query(String id, String password) {// ��ѯָ����ѧ���Ƿ����
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

	public boolean update_mobile_email(String id, String mobile, String email) {// д���ֻ������email
		boolean result = false;
		try {
		//�����1���뽫���벹������
		if(stmt.executeUpdate("update users set mobile="+mobile+",email="+email+" where num="+id)>0)
			result= true;
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean query2(String id, String password) {// ʹ��Ԥ����������ж�������Ϣ��ѧ���Ƿ����
		boolean result = false;
		ResultSet rs=null;
		PreparedStatement ps;
		try {
		//�����2���뽫���벹������
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

// ����
public class Login {
	public static void main(String[] args) {
		DB mydb = new DB();
		boolean result = false;
		String id, pwd;
		int count=0;//�����˺š�����Ĵ���������3��
		do {
			// �õ���һЩSwingͼ�ν���֪ʶ
			id = JOptionPane.showInputDialog("�������ʺ�:");
			JPasswordField pwd_field = new JPasswordField();
			JOptionPane.showConfirmDialog(null, pwd_field, "����������", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);// ���ð���������ȷ�Ͽ�
			pwd = new String(pwd_field.getPassword());
			count++;
			
			//result = mydb.query(id, pwd);// ��֤�Ƿ�Ϊ�Ϸ��û�
			result = mydb.query2(id, pwd);// ��֤�Ƿ�Ϊ�Ϸ��û�		

			if (!result) {
				if (count<3)
				JOptionPane.showMessageDialog(null, "�㲻�ǺϷ��û��������������ʺš����룡");
				else
				JOptionPane.showMessageDialog(null, "�㲻�ǺϷ��û�����������Ѵﵽ����3�Σ�");					
			} else {
			JOptionPane.showMessageDialog(null, "���ǺϷ��û����������ֻ����롢email��ַ��");
			}
		} while (!result && count<3);
		if (!result && count>=3){
			JOptionPane.showMessageDialog(null, "�㲻�ǺϷ��û��������������ز�����");
			return ;
		}
		// �Ϸ��û���һ�������ֻ���email��Ϣ
		String mobile = JOptionPane.showInputDialog("����������ֻ�����:");
		String email = JOptionPane.showInputDialog("���������email:");
		// ��������ֻ���email��Ϣ�������ݿ���
		if (mydb.update_mobile_email(id, mobile, email)) {
			JOptionPane.showMessageDialog(null, "�����ֻ������email�Ѵ�ŵ����ݿ��У�");
		} else {
			JOptionPane.showMessageDialog(null, "���ź�,��������ֻ������emailδ�ܴ�ŵ����ݿ��У�");
		}
	}
}
