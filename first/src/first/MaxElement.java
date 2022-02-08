package first;

import java.util.Scanner;

public class MaxElement {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			arr[i] = sc.nextInt();
		}
		int maxValue = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] > maxValue)	maxValue = arr[i];
		}
		System.out.println("Max value: " + maxValue);
		sc.close();
	}
}
