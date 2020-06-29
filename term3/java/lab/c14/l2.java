package c14;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;



public class l2 extends JFrame{
	
	//rowData用来存放行数据
	//columnNames存放列名
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
 
	//构造函数
	public l2(){
		
		columnNames=new Vector();
		//设置列名
		columnNames.add(" ");
		columnNames.add("星期一");
		columnNames.add("星期二");
		columnNames.add("星期三");
		columnNames.add("星期四");
		columnNames.add("星期五");
		columnNames.add("星期六");
		columnNames.add("星期日");
		
		
		//System.out.println(user+pwd);
		
		
		
		rowData = new Vector();		
		
		Vector r[]=new Vector[8];
		for(int i=0;i<8;i++) {
			r[i]=new Vector();
		}
		
		r[0].add("1-2节 9:00-10:20");
		r[0].add("c语言程序设计ll");
		r[0].add("C++面向对象基础");		
		
		r[1].add("3-4节");
		
		r[2].add("5-6节");
		
		r[3].add("7-8节");
		r[3].add("Java程序设计基础");
		
		r[4].add("9-10节");
		
		r[5].add("11-12节");
		r[5].add("");
		r[5].add("数据挖掘实践");
		
		r[6].add("13-14节");
		r[6].add("");
		r[6].add("");
		r[6].add("Java程序设计");
		r[7].add("15-16节");
		for(int i=0;i<3;i++)
			r[7].add("");
		r[7].add("数据挖掘实践");
		
		for(int i=0;i<8;i++) {
		//加入到rowData
			rowData.add(r[i]);
		}

		
		//初始化Jtable
		jt = new JTable(rowData,columnNames);
		
		//初始化 jsp
		jsp = new JScrollPane(jt);
		
		//把jsp放入到jframe
		this.add(jsp);
		
		this.setSize(400, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


		}
	public static void main(String[]args) {
		new l2();
	}
	}
