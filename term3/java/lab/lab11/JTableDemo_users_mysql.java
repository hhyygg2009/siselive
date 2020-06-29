import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import db.DBUtil;

public class JTableDemo_users_mysql extends JFrame {
	// �����������
	private JScrollPane spTable;
	// ����һ��ʢ�Ű�ť�����
	private JPanel pButtons;
	private JButton btnDelete,btnInsert, btnSave,btnFlush;
	// ����Ĭ�ϱ���ģʽ
	private DefaultTableModel model;
	// ��������
	private JTable table;

	public JTableDemo_users_mysql() {
		super("�û���");

		// ����Ĭ�ϱ���ģʽ
		model = new DefaultTableModel();
		// ��������
		table = new JTable(model);
		// ���ñ���ѡ��ģʽΪ��һѡ��
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// ����һ��������壬��������
		spTable = new JScrollPane(table);
		// ������������ӵ���������
		this.add(spTable, BorderLayout.CENTER);

		// ������ť
		btnDelete = new JButton("ɾ����");
		btnInsert = new JButton("������");
		btnSave = new JButton("����");
		btnFlush = new JButton("ˢ��");
		// �������
		pButtons = new JPanel();
		// ����ť���ӵ������
		pButtons.add(btnDelete);
		pButtons.add(btnInsert);
		pButtons.add(btnSave);		
		pButtons.add(btnFlush);
		// ��ʢ�Ű�ť��������ӵ�������ϲ������棩
		this.add(pButtons, BorderLayout.SOUTH);

		// ע�����
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����ɾ�����ݵķ���
				deleteData();
			}
		});
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���ò����з���
				model.addRow(new Vector());
				table.revalidate();
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���ñ��淽��

			}
		});
		
		btnFlush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ������ʾ���ݵķ���
				showData();
			}
		});

		// ��ʼ����ʾ��������
		this.showData();

		// �趨���ڴ�С
		this.setSize(600, 500);
		// �趨�������Ͻ����꣨X��200���أ�Y��100���أ�
		this.setLocation(200, 100);
		// �趨����Ĭ�Ϲرշ�ʽΪ�˳�Ӧ�ó���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô��ڿ��ӣ���ʾ��
		this.setVisible(true);
	}

	// �鿴users��������ʾ��������
	private void showData() {
		// ��ѯusers��
		String sql = "select * from users";
		// ���ݿ����
		DBUtil db = new DBUtil();
		try {
			db.getConnection();
			ResultSet rs = db.executeQuery(sql, null);
			ResultSetMetaData rsmd = rs.getMetaData();
			// ��ȡ����
			int colCount = rsmd.getColumnCount();
			// �������
			Vector<String> title = new Vector<String>();
			// ����
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// ��������
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			while (rs.next()) {
				rowCount++;
				// ������
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
		} catch (Exception ee) {
			System.out.println(ee.toString());
			JOptionPane.showMessageDialog(this, "ϵͳ�����쳣�����������ݿ⡣ϵͳ�����˳�������",
					"����", 0);
		} finally {
			try {
				db.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ɾ������
	public void deleteData() {
		int index[] = table.getSelectedRows();
		if (index.length == 0) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ���ļ�¼", "��ʾ",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			try {
				int k = JOptionPane.showConfirmDialog(this,
						"��ȷ��Ҫ�����ݿ���ɾ����ѡ�������� ��", "ɾ��", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (k == JOptionPane.YES_OPTION) {
					DBUtil db = new DBUtil();
					try {
						db.getConnection();
						String id = table.getValueAt(index[0], 0).toString();
						String sql = "delete from users where id=?";
						int count = db.executeUpdate(sql, new String[] { id });
						if (count == 1) {
							JOptionPane.showMessageDialog(this, "ɾ�������ɹ����!",
									"�ɹ�", JOptionPane.PLAIN_MESSAGE);
							showData();
						} else {
							JOptionPane.showMessageDialog(this, "��Ǹ�� ɾ������ʧ��!",
									"ʧ��:", 0);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						db.closeAll();
					}
				}
			} catch (Exception ee) {
				JOptionPane.showMessageDialog(this, "��Ǹ!ɾ������ʧ��!��ϵͳ�쳣����", "ʧ��:",
						0);
			}
		}
	}

	public static void main(String[] args) {
		new JTableDemo_users_mysql();
	}
}