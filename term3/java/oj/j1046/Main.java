package j1046;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String id=in.next();
		in.close();
		System.out.println(id.substring(0, 2)+"\n"+id.substring(6, 10)+"\n"+id.substring(10,12)+"\n"+id.substring(12,14)+"\n"+((Integer.parseInt(id.substring(16, 18)))%2==0?"female":"male")+"\n"+id.substring(17, 18));
	}

}
