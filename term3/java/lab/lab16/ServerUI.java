package lab16;

//һ��һ�������(��������)
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ServerUI extends JFrame {
	JTextArea mainArea;
	JTextArea sendArea;

	JTextField indexArea;
	SvrCom server;
	public void setServer(SvrCom server) {
		this.server = server;
	}
	public ServerUI() {
		super("�������----��������");
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		mainArea = new JTextArea();
		JScrollPane mainAreaP = new JScrollPane(mainArea);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendArea = new JTextArea(3, 8);
		JButton sendBtn = new JButton("����");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				server.sendMsg(sendArea.getText());
				mainArea.append("����������" + sendArea.getText() + "\n");
				sendArea.setText("");
			}
		});
		JPanel tmpPanel = new JPanel();
		indexArea = new JTextField(2);
		indexArea.setText("0");
		tmpPanel.add(sendBtn);
		tmpPanel.add(indexArea);
		panel.add(tmpPanel, BorderLayout.EAST);
		panel.add(sendArea, BorderLayout.CENTER);
		contain.add(mainAreaP, BorderLayout.CENTER);
		contain.add(panel, BorderLayout.SOUTH);
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ServerUI ui = new ServerUI();
		SvrCom server = new SvrCom(ui);
	}
}

//ͨ����SvrCom�����غ����ݵ���
class SvrCom extends Thread {
	Socket client;
	ServerSocket soc;
	BufferedReader in;
	PrintWriter out;
	ServerUI ui;
	public SvrCom(ServerUI ui) { // ��ʼ��SvrCom��
		this.ui = ui;
		ui.setServer(this);
		try {
			soc = new ServerSocket(2345);
			System.out.println("�����������ɹ����ȴ��˿ںţ�2345");
			client = soc.accept();// ���ͻ�����������ʱ������һ������
			System.out.println("���ӳɹ�������" + client.toString());
			in = new BufferedReader(new InputStreamReader(client
					.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		start();
	}
	public void run() {// ���ڼ����ͻ��˷���������Ϣ
		String msg = "";
		while (true) {
			try {
//				System.out.println("aaa");
				msg = in.readLine();
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {
				System.out.println(">>" + msg);
				ui.mainArea.append(msg + "\n");
			}
		}
	}
	public void sendMsg(String msg) {// ���ڷ�����Ϣ
		try {
			out.println("����������" + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
