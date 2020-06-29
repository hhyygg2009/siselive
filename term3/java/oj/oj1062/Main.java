package oj1062;
import java.util.*;
import java.lang.reflect.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine(); 
		Class c = Class.forName(str);
		
		Field f[] = c.getFields();

			String name = c.getSuperclass().getName().toString();
		
			System.out.println(name);
		
		for(Field x: f) {
			String field= x.toString();
			System.out.println(field);
		}
	}

}
