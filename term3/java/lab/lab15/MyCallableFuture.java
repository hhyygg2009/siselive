package lab15;

import java.util.concurrent.*;//导入java.util.concurrent包中的类和接口

//1. 创建Callable接口的实现类
class Task implements           Callable       <Integer> {
private String message;
private int delay;
public Task(String m, int d) {
message = m;
delay = d;
}

// 实现call( )方法，作为线程执行体，返回值为整数
public        Integer   call         ( ) {
int i = 0;
try {
	for (i = 0; i < 10; i++) {
		System.out.println(message);
		Thread.sleep(delay);// 休眠delay时间
	}
	return i;
} catch (InterruptedException e) {
	return -1;
}
}
}

public class MyCallableFuture {
public static void main(String[] args) {
// 2.使用FutureTask类包装Callable实现类的实例
FutureTask<Integer> task1 = new FutureTask<Integer>(     new Task    ("A", 500));
FutureTask<Integer> task2 = new FutureTask<Integer>(new Task("B", 1000));
// 3.创建线程,使用FutureTask对象task作为Thread对象的targer,并调用start( )方法启动线程
new Thread(task1).start( );
new Thread(      task2       ).start( );
// 4.调用FutrueTask对象task的get( )方法获取子线程执行结束后的返回值
try {
	System.out.println("子线程1返回值：" + task1.      get       ( ));
	System.out.println("子线程2返回值：" + task2.get( ));
} catch (InterruptedException e) {
	e.printStackTrace( );
} catch (ExecutionException e) {
	e.printStackTrace( );
}
}
}
