package lab12;

// Calculator.java
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	Calculator(){
		super("计算器");
		setFont(new Font("Fixedsys",Font.PLAIN,14));
		JLabel label=new JLabel("计算结果：");
		JTextField tf=new JTextField(20);
		JPanel p1=new JPanel();
		p1.add(label);
		p1.add(tf);
		
		//创建按钮数组
		String []str={" 1 "," 2 "," 3 "," + "," - "," 4 "," 5 "," 6 "," X "," / "," 7 "," 8 "," 9 "," ^ ","sqrt"," C "," 0 "," . ","      =      "};
		JButton[] button=new JButton[str.length];
		for (int i=0;i<str.length;i++){
			button[i]=new JButton(str[i]);
		}
		/*
	按钮布局，请填写代码段
	*/
		setLayout(new GridLayout(5,1));
		add(p1);
		
		//JPanel p2=new JPanel(new GridLayout(4, 1,0,0));		
		JPanel p[]=new JPanel[4];
		
		for(int i=0;i<4;i++) {
			p[i]=new JPanel(new GridLayout(1, 6,0,0));
			for(int j=0;j<5;j++) {				
			if(j==3) 
				p[i].add(new JLabel(" "));
			if(i==3 && j==4) {
				//p[i].add(new JLabel(" "));
				break;
			}
				p[i].add(button[i*5+j]);						
			}
			
			add(p[i]);
		}
		//p[3]=new JPanel(new GridLayout(1, 6,10,10));

		//add(p1,"North");
		//add(p2,"Center");
		
		pack();
		setResizable(false);
		setVisible(true);

	}
	public static void main(String args[]){
		Calculator mycal=new Calculator();
	}
}
