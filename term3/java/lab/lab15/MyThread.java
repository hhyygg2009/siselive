package lab15;

public class MyThread       extends Thread      {// 继承Thread类
	private String message;// 显示信息
	private int delay;// 休眠时间

	public MyThread(String m, int d) {// 构造方法
		message = m;
		delay = d;
	}
	public void       run      ( ) {// 线程体
		try {
			while (true) {
				System.out.print(message);
				      sleep      (delay);// 休眠delay时间
			}
		} catch (      InterruptedException       e) {// 捕获InterruptedException中断异常
			return;
		}
	}
	public static void main(String[] args) {
		MyThread t1 = new       MyThread("A", 500);// 创建线程对象
		MyThread t2 = new MyThread("B", 1000);
		t1.start( );
		t2.      start( );// 启动线程
	}
}

