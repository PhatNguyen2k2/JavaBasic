package first;

import java.util.Scanner;

public class StringMatching {
	public static void main(String[] args) {
		String T, P;
		Scanner sc = new Scanner(System.in);
		T = sc.nextLine();
		P = sc.nextLine();
		sc.close();
		int n = T.length();
		int m = P.length();
		for(int i = 0; i<=(n-m); i++) {
			int j = 0;
			while(j < m && P.charAt(j) == T.charAt(i+j)) {
				j++;
				if(j == m) {
					System.out.println(i);
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
