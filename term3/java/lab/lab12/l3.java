 package lab12;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class l3 extends JFrame{

	public l3() {
		
		super("���ı��ļ�");

		JButton open;
		JTextField path;
		JTextArea textarea;
		JLabel pathlabel;
		JPanel p;
		
		pathlabel=new JLabel("�ı��ļ�λ�á�����");
		path=new JTextField(30);
		open=new JButton("���ı��ļ�");
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
					FileReader fr=new FileReader(path.getText());
					BufferedReader br = new BufferedReader(fr);
					String str="",tmp;
					while((tmp=br.readLine())!=null) {
						str+=tmp;
						str+="\n";
					}
					textarea.setText(str);
					
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

