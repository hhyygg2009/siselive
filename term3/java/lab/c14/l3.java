package c14;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class l3 extends JFrame{
	public static void main (String []args) {
		new l3();
		
	}
	l3(){
		String [] s1= {"�ſ������ѯ","�����ſ������ѯ"};
		String [] s2= {"�鿴ѡ�����","�鿴��Ч�γ�","δ���ѡ�����"};
		Hashtable h1=new Hashtable();
		Hashtable h2=new Hashtable();
		Hashtable h3=new Hashtable();
		h1.put("�ſ�ѡ�ι���",h2);
//		h1.put("ѡ��",h3);
		h2.put("�ſ�", s1);
		h2.put("ѡ��", s2);
		JTree t = new JTree(h1);
		JScrollPane jsp=new JScrollPane(t);
		add(jsp);
		setSize(300,400);
		setVisible(true);
	}
	
	
}
