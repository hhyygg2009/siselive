package lab12;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;//导入java.awt.Font类
import javax.swing.JFrame;
import javax.swing.JLabel; //导入javax.swing.JLabel类

public class JFrameTest extends JFrame{ // 继承JFrame类
	JFrameTest() {
		super("窗口测试");// 设置窗口标题为"窗口测试"

		//得到窗体的内容面板
		Container con=getContentPane();
		//设置内容面板背景色为红色
		con.setBackground(Color.red);
		
		//创建标签label,内容为"这是我创建的第一个窗口",居中对齐
		JLabel label = new JLabel("这是我创建的的一个窗口");
		label.setFont(new Font("宋体", Font.PLAIN, 24));//设置标签的字体
		label.setForeground(Color.yellow);	//设置标签的前景色为黄色
		add(label);// 将标签label添加到内容面板中
		setSize(300,200);// 设置窗口大小为(300,200)
		setVisible(true);// 显示窗口
	}

	public static void main(String argc[]) {
		JFrameTest myframe = new JFrameTest();// 创建JFrameTest 类的对象
	}
}
