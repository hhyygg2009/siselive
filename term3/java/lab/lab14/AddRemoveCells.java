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
	// 声明一个盛放按钮的面板
	private JPanel pButtons;
	private JButton btnDelete,btnInsert, btnSave,btnFlush;
	// 声明默认表格模式
	private DefaultTableModel model;
	// 声明表格
	private JTable table;
	public AddRemoveCells(){
		this.showdata();
	
		this.setSize(600, 500);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	public void showdata(){
		try {
		model = new DefaultTableModel();
			// 创建表格
		table = new JTable(model);
			// 设置表格选择模式为单一选择
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			// 创建一个滚动面板，包含表格
		spTable = new JScrollPane(table);
			// 将滚动面板添加到窗体中央
		this.add(spTable, BorderLayout.CENTER);
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/computer_dept","root", "hhyygg");
		PreparedStatement ps=conn.prepareStatement("select * from users");
		ResultSet rs =ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		// 获取列数
		int colCount = rsmd.getColumnCount();
		
		Vector<String> title = new Vector<String>();
		// 列名
		for (int i = 1; i <= colCount; i++) {
			title.add(rsmd.getColumnLabel(i));
		}
		Vector<Vector<String>> data = new Vector<Vector<String>>();//二维数组
		while (rs.next())
		{
			// 行数据
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

