package oj1056;

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		String word = null;
		SortedSet<String> set = new TreeSet<>();
		while (!in.hasNext("end")) {
			word = in.next();
			set.add(word);

		}
		for (String x : set) {
			System.out.println(x);
		}
		in.close();
	}
}
