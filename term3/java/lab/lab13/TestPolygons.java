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
		 Polygon_Panel p=new Polygon_Panel();//面板创建时，在上面画多边形
		 TestPolygons f=new TestPolygons("我是标题栏",p);
	 }
}
//下面定义一个面板类，面板创建时在上面画一个多边形。
class Polygon_Panel extends JPanel
{   
	public void paintComponent(Graphics g)
	{   //多边形的顶点位置为X,Y
		int x[]={20,80,160,80,20}; int y[]={20,20,80,80,80};
 		g.drawPolygon(x,y,x.length); //画多边形
    }
}
