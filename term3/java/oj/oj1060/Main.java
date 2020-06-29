package oj1060;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt()-1,l=sc.nextInt();
		List<Integer> al = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			al.add(i);
		}
		int x=m;
		while(al.size()>l) {			
			al.remove(x);
			x+=m;
			x%=al.size();
		}
		for(int y:al)
		System.out.print(y+" ");
	}

}
