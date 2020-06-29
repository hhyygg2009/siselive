package lab15;

import java.util.concurrent.*;//����java.util.concurrent���е���ͽӿ�

//1. ����Callable�ӿڵ�ʵ����
class Task implements           Callable       <Integer> {
private String message;
private int delay;
public Task(String m, int d) {
message = m;
delay = d;
}

// ʵ��call( )��������Ϊ�߳�ִ���壬����ֵΪ����
public        Integer   call         ( ) {
int i = 0;
try {
	for (i = 0; i < 10; i++) {
		System.out.println(message);
		Thread.sleep(delay);// ����delayʱ��
	}
	return i;
} catch (InterruptedException e) {
	return -1;
}
}
}

public class MyCallableFuture {
public static void main(String[] args) {
// 2.ʹ��FutureTask���װCallableʵ�����ʵ��
FutureTask<Integer> task1 = new FutureTask<Integer>(     new Task    ("A", 500));
FutureTask<Integer> task2 = new FutureTask<Integer>(new Task("B", 1000));
// 3.�����߳�,ʹ��FutureTask����task��ΪThread�����targer,������start( )���������߳�
new Thread(task1).start( );
new Thread(      task2       ).start( );
// 4.����FutrueTask����task��get( )������ȡ���߳�ִ�н�����ķ���ֵ
try {
	System.out.println("���߳�1����ֵ��" + task1.      get       ( ));
	System.out.println("���߳�2����ֵ��" + task2.get( ));
} catch (InterruptedException e) {
	e.printStackTrace( );
} catch (ExecutionException e) {
	e.printStackTrace( );
}
}
}
