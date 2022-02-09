package first;

import java.util.Scanner;

public class SumOfArray {
	public static int sum(int[] arr) {
		int ans = 0;
		for(int i = 0; i < arr.length; i++) {
			ans += arr[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(sum(arr));
		sc.close();
	}
}
