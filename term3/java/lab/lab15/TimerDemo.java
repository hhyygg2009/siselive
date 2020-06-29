package lab15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
public class TimerDemo extends JFrame{//������,�̳�JFrame
	JLabel timer;//������ǩ

	public TimerDemo( ) {
		super("ʱ��");
		Container c = this.getContentPane( );//�õ��������
		c.add(new JLabel( ));
		timer = new JLabel( );
		c.add(timer);//��timer��ӵ����������
		timer.setFont(new Font("����", Font.BOLD, 175));//��������
		setSize(900, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť
	}

	public static void main(String args[]) {
		TimerDemo td = new TimerDemo( );//�����������
		new Timer(td).start( );//�����̶߳��󣬲�����
	}
}

class Timer extends Thread {//�߳���,�̳�Thread��
	TimerDemo tb;//�Դ�����Ϊ���Ա
	Timer(TimerDemo tb) {//���췽��
		this.tb = tb;
	}
	public void run( ) {//�߳���
		while (true) {
			try {
				sleep(1000);//����1����ʱ��
			} catch (InterruptedException e) {
				e.printStackTrace( );
			}

			SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
			String s = dateformat.format(new Date( ));
			tb.timer.setText (s);//����ǩ��������Ϊ�ɸ�ʽ���ı�
		}
	}
}
