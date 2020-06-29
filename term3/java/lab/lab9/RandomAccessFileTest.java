package lab9;
import java.io.*;

public class RandomAccessFileTest {
	public static void main(String args[]) {
		int data[] = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };// 裴波那契数列
		try {
			// 创建RandomAccessFile对象,打开方式为"读写"
			RandomAccessFile randf = new      RandomAccessFile     ("Fibonacci.dat", "rw");
			for (int i = 0; i < data.length; i++)
				randf.     writeInt     (data[i]);

			System.out.println("以反序方式输出裴波那契数列:");
			for (int i = data.length - 1; i >= 0; i--) {
				randf.seek(     i*4     ); // 移动读写指针(int数据占4个字节)
				System.out.print(randf.     readInt     () + "\t");// 读取整数
			}
			randf.     close     ();//关闭文件
		} catch (IOException e) {
			System.out.println("文件存取错误!" + e);
		}
	}
}
