package lab13;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class TestPolygons extends JFrame
{	
	public TestPolygons(String s,Polygon_Panel p)
	{  
		 this.setTitle(s);
		 this.setSize(200,200);
		 this.getContentPane().add(p);
		 this.setVisible(true);
	 }
    public static void main(String args[])
	{	  
		 Polygon_Panel p=new Polygon_Panel();//��崴��ʱ�������滭�����
		 TestPolygons f=new TestPolygons("���Ǳ�����",p);
	 }
}
//���涨��һ������࣬��崴��ʱ�����滭һ������Ρ�
class Polygon_Panel extends JPanel
{   
	public void paintComponent(Graphics g)
	{   //����εĶ���λ��ΪX,Y
		int x[]={20,80,160,80,20}; int y[]={20,20,80,80,80};
 		g.drawPolygon(x,y,x.length); //�������
    }
}
