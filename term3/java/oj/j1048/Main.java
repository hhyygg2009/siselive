package j1048;




import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");
		StringBuffer str=new StringBuffer(in.next());
		in.close();
		int pos;
		
		while((pos=str.indexOf("/*"))!=-1)
			str.delete(pos,(str.indexOf("*/")+2));		

		while((pos=str.indexOf("//"))!=-1)
			str.delete(pos,str.length());		
		System.out.println(str);
	}

}
