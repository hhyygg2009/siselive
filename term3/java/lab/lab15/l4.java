package lab15;

public class l4       extends Thread      {// �̳�Thread��
	private int message;// ��ʾ��Ϣ
	private int delay;// ����ʱ��

	public l4(int m, int d) {// ���췽��
		message = m;
		delay = d;
	}
	public void       run      ( ) {// �߳���
		try {
			switch(message) {
				case 1:
					for(char i='A';i<'Z';i++) {
						System.out.println(i);
						 sleep      (delay);// ����delayʱ��
					}
					break;
				case 2:
					for(char i='a';i<'z';i++) {
						System.out.println(i);
						 sleep      (delay);// ����delayʱ��
					}
					break;
				case 3:
					for(int i=1;i<=26;i++) {
						System.out.println(i);
						 sleep      (delay);// ����delayʱ��
					}
					break;
			}
				
				     
			
		} catch (      InterruptedException       e) {// ����InterruptedException�ж��쳣
			return;
		}
	}
	public static void main(String[] args) {
		l4 t1 = new       l4(1, 500);// �����̶߳���
		l4 t2 = new l4(2, 1000);
		l4 t3 = new l4(3, 1500);
		t1.start( );
		t2.      start( );// �����߳�
		t3.start();
	}
}

