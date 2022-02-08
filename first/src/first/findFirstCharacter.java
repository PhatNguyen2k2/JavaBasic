package first;

import java.util.Scanner;

public class findFirstCharacter {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char c = sc.next().charAt(0);
		int ans = -1;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
