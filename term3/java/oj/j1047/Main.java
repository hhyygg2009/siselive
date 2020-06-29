package j1047;


import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String mail=in.next();
		in.close();
		if(mail.length()>3&&(mail.indexOf("@",(mail.indexOf("@")+1)))==-1&&mail.indexOf("@")!=0&&mail.indexOf("@")!=mail.length()-1)
			System.out.println("true");
		else
			System.out.println("false");
	}

}
