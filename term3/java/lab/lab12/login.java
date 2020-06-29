package lab12;
import javax.swing.*;
public class login extends JFrame{
	JPanel p;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JLabel luser;
	JLabel lpwd;
	JTextField tuser;
	JPasswordField tpwd;
	JButton btnConfirm;
	JButton btnReg;
	
	public login(){
		
		
		super("”√ªßµ«¬º");
		this.setSize(250,200);
		p=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		luser=new JLabel("’À∫≈");
		lpwd=new JLabel("√‹¬Î");
		tuser=new JTextField(10);
		tpwd=new JPasswordField(10);
		btnConfirm=new JButton("µ«¬º");
		btnReg=new JButton("÷ÿ÷√");
			
		
		p.add(luser);
		p.add(tuser);
		p2.add(lpwd);
		p2.add(tpwd);
		p1.add(btnConfirm);
		p1.add(btnReg);
		p3.add(p);
		p3.add(p2);
		add(p3,"Center");
		add(p1,"South");
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}

}
