package first;

import java.util.Scanner;

public class PolynomialEvaluationB {
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
		p = a[0];
		power = 1;
		for(int i = 1; i < n; i++) {
			power = power * x;
			p = p + (a[i]*power);
		}
		System.out.println(p);
	}
}
