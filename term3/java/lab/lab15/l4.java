package lab15;

public class l4       extends Thread      {// 继承Thread类
	private int message;// 显示信息
	private int delay;// 休眠时间

	public l4(int m, int d) {// 构造方法
		message = m;
		delay = d;
	}
	public void       run      ( ) {// 线程体
		try {
			switch(message) {
				case 1:
					for(char i='A';i<'Z';i++) {
						System.out.println(i);
						 sleep      (delay);// 休眠delay时间
					}
					break;
				case 2:
					for(char i='a';i<'z';i++) {
						System.out.println(i);
						 sleep      (delay);// 休眠delay时间
					}
					break;
				case 3:
					for(int i=1;i<=26;i++) {
						System.out.println(i);
						 sleep      (delay);// 休眠delay时间
					}
					break;
			}
				
				     
			
		} catch (      InterruptedException       e) {// 捕获InterruptedException中断异常
			return;
		}
	}
	public static void main(String[] args) {
		l4 t1 = new       l4(1, 500);// 创建线程对象
		l4 t2 = new l4(2, 1000);
		l4 t3 = new l4(3, 1500);
		t1.start( );
		t2.      start( );// 启动线程
		t3.start();
	}
}

