package lab15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
public class TimerDemo extends JFrame{//窗体类,继承JFrame
	JLabel timer;//声明标签

	public TimerDemo( ) {
		super("时钟");
		Container c = this.getContentPane( );//得到内容面板
		c.add(new JLabel( ));
		timer = new JLabel( );
		c.add(timer);//将timer添加到内容面板中
		timer.setFont(new Font("宋体", Font.BOLD, 175));//设置字体
		setSize(900, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮
	}

	public static void main(String args[]) {
		TimerDemo td = new TimerDemo( );//创建窗体对象
		new Timer(td).start( );//创建线程对象，并启动
	}
}

class Timer extends Thread {//线程类,继承Thread类
	TimerDemo tb;//以窗体作为其成员
	Timer(TimerDemo tb) {//构造方法
		this.tb = tb;
	}
	public void run( ) {//线程体
		while (true) {
			try {
				sleep(1000);//休眠1秒钟时间
			} catch (InterruptedException e) {
				e.printStackTrace( );
			}

			SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
			String s = dateformat.format(new Date( ));
			tb.timer.setText (s);//将标签内容设置为可格式化文本
		}
	}
}
