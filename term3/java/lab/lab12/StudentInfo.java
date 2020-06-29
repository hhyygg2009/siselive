package lab12;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.*;

public class StudentInfo extends JFrame { 
	StudentInfo() {
		//设置窗口的布局管理器:5x1的网格
		setLayout(new GridLayout(5,1));

		
		//创建面板p1来放置“姓名”、“学号”有关组件
		JPanel p1=new JPanel();
		
		JLabel lblName=new JLabel("姓名: ");
		JTextField textName=new JTextField(10);
		JLabel lblID=new JLabel("学号");//创建"学号"标签
		JTextField textID=new JTextField(12);	//创建宽度为12的输入文本框	

		p1.add(lblName);
		p1.add(textName);//将文本框textName添加到p1中
		p1.add(lblID);	
		p1.add(textID);

		add(p1);


		//创建面板p2来放置“性别”有关组件
		JPanel p2=new JPanel();

		JLabel lblSex=new JLabel("性别: ");
		JRadioButton male=new JRadioButton("男", true);
		JRadioButton female=new JRadioButton("女");//创建“女”的单选钮
		
		//创建名为cg的ButtonGroup组件
		ButtonGroup cg= new ButtonGroup();
		//添加组件到 cg
		cg.add(male);
		cg.add(female);
		
		p2.add(lblSex);
		p2.add(male);
		p2.add(female);
		
	 add(p2);//将面板p2添加到窗口		
		//创建面板p3来放置“爱好”有关组件
		JPanel p3=new JPanel();
		JLabel lblHobby=new JLabel("爱好: ");
		JCheckBox sing =new JCheckBox("唱歌", false);
		JCheckBox drawing=new JCheckBox("绘画",false);//创建复选框
		JCheckBox sports =new JCheckBox("体育", false);
		
		p3.add(lblHobby);				
		p3.add(sing);
		p3.add(drawing);
		p3.add(sports);
		add(p3);		
		//创建面板p4来放置“系别”有关组件
		JPanel p4=new JPanel();
		JLabel lblDept=new JLabel("系别: ");
		String[]p={"计算机系","外语系"};
		JComboBox cbb=new JComboBox(p);//创建组合框组件
		
		p4.add(lblDept);				
		p4.add(cbb);//将组合框组件添加到p4
		add(p4);		

		//创建面板p4来放置“提交”、“重置”按钮
		JPanel p5=new JPanel();
		JButton submit=new JButton("提交");//创建“提交”按钮
		JButton reset=new JButton("重置");		

		p5.add(submit);				
		p5.add(reset);//将“重置”按钮放入p5

		add(p5);//将p5添加到窗口中		
}

	public static void main(String argc[]) {
		StudentInfo std = new StudentInfo();
		std.setTitle("学生信息");
		std.pack();
		std.setSize(400, 300);
		std.setVisible(true);
	}
}

