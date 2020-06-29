package lab13;

//通过接口进行事件处理
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
public class MouseEventTest extends JFrame {
	int ox, oy;// 鼠标起始位置

	MouseEventTest (String title) {// 带参数的构造器
		super(title);
		setFont(new Font("宋体", Font.BOLD, 24));
		addMouseListener(new Monitor1());//注册事件侦听器
		addMouseMotionListener(new Monitor2());//注册事件侦听器
	}

	public static void main(String args[]) {
		MouseEventTest f = new MouseEventTest("MouseEvent事件处理");
		f.setSize(400, 300);
		f.setVisible(true);
	}

	// 内部类Monitor1实现MouseListener接口
	class Monitor1 implements MouseListener{
		// 以下实现MouseListener接口的5个方法
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
	// 内部类Monitor2实现MouseMotionListener接口
	class Monitor2 implements MouseMotionListener {
		// 实现MouseMotionListener接口的2个方法
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
