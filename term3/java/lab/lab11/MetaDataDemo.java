import java.sql.*;
import db.DBUtil;//����MySQL������װ�Ŀ�
public class MetaDataDemo {
	public static void main(String[] args) throws SQLException {
		String selectSql = "select * from users";
		// ����DBUtil����
		DBUtil db = new DBUtil();
		try {
			// ͨ���������ȡ���ݿ�����
			Connection conn = db.getConnection();

			// ͨ��Connection����������DatabaseMetaData����
			DatabaseMetaData dmd =      conn.getMetaData()     ;
			System.out.println("���ݿ��Ʒ����" +      dmd.getDatabaseProductName()     );
			System.out.println("������������" +      dmd.getDriverName()     );
			System.out.println("���ݿ�URL��" +      dmd.getURL()     );

			// ִ�в�ѯ
			ResultSet rs = db.executeQuery(selectSql, null);
			//ͨ��ResultSet����������ResultSetMetaData����
			ResultSetMetaData rsmd =     rs.getMetaData()     ;
			System.out.println("\n�ܹ��У�" +      rsmd.getColumnCount()      + "���ֶ�");

			System.out.println("���\t�ֶ���\t\t�ֶ���������\t�ֶγ���");
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(i + "\t" +      rsmd.getColumnName(i)      + "\t\t" +      rsmd.getColumnTypeName(i)      + "\t"
						+      rsmd.getColumnDisplaySize(i)     );
			}
			// �ر�����
			     db.closeAll()     ;
		} catch (Exception e) {
			db.closeAll();
			e.printStackTrace();
		}
	}
}
