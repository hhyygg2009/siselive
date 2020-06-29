package lab15;

public class MyThread       extends Thread      {// �̳�Thread��
	private String message;// ��ʾ��Ϣ
	private int delay;// ����ʱ��

	public MyThread(String m, int d) {// ���췽��
		message = m;
		delay = d;
	}
	public void       run      ( ) {// �߳���
		try {
			while (true) {
				System.out.print(message);
				      sleep      (delay);// ����delayʱ��
			}
		} catch (      InterruptedException       e) {// ����InterruptedException�ж��쳣
			return;
		}
	}
	public static void main(String[] args) {
		MyThread t1 = new       MyThread("A", 500);// �����̶߳���
		MyThread t2 = new MyThread("B", 1000);
		t1.start( );
		t2.      start( );// �����߳�
	}
}

