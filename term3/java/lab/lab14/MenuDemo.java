package lab14;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class MenuDemo extends JFrame {
	MenuDemo(String title) {
		super(title);//设置窗体标题
		JPanel jp=new JPanel();
		JMenuBar mbar =new JMenuBar();//创建菜单条
		JTextArea ft = new JTextArea(20, 40);

		//创建"文件"菜单的菜单项对象
		JMenuItem menuJOptionPane=new JMenuItem("选项对话框(JOptionPane)");
		JMenuItem menuJFileChooser=new JMenuItem("文件选择器(JFileChooser)");
		JMenuItem menuJColorChooser=new JMenuItem("颜色选择器(JColorChooser)");		
		
		menuJOptionPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"\"无人驾驶\"即将成为现实?","消息框",JOptionPane.INFORMATION_MESSAGE);
			}}
		);
		menuJFileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int rVal =fc.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					// 获取文件对话框中用户选中的文件名
					String fileName = fc.getSelectedFile().getName();
					// 获取文件对话框中用户选中的文件所在的路径
					String path = fc.getCurrentDirectory().toString();			
					ft.setText(path+'\\'+fileName);					
				}
		}});
		menuJColorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser ch=new JColorChooser();
				JDialog colorDialog;
				colorDialog = JColorChooser.createDialog(null, "选取颜色", true, ch,
						null,null);
				colorDialog.setVisible(true);
				jp.setBackground(ch.getColor());
				}
		});
						
		//将菜单添加到菜单条中
		mbar.add(menuJOptionPane);
		mbar.add(menuJFileChooser);
		mbar.add(menuJColorChooser);
		jp.add(ft);
		
		//将菜单条加入到窗体
		this.setJMenuBar(mbar);
		this.add(jp);
	}

	public static void main(String args[]) {
		MenuDemo menu = new MenuDemo("简单文本编辑器");
		menu.setSize(600, 500);
		menu.setVisible(true);
	}
}
