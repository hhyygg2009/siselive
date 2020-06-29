package oj1061;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			int x=sc.nextInt(),y=sc.nextInt();
			System.out.println(x/y);
		}
		catch (InputMismatchException e){
			System.out.println("input mismatch exception");
		}
		catch (ArithmeticException e) {
			System.out.println("arithmetic exception");
		}
		finally {
			System.out.println("end");
		}
	}

}
