package first;

import java.util.Scanner;

public class firstOccurrenceOfS2InS1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		System.out.print(s1.indexOf(s2));
		sc.close();
	}
}
