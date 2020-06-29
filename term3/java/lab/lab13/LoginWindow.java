package lab13;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame {
	JTextField userID;
	JPasswordField password;

	LoginWindow() {
		super("�û���¼����");
		setLayout(new GridLayout(3, 1));

		JPanel p1 = new JPanel();
		JLabel label1 = new JLabel("�û���: ");
		userID = new JTextField(12);
		p1.add(label1);
		p1.add(userID);

		JPanel p2 = new JPanel();
		JLabel label2 = new JLabel("��  ��: ");
		password = new JPasswordField(12);
		p2.add(label2);
		p2.add(password);

		JPanel p3 = new JPanel();
		JButton submit = new JButton(" �� �� ");
		JButton reset = new JButton(" �� �� ");
		
		p3.add(submit);
		p3.add(reset);

		add(p1);
		add(p2);
		add(p3);
		
		submit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(userID.getText().equals("sise") && String.valueOf(password.getPassword()).equals("87818830"))
					new NewFrame();	
				else 
					JOptionPane.showMessageDialog(null, "�ʺš����벻��ȷ��");				
				}
			});
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userID.setText("");
				password.setText("");
			}
		});
		
	}

	public static void main(String argc[]) {
		LoginWindow myframe = new LoginWindow();
		myframe.pack();
		myframe.setVisible(true);
	}
}

class NewFrame extends JFrame {
	public NewFrame() {
		super("�´���");
		setSize(400, 300);
		setVisible(true);
	}
}


