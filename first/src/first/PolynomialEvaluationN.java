package first;

import java.util.Scanner;

public class PolynomialEvaluationN {
	public static void main(String[] args) {
		float p;
		int n, x, power;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		float[] a = new float[n];
		for(int i = 0; i<n; i++) {
			a[i] = sc.nextFloat();
		}
		sc.close();
		p = 0;
		for(int i = n; i > 0; i--) {
			power = 1;
			for(int j = 1; j < i; j++) {
				power = power * x;
			}
			p = p + (a[i] * power);
		}
		System.out.println(p);
	}
}
