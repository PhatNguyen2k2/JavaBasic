package first;

import java.util.Scanner;

public class Abs {
	public static void main (String[] args) {
		double a,b;
		Scanner sc = new Scanner (System.in);
		System.out.println("Nhap a: ");
		a = sc.nextDouble();
		System.out.println("Nhap b: ");
		b = sc.nextDouble();
		//Declare Math
		int x = Math.abs(-4);
		System.out.print(x);
		sc.close();
	}

}

