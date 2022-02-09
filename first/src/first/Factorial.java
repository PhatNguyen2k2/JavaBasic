package first;

import java.util.Scanner;

public class Factorial {
	public static int cal(int n) {
		if(n == 1)	return 1;
		return n * cal(n - 1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Factorial of " + n + ": " + cal(n));
		sc.close();
	}
}
