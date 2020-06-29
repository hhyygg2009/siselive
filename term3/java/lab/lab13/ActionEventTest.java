package lab13;

import java.awt.Font;
//导入java.awt.event包中的所有类
import java.awt.event.*;
import javax.swing.*;

public class ActionEventTest {
	public static void main(String args[]) {
		JFrame f = new JFrame("测试ActionEvent事件");
		f.setLayout(null);			//取消窗口的布局管理器
		JButton b = new JButton(" 已点击我 0 次! ");//创建事件源
		b.setFont(new Font("宋体",Font.BOLD,18));
		f.add(b);
		b.setBounds(50,75,200,50);	//设置按钮的位置和大小
		Monitor bh = new Monitor();//创建事件侦听器
		b. addActionListener(bh);	// 向事件源注册事件侦听器

		f.setFont(new Font("宋体",Font.BOLD,20));
		f.setSize(300,200);
		f.setVisible(true);
	}
}

//定义事件侦听器类,实现ActionListener接口
class Monitor implements ActionListener {
	static int count=0;
	//实现事件侦听接口的唯一方法 actionPerformed
	public void actionPerformed (ActionEvent e) {
		count++;
		((JButton)(e.getSource())).setText("已点击按钮 "+count +" 次!");
	}
}
