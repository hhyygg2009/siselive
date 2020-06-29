package c14;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;




public class Menu extends JFrame{
    JMenuBar menubar;   //菜单条
    JMenu menu1; //菜单
    JMenu menu2; //菜单
    JMenu menu3; //菜单
    JMenuItem m1_in;   //菜单项
    JMenuItem m1_me;   //菜单项
    JMenuItem m1_con;   //菜单项
    JMenuItem m2_open;
    JMenuItem m2_save;
    JMenuItem m3_color;
//    JMenuItem mi1[]=new JMenuItem[3];
//    JMenuItem mi2[]=new JMenuItem[2];
//    JMenuItem m3[]=new JMenuItem[];
//    JPanel panel;
    public Menu() {        
        setVisible(true);
        
        setTitle("对话框、菜单中和例子");
        menubar = new JMenuBar();
        menu1 = new JMenu("选项对话框");        
        m1_in = new JMenuItem("显示输入框");
        m1_me = new JMenuItem("显示消息框");
        m1_con= new JMenuItem("显示确认框");
        
        m1_in.addActionListener(new MenuAction(this));
        m1_me.addActionListener(new MenuAction(this));
        m1_con.addActionListener(new MenuAction(this));
        
        menu1.add(m1_in);
        menu1.add(m1_me);
        menu1.add(m1_con);
        
//        String strm1[]= {"显示输入框","显示消息框","显示确认框"};
//        
//        for(int i=0;i<mi1.length;i++) {
//        	mi1[i]=new JMenuItem(strm1[i]);
//        	mi1[i].addActionListener(new MenuAction(this));
//        	
//        	menu1.add(mi1[i]);
//        }
        
        menu2 = new JMenu("文件选择器");
        m2_open=new JMenuItem("打开文件对话框");
        m2_save=new JMenuItem("保存文件对话框");
        m2_open.addActionListener(new MenuAction(this));
        m2_save.addActionListener(new MenuAction(this));
        
        menu2.add(m2_open);
        menu2.add(m2_save);
        menu3 = new JMenu("颜色选择器");
        m3_color=new JMenuItem("选择窗体背景色");
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
			if(e.getActionCommand()=="显示输入框") {
				javax.swing.JOptionPane.showInputDialog(null,"请输入您的身份证号码:","输入框",javax.swing.JOptionPane.QUESTION_MESSAGE);
			}
			if(e.getActionCommand()=="显示消息框") {
				javax.swing.JOptionPane.showMessageDialog(null,"吸烟有害健康","消息框",javax.swing.JOptionPane.WARNING_MESSAGE);
			}	
			if(e.getActionCommand()=="显示确认框") {
				javax.swing.JOptionPane.showConfirmDialog(null, "是否确认修改", "确认框",javax.swing.JOptionPane.QUESTION_MESSAGE);
			}
			if(e.getActionCommand()=="打开文件对话框") {			
				fc.showOpenDialog(null);
			}
			if(e.getActionCommand()=="保存文件对话框") {
				fc.showSaveDialog(null);
			}
			if(e.getActionCommand()=="选择窗体背景色") {
				JColorChooser jc = new JColorChooser();
				JDialog jd=JColorChooser.createDialog(null, "选取颜色", true, jc, null, null);
				frame.getContentPane().setBackground(jc.getColor());
				jd.setVisible(true);
				
			}
			
		}
		
	
	

}