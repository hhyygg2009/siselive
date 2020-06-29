package oj1057;
import java.util.*;
public class Main {
	public static void main(String[] args ) {
		List <Integer> list = new ArrayList <>();
		Scanner in = new Scanner(System.in);
		int a=in.nextInt(),b=in.nextInt();
		for(int i=a;i<=b;i++) {
			list.add(i);
			System.out.print(i+" ");
		}
		System.out.println();
		int tmp;
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext()) {
			tmp=it.next();
			if(tmp%3==0||tmp%5==0||tmp%7==0) {
				it.remove();
			}
		}
		while(it.hasPrevious())
		System.out.print(it.previous()+" ");
	}
}
