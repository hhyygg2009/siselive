 package ex13;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class l3 extends JFrame{

	public l3() {
		
		super("打开文本文件");

		JButton open;
		JTextField path;
		JTextArea textarea;
		JLabel pathlabel;
		JPanel p;
		
		pathlabel=new JLabel("文本文件位置、名称");
		path=new JTextField(30);
		open=new JButton("保存文本文件");
		textarea=new JTextArea(10,50);
		p=new JPanel();
		p.add(pathlabel);
		p.add(path);
		add(p,"North");
		add(textarea,"Center");
		add(open,"South");
		//setSize(300, 300);
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fw = new FileWriter(path.getText());
					BufferedWriter bw = new BufferedWriter(fw);
					System.out.println(textarea.getText());
					bw.write(textarea.getText());
					
					JOptionPane.showMessageDialog(null, "文件保存完毕!");
					bw.close();
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, ex.toString());
				}
			}
		});
		
		pack();
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new l3();
	}
	
	
	

}

