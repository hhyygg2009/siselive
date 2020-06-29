package lab15;

public class MyRunnable       implements Runnable     {// 实现接口Runnable
	private String message;
	private int delay;
	public MyRunnable(String m, int d) {
		message = m;
		delay = d;
	}
	public void       run      ( ) {// 线程体
		try {
			while (true) {
				System.out.println(message);
				      Thread.sleep      (delay);// 休眠delay时间
			}
		} catch (InterruptedException e) {
			return;
		}
	}
	public static void main(String[] args) {
		MyRunnable r1 = new       MyRunnable      ("A", 500);//创建目标对象
		MyRunnable r2 = new MyRunnable("B", 1000);
		Thread t1=new Thread(r1);
		Thread t2=new       Thread(      r2);//以目标对象r2为参数创建线程对象
		t1.start( );
		t2.start( );//启动线程
	}
}
