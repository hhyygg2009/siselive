package c14;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;



public class l2 extends JFrame{
	
	//rowData�������������
	//columnNames�������
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
 
	//���캯��
	public l2(){
		
		columnNames=new Vector();
		//��������
		columnNames.add(" ");
		columnNames.add("����һ");
		columnNames.add("���ڶ�");
		columnNames.add("������");
		columnNames.add("������");
		columnNames.add("������");
		columnNames.add("������");
		columnNames.add("������");
		
		
		//System.out.println(user+pwd);
		
		
		
		rowData = new Vector();		
		
		Vector r[]=new Vector[8];
		for(int i=0;i<8;i++) {
			r[i]=new Vector();
		}
		
		r[0].add("1-2�� 9:00-10:20");
		r[0].add("c���Գ������ll");
		r[0].add("C++����������");		
		
		r[1].add("3-4��");
		
		r[2].add("5-6��");
		
		r[3].add("7-8��");
		r[3].add("Java������ƻ���");
		
		r[4].add("9-10��");
		
		r[5].add("11-12��");
		r[5].add("");
		r[5].add("�����ھ�ʵ��");
		
		r[6].add("13-14��");
		r[6].add("");
		r[6].add("");
		r[6].add("Java�������");
		r[7].add("15-16��");
		for(int i=0;i<3;i++)
			r[7].add("");
		r[7].add("�����ھ�ʵ��");
		
		for(int i=0;i<8;i++) {
		//���뵽rowData
			rowData.add(r[i]);
		}

		
		//��ʼ��Jtable
		jt = new JTable(rowData,columnNames);
		
		//��ʼ�� jsp
		jsp = new JScrollPane(jt);
		
		//��jsp���뵽jframe
		this.add(jsp);
		
		this.setSize(400, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


		}
	public static void main(String[]args) {
		new l2();
	}
	}
