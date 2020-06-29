package c14;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class l3 extends JFrame{
	public static void main (String []args) {
		new l3();
		
	}
	l3(){
		String [] s1= {"排课情况查询","新生排课情况查询"};
		String [] s2= {"查看选课情况","查看有效课程","未完成选班情况"};
		Hashtable h1=new Hashtable();
		Hashtable h2=new Hashtable();
		Hashtable h3=new Hashtable();
		h1.put("排课选课管理",h2);
//		h1.put("选课",h3);
		h2.put("排课", s1);
		h2.put("选课", s2);
		JTree t = new JTree(h1);
		JScrollPane jsp=new JScrollPane(t);
		add(jsp);
		setSize(300,400);
		setVisible(true);
	}
	
	
}
