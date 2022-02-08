package first;

import java.util.Scanner;

public class Input {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String address = sc.next();
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		sc.close();
	}
}
