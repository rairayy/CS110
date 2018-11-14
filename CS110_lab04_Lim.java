import java.util.*;

public class CS110_lab04_Lim {
	static boolean[] squares = new boolean[100000000];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = 0;
		int b = 0;
		
		Arrays.fill(squares,false);
		checkIfPerfect();
		
		for ( int i = 0; i < n; i++ ) {
			a = in.nextInt();
			b = in.nextInt();
			solve(a,b);
		}
	}
	
	public static void solve(int a, int b) {
		double sum = 0.0;
		double ave = 0.0;
		int n = 0;
		
		for ( int i = a; i <= b; i++ ) {
			if ( i > 0 && squares[i] == true ) {
				sum += (double) i;
				n++;
			}
		}
		
		if ( n != 0 ) {
			ave = sum/n;			
			System.out.printf("%.2f\n",ave);
		} else {
			System.out.printf("0.00\n");
		}
		sum = 0;
		ave = 0.0;
	}
	
	public static void checkIfPerfect() {
		for ( int i = 1; i < squares.length; i++ ) {
			double sqrt = Math.sqrt(i);
			int x = (int) sqrt;
			if ( Math.pow(sqrt,2) == Math.pow(x,2)) {
				squares[i] = true;
			}
		}
	}
}