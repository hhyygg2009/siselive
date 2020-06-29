package lab8;
//PrintStream的应用
import java.io.*;
import java.util.*;
public class PrintStreamDemo {
	public static void main(String args[]) {
		try {
			PrintStream ps = new PrintStream("result.txt");
			Scanner in = new Scanner(System.in);
			while(in.hasNext()) {
				ps.println(in.next());
			}
			ps.close();
			System.out.println("数据写入完毕!");
		} catch (Exception e) {
		}
	}
}
