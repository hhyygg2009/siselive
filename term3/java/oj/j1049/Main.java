package j1049;




import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");
		StringTokenizer str=new StringTokenizer(in.next(),",;.!()[] ");
		in.close();
		System.out.println(str.countTokens());
		while(str.hasMoreTokens())
			System.out.println(str.nextToken());

	}

}
