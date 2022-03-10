package first;

import java.util.Scanner;

class Point{
	public int x;
	public int y;
};
public class ClosestPair {
	public static void main(String[] args) {
		int n, index1 = 0, index2 = 0;
		float d;
		float dmin = Float.POSITIVE_INFINITY;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Point[] p = new Point[n];
		for(int i = 0; i<n; i++) {
			p[i] = new Point();
			p[i].x = sc.nextInt();
			p[i].y = sc.nextInt();
		}
		sc.close();
		for(int i = 1; i<n-1; i++) {
			for(int j = i+1; j<n; j++) {
				d = (float) Math.sqrt(Math.pow(p[i].x-p[j].x, 2) + Math.pow((p[i].y-p[j].y), 2));
				if(d<dmin) {
					dmin = d;
					index1 = i;
					index2 = j;
				}
			}
		}
		System.out.println(index1+" "+index2);
	}
}
