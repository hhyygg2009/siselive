package lab12;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;//����java.awt.Font��
import javax.swing.JFrame;
import javax.swing.JLabel; //����javax.swing.JLabel��

public class JFrameTest extends JFrame{ // �̳�JFrame��
	JFrameTest() {
		super("���ڲ���");// ���ô��ڱ���Ϊ"���ڲ���"

		//�õ�������������
		Container con=getContentPane();
		//����������屳��ɫΪ��ɫ
		con.setBackground(Color.red);
		
		//������ǩlabel,����Ϊ"�����Ҵ����ĵ�һ������",���ж���
		JLabel label = new JLabel("�����Ҵ����ĵ�һ������");
		label.setFont(new Font("����", Font.PLAIN, 24));//���ñ�ǩ������
		label.setForeground(Color.yellow);	//���ñ�ǩ��ǰ��ɫΪ��ɫ
		add(label);// ����ǩlabel��ӵ����������
		setSize(300,200);// ���ô��ڴ�СΪ(300,200)
		setVisible(true);// ��ʾ����
	}

	public static void main(String argc[]) {
		JFrameTest myframe = new JFrameTest();// ����JFrameTest ��Ķ���
	}
}
