package lab10;



import      java.sql.Connection     ;//����Connection�ӿ�
import      java.sql.DriverManager     ;//����DriverManager��
import      java.sql.ResultSet     ;//����ResultSet�ӿ�
import      java.sql.PreparedStatement     ;//����Statement�ӿ�
import javax.swing.*;
import java.sql.SQLException;

public class l4 {
	public static void main(String[] args) {
		try {
			// ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// �������ݿ�����
			Connection conn =         DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=computer_dept","test","123456")        	;
			System.out.println("���ӳɹ���");
			// ����Statment����
			PreparedStatement stmt =         conn.prepareStatement("select * from users where id=? and pwd=?")        ;
			// ��ѯ���ݱ�userdetails�е�id��username�ֶ���Ϣ����ѯ�������rs
			String id;
			do {
			 id=javax.swing.JOptionPane.showInputDialog("�������˺�");
			String pwd=javax.swing.JOptionPane.showInputDialog("����������");
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				javax.swing.JOptionPane.showMessageDialog(null,"���ǺϷ��û�");
				break;
			}
			else
				javax.swing.JOptionPane.showMessageDialog(null,"�㲻�ǺϷ��û�");
			}while(true);
			
			// �������ʽ�����е�����
			String email=javax.swing.JOptionPane.showInputDialog("������email");
			// �رս����
			String phone=javax.swing.JOptionPane.showInputDialog("�������ֻ���");
			PreparedStatement st = conn.prepareStatement("update users set email=?,mobile=? where id=?");
			//�ر�Statement����
			st.setString(1, email);
			st.setString(2, phone);
			st.setString(3, id);
			st.execute();
			javax.swing.JOptionPane.showMessageDialog(null,"�ֻ�����"+phone+"�Ѵ���");
			
			stmt.close();
			//�ر�����
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


