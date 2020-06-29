package lab9;
import java.io.*;

public class RandomAccessFileTest {
	public static void main(String args[]) {
		int data[] = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };// �Შ��������
		try {
			// ����RandomAccessFile����,�򿪷�ʽΪ"��д"
			RandomAccessFile randf = new      RandomAccessFile     ("Fibonacci.dat", "rw");
			for (int i = 0; i < data.length; i++)
				randf.     writeInt     (data[i]);

			System.out.println("�Է���ʽ����Შ��������:");
			for (int i = data.length - 1; i >= 0; i--) {
				randf.seek(     i*4     ); // �ƶ���дָ��(int����ռ4���ֽ�)
				System.out.print(randf.     readInt     () + "\t");// ��ȡ����
			}
			randf.     close     ();//�ر��ļ�
		} catch (IOException e) {
			System.out.println("�ļ���ȡ����!" + e);
		}
	}
}
