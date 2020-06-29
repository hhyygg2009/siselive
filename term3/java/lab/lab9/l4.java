package lab9;
import java.net.URL;
import java.io.*;
import java.util.Scanner;
public class l4 {
	public static void main(String [] args) {
		try {
		Scanner sc = new Scanner(System.in);
		String a,b;
		System.out.println("ÍøÖ·£º");
		a=sc.nextLine();
		System.out.println("ÎÄ¼þ£º");
		b=sc.nextLine();
		
		URL url = new URL(a);
		InputStream myinput=url.openStream();
		FileOutputStream fo = new FileOutputStream(b);
		int x;
		while((x=myinput.read())!=-1) {
			fo.write(x);
		}
		fo.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
