package lab15;

public class MyRunnable       implements Runnable     {// ʵ�ֽӿ�Runnable
	private String message;
	private int delay;
	public MyRunnable(String m, int d) {
		message = m;
		delay = d;
	}
	public void       run      ( ) {// �߳���
		try {
			while (true) {
				System.out.println(message);
				      Thread.sleep      (delay);// ����delayʱ��
			}
		} catch (InterruptedException e) {
			return;
		}
	}
	public static void main(String[] args) {
		MyRunnable r1 = new       MyRunnable      ("A", 500);//����Ŀ�����
		MyRunnable r2 = new MyRunnable("B", 1000);
		Thread t1=new Thread(r1);
		Thread t2=new       Thread(      r2);//��Ŀ�����r2Ϊ���������̶߳���
		t1.start( );
		t2.start( );//�����߳�
	}
}
