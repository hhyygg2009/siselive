package c14;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;




public class Menu extends JFrame{
    JMenuBar menubar;   //�˵���
    JMenu menu1; //�˵�
    JMenu menu2; //�˵�
    JMenu menu3; //�˵�
    JMenuItem m1_in;   //�˵���
    JMenuItem m1_me;   //�˵���
    JMenuItem m1_con;   //�˵���
    JMenuItem m2_open;
    JMenuItem m2_save;
    JMenuItem m3_color;
//    JMenuItem mi1[]=new JMenuItem[3];
//    JMenuItem mi2[]=new JMenuItem[2];
//    JMenuItem m3[]=new JMenuItem[];
//    JPanel panel;
    public Menu() {        
        setVisible(true);
        
        setTitle("�Ի��򡢲˵��к�����");
        menubar = new JMenuBar();
        menu1 = new JMenu("ѡ��Ի���");        
        m1_in = new JMenuItem("��ʾ�����");
        m1_me = new JMenuItem("��ʾ��Ϣ��");
        m1_con= new JMenuItem("��ʾȷ�Ͽ�");
        
        m1_in.addActionListener(new MenuAction(this));
        m1_me.addActionListener(new MenuAction(this));
        m1_con.addActionListener(new MenuAction(this));
        
        menu1.add(m1_in);
        menu1.add(m1_me);
        menu1.add(m1_con);
        
//        String strm1[]= {"��ʾ�����","��ʾ��Ϣ��","��ʾȷ�Ͽ�"};
//        
//        for(int i=0;i<mi1.length;i++) {
//        	mi1[i]=new JMenuItem(strm1[i]);
//        	mi1[i].addActionListener(new MenuAction(this));
//        	
//        	menu1.add(mi1[i]);
//        }
        
        menu2 = new JMenu("�ļ�ѡ����");
        m2_open=new JMenuItem("���ļ��Ի���");
        m2_save=new JMenuItem("�����ļ��Ի���");
        m2_open.addActionListener(new MenuAction(this));
        m2_save.addActionListener(new MenuAction(this));
        
        menu2.add(m2_open);
        menu2.add(m2_save);
        menu3 = new JMenu("��ɫѡ����");
        m3_color=new JMenuItem("ѡ���屳��ɫ");
        m3_color.addActionListener(new MenuAction(this));
        
        menu3.add(m3_color);
        
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        
        setJMenuBar(menubar);
        

        
        setSize(300, 200);
        
    }
}

class MenuAction implements ActionListener{
	Menu frame;
	public MenuAction(Menu frame) {
		this.frame=frame;
	}
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
			if(e.getActionCommand()=="��ʾ�����") {
				javax.swing.JOptionPane.showInputDialog(null,"�������������֤����:","�����",javax.swing.JOptionPane.QUESTION_MESSAGE);
			}
			if(e.getActionCommand()=="��ʾ��Ϣ��") {
				javax.swing.JOptionPane.showMessageDialog(null,"�����к�����","��Ϣ��",javax.swing.JOptionPane.WARNING_MESSAGE);
			}	
			if(e.getActionCommand()=="��ʾȷ�Ͽ�") {
				javax.swing.JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���޸�", "ȷ�Ͽ�",javax.swing.JOptionPane.QUESTION_MESSAGE);
			}
			if(e.getActionCommand()=="���ļ��Ի���") {			
				fc.showOpenDialog(null);
			}
			if(e.getActionCommand()=="�����ļ��Ի���") {
				fc.showSaveDialog(null);
			}
			if(e.getActionCommand()=="ѡ���屳��ɫ") {
				JColorChooser jc = new JColorChooser();
				JDialog jd=JColorChooser.createDialog(null, "ѡȡ��ɫ", true, jc, null, null);
				frame.getContentPane().setBackground(jc.getColor());
				jd.setVisible(true);
				
			}
			
		}
		
	
	

}