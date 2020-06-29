package lab14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;

class MyFrame extends JFrame{
	private JLabel myimage;//标签
	private JButton filechooser;//按钮
	String filename = "images/duke.gif";//图像文件名

	public MyFrame() {//构造器
		try {// 设置Windows观感
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("Look and Feel Exception");
			System.exit(0);
		}

		Toolkit kit = Toolkit.getDefaultToolkit();// 获取Toolkit对象
		Image image = kit.getImage("images/duke.gif");// duke.gif为图像文件名
		setIconImage(image);// 设置窗体图标

		filechooser = new JButton("选择图像文件...");//创建"选择图像文件..."按钮
		JPanel panel = new JPanel();
		panel.add(filechooser);//将按钮放入面板上

		myimage = new JLabel (new ImageIcon(filename));//创建显示图像的标签
		Container con = getContentPane();//得到窗体的内容面板
		con.add(myimage, "Center");//将标签添加到内容面板"中央"
		con.add(panel,"South");//将面板panel添加到内容面板"南面"

		final JFileChooser jfilechooser = new JFileChooser();// 创建JFileChoose对象
		filechooser.addActionListener(new ActionListener() {//添加事件处理代码
			public void actionPerformed(ActionEvent e) {
				int returnVal = jfilechooser.showOpenDialog(null);// 打开文件对话框
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					filename = jfilechooser.getSelectedFile().getPath();//得到选择的文件名
					myimage. setIcon (new ImageIcon(filename));//设置标签的新图标
					pack();
				}
			}
		});

		setVisible(true);
		pack();
		setTitle("图像浏览器");
	}
}

public class ImageBrowser {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);// 关闭窗口
	}
}
