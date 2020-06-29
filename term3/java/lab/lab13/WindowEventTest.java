package lab13;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

//ʵ��WindowListener�ӿ�
class MyFrame extends JFrame implements WindowListener  {
	MyFrame() {
		super("WindowEvent�¼�����");
		setSize(300, 200);
		setVisible(true);
		addWindowListener(this); //�Ե�ǰ����(���ڣ���this��ʾ)��Ϊ�¼�������ע��
	}

	public void windowActivated(WindowEvent e)  {
		System.out.println("���ڱ�����");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("���ڲ��Ǽ���״̬��");
	}

	public void windowClosing(WindowEvent e)  {
		System.out.println("�������ڹر�");
		setVisible(false);
		dispose();
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("�����Ѿ��ر�,�����������");
		System.exit(0);//�˳�����
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("����ͼ�껯��");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("���ڳ���ͼ�껯");
	}

	public void windowOpened(WindowEvent e)  {
		System.out.println("�����Ѿ���");	}
}

public class WindowEventTest {
	public static void main(String args[]) {
		new MyFrame();
	}
}
