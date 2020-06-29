package lab14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;

class MyFrame extends JFrame{
	private JLabel myimage;//��ǩ
	private JButton filechooser;//��ť
	String filename = "images/duke.gif";//ͼ���ļ���

	public MyFrame() {//������
		try {// ����Windows�۸�
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("Look and Feel Exception");
			System.exit(0);
		}

		Toolkit kit = Toolkit.getDefaultToolkit();// ��ȡToolkit����
		Image image = kit.getImage("images/duke.gif");// duke.gifΪͼ���ļ���
		setIconImage(image);// ���ô���ͼ��

		filechooser = new JButton("ѡ��ͼ���ļ�...");//����"ѡ��ͼ���ļ�..."��ť
		JPanel panel = new JPanel();
		panel.add(filechooser);//����ť���������

		myimage = new JLabel (new ImageIcon(filename));//������ʾͼ��ı�ǩ
		Container con = getContentPane();//�õ�������������
		con.add(myimage, "Center");//����ǩ��ӵ��������"����"
		con.add(panel,"South");//�����panel��ӵ��������"����"

		final JFileChooser jfilechooser = new JFileChooser();// ����JFileChoose����
		filechooser.addActionListener(new ActionListener() {//����¼��������
			public void actionPerformed(ActionEvent e) {
				int returnVal = jfilechooser.showOpenDialog(null);// ���ļ��Ի���
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					filename = jfilechooser.getSelectedFile().getPath();//�õ�ѡ����ļ���
					myimage. setIcon (new ImageIcon(filename));//���ñ�ǩ����ͼ��
					pack();
				}
			}
		});

		setVisible(true);
		pack();
		setTitle("ͼ�������");
	}
}

public class ImageBrowser {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);// �رմ���
	}
}
