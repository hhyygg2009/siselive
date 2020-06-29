package lab13;

//ͨ���ӿڽ����¼�����
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
public class MouseEventTest extends JFrame {
	int ox, oy;// �����ʼλ��

	MouseEventTest (String title) {// �������Ĺ�����
		super(title);
		setFont(new Font("����", Font.BOLD, 24));
		addMouseListener(new Monitor1());//ע���¼�������
		addMouseMotionListener(new Monitor2());//ע���¼�������
	}

	public static void main(String args[]) {
		MouseEventTest f = new MouseEventTest("MouseEvent�¼�����");
		f.setSize(400, 300);
		f.setVisible(true);
	}

	// �ڲ���Monitor1ʵ��MouseListener�ӿ�
	class Monitor1 implements MouseListener{
		// ����ʵ��MouseListener�ӿڵ�5������
		public void mouseMoved (MouseEvent e) { 
			ox = e.getX();
			oy = e.getY();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			if (e. getButton() >= 2) {
				Graphics g = getGraphics();
				g.clearRect(0, 0, 400, 300);
			}
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			
		}
	}
	// �ڲ���Monitor2ʵ��MouseMotionListener�ӿ�
	class Monitor2 implements MouseMotionListener {
		// ʵ��MouseMotionListener�ӿڵ�2������
		public void mouseMoved(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			Graphics g = getGraphics();
			g.drawLine(ox, oy, x, y);
			ox = x;
			oy = y;
		}
	}
}
