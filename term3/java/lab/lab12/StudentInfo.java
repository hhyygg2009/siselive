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
		//���ô��ڵĲ��ֹ�����:5x1������
		setLayout(new GridLayout(5,1));

		
		//�������p1�����á�����������ѧ�š��й����
		JPanel p1=new JPanel();
		
		JLabel lblName=new JLabel("����: ");
		JTextField textName=new JTextField(10);
		JLabel lblID=new JLabel("ѧ��");//����"ѧ��"��ǩ
		JTextField textID=new JTextField(12);	//�������Ϊ12�������ı���	

		p1.add(lblName);
		p1.add(textName);//���ı���textName��ӵ�p1��
		p1.add(lblID);	
		p1.add(textID);

		add(p1);


		//�������p2�����á��Ա��й����
		JPanel p2=new JPanel();

		JLabel lblSex=new JLabel("�Ա�: ");
		JRadioButton male=new JRadioButton("��", true);
		JRadioButton female=new JRadioButton("Ů");//������Ů���ĵ�ѡť
		
		//������Ϊcg��ButtonGroup���
		ButtonGroup cg= new ButtonGroup();
		//�������� cg
		cg.add(male);
		cg.add(female);
		
		p2.add(lblSex);
		p2.add(male);
		p2.add(female);
		
	 add(p2);//�����p2��ӵ�����		
		//�������p3�����á����á��й����
		JPanel p3=new JPanel();
		JLabel lblHobby=new JLabel("����: ");
		JCheckBox sing =new JCheckBox("����", false);
		JCheckBox drawing=new JCheckBox("�滭",false);//������ѡ��
		JCheckBox sports =new JCheckBox("����", false);
		
		p3.add(lblHobby);				
		p3.add(sing);
		p3.add(drawing);
		p3.add(sports);
		add(p3);		
		//�������p4�����á�ϵ���й����
		JPanel p4=new JPanel();
		JLabel lblDept=new JLabel("ϵ��: ");
		String[]p={"�����ϵ","����ϵ"};
		JComboBox cbb=new JComboBox(p);//������Ͽ����
		
		p4.add(lblDept);				
		p4.add(cbb);//����Ͽ������ӵ�p4
		add(p4);		

		//�������p4�����á��ύ���������á���ť
		JPanel p5=new JPanel();
		JButton submit=new JButton("�ύ");//�������ύ����ť
		JButton reset=new JButton("����");		

		p5.add(submit);				
		p5.add(reset);//�������á���ť����p5

		add(p5);//��p5��ӵ�������		
}

	public static void main(String argc[]) {
		StudentInfo std = new StudentInfo();
		std.setTitle("ѧ����Ϣ");
		std.pack();
		std.setSize(400, 300);
		std.setVisible(true);
	}
}

