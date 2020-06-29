package oj1058;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String>vec =new Vector<>();
		for(int i=48;i<=57;i++) {			
			vec.add(String.valueOf((char)i));
		}
		for(int i=65;i<=90;i++) {
			vec.add(String.valueOf((char)i));
		}
		for(int i=97;i<=122;i++) {
			vec.add(String.valueOf((char)i));
		}
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		Collections.sort(vec);
		System.out.println(vec.indexOf(x));
	}

}
