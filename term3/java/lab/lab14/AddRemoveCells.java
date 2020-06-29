package lab14;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;

public class AddRemoveCells extends JFrame
{
	private JScrollPane spTable;
	// ����һ��ʢ�Ű�ť�����
	private JPanel pButtons;
	private JButton btnDelete,btnInsert, btnSave,btnFlush;
	// ����Ĭ�ϱ��ģʽ
	private DefaultTableModel model;
	// �������
	private JTable table;
	public AddRemoveCells(){
		this.showdata();
	
		this.setSize(600, 500);
		// �趨�������Ͻ����꣨X��200���أ�Y��100���أ�
		this.setLocation(200, 100);
		// �趨����Ĭ�Ϲرշ�ʽΪ�˳�Ӧ�ó���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô��ڿ��ӣ���ʾ��
		this.setVisible(true);
	}

	public void showdata(){
		try {
		model = new DefaultTableModel();
			// �������
		table = new JTable(model);
			// ���ñ��ѡ��ģʽΪ��һѡ��
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			// ����һ��������壬�������
		spTable = new JScrollPane(table);
			// �����������ӵ���������
		this.add(spTable, BorderLayout.CENTER);
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/computer_dept","root", "hhyygg");
		PreparedStatement ps=conn.prepareStatement("select * from users");
		ResultSet rs =ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		// ��ȡ����
		int colCount = rsmd.getColumnCount();
		
		Vector<String> title = new Vector<String>();
		// ����
		for (int i = 1; i <= colCount; i++) {
			title.add(rsmd.getColumnLabel(i));
		}
		Vector<Vector<String>> data = new Vector<Vector<String>>();//��ά����
		while (rs.next())
		{
			// ������
			Vector<String> rowdata = new Vector<String>();
			for (int i = 1; i <= colCount; i++) {
				rowdata.add(rs.getString(i));
			}
			data.add(rowdata);
		}
		model.setDataVector(data, title);
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public static void main(String args[]) {
		new AddRemoveCells();
	}
}

