package ex13;

import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JFrame;

public class l2 extends JFrame
{
	l2()
	{
//		setTitle("111");
		setSize(300,400);
		setVisible(true);
		addMouseListener(new mouseAction(this));
		addMouseMotionListener(new mouseAction(this));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public  static void main(String args[]) {
		new l2();
	}
	
}

class mouseAction implements MouseListener,MouseMotionListener
{
	l2 frame;
	String mousestatus;
	String mouseposition;
	
	public mouseAction(l2 frame) {
		this.frame=frame;
	}


	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		if (e. getButton() >0) {
			mousestatus="��걻���";
			settitle();
		}
	}
	public void mouseEntered(MouseEvent e) {
		mousestatus="����������";
		settitle();
	}
	public void mouseExited(MouseEvent e) {
		mousestatus="����뿪����";
		settitle();
	}
	public void mousePressed(MouseEvent e) {
		mousestatus="��걻����";
		settitle();
	}


	// ʵ��MouseMotionListener�ӿڵ�2������
	public void mouseMoved(MouseEvent e) {
		int ox = e.getX();
		int oy = e.getY();
		mouseposition="λ��("+ox+","+oy+")";
		mousestatus="��걻�ƶ�";
		settitle();
	}

	public void mouseDragged(MouseEvent e) {
		int ox = e.getX();
		int oy = e.getY();
		mouseposition="λ��("+ox+","+oy+")";
		mousestatus="��걻�϶�";
		settitle();
	}
	public void settitle() {
		
		frame.setTitle(mousestatus+mouseposition);
//		frame.setTitle("111");
	}
}