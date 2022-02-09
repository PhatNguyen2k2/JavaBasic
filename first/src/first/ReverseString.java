package first;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String rev = new StringBuffer(s).reverse().toString();
		System.out.println(rev);
		sc.close();
	}
}
