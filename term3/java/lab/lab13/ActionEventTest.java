package lab13;

import java.awt.Font;
//����java.awt.event���е�������
import java.awt.event.*;
import javax.swing.*;

public class ActionEventTest {
	public static void main(String args[]) {
		JFrame f = new JFrame("����ActionEvent�¼�");
		f.setLayout(null);			//ȡ�����ڵĲ��ֹ�����
		JButton b = new JButton(" �ѵ���� 0 ��! ");//�����¼�Դ
		b.setFont(new Font("����",Font.BOLD,18));
		f.add(b);
		b.setBounds(50,75,200,50);	//���ð�ť��λ�úʹ�С
		Monitor bh = new Monitor();//�����¼�������
		b. addActionListener(bh);	// ���¼�Դע���¼�������

		f.setFont(new Font("����",Font.BOLD,20));
		f.setSize(300,200);
		f.setVisible(true);
	}
}

//�����¼���������,ʵ��ActionListener�ӿ�
class Monitor implements ActionListener {
	static int count=0;
	//ʵ���¼������ӿڵ�Ψһ���� actionPerformed
	public void actionPerformed (ActionEvent e) {
		count++;
		((JButton)(e.getSource())).setText("�ѵ����ť "+count +" ��!");
	}
}
