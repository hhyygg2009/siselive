package oj1059;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt()-1;
		List<Integer> al = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			al.add(i);
		}
		int x=m;
		while(al.size()>1) {			
			al.remove(x);
			x+=m;
			x%=al.size();
		}
		System.out.println(al.get(0));
	}

}
