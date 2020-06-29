package lab14;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class MenuDemo extends JFrame {
	MenuDemo(String title) {
		super(title);//���ô������
		JPanel jp=new JPanel();
		JMenuBar mbar =new JMenuBar();//�����˵���
		JTextArea ft = new JTextArea(20, 40);

		//����"�ļ�"�˵��Ĳ˵������
		JMenuItem menuJOptionPane=new JMenuItem("ѡ��Ի���(JOptionPane)");
		JMenuItem menuJFileChooser=new JMenuItem("�ļ�ѡ����(JFileChooser)");
		JMenuItem menuJColorChooser=new JMenuItem("��ɫѡ����(JColorChooser)");		
		
		menuJOptionPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"\"���˼�ʻ\"������Ϊ��ʵ?","��Ϣ��",JOptionPane.INFORMATION_MESSAGE);
			}}
		);
		menuJFileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int rVal =fc.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					// ��ȡ�ļ��Ի������û�ѡ�е��ļ���
					String fileName = fc.getSelectedFile().getName();
					// ��ȡ�ļ��Ի������û�ѡ�е��ļ����ڵ�·��
					String path = fc.getCurrentDirectory().toString();			
					ft.setText(path+'\\'+fileName);					
				}
		}});
		menuJColorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser ch=new JColorChooser();
				JDialog colorDialog;
				colorDialog = JColorChooser.createDialog(null, "ѡȡ��ɫ", true, ch,
						null,null);
				colorDialog.setVisible(true);
				jp.setBackground(ch.getColor());
				}
		});
						
		//���˵���ӵ��˵�����
		mbar.add(menuJOptionPane);
		mbar.add(menuJFileChooser);
		mbar.add(menuJColorChooser);
		jp.add(ft);
		
		//���˵������뵽����
		this.setJMenuBar(mbar);
		this.add(jp);
	}

	public static void main(String args[]) {
		MenuDemo menu = new MenuDemo("���ı��༭��");
		menu.setSize(600, 500);
		menu.setVisible(true);
	}
}
