import java.util.*;

public class CS110_lab05_Lim {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = 0;
		int b = 0;
		int[] choices = new int[100000000];
		
		for (int i = 1; i <= n; i++ ) {
			a = in.nextInt();
			b = in.nextInt();
			for ( int j = 0; j < b; j++ ) {
				choices[j] = in.nextInt();
			}
			System.out.println(solve(a,choices,b,i));
			Arrays.fill(choices,0);
		}
	}
	
		public static String solve( int a, int[] c, int b, int test) {
		String s = "";
		for ( int i = 0; i < b; i++ ) {
			for ( int j = i+1; j < b; j++ ) {
				for ( int k = j+1; k < b; k++ ) {
					if ( c[i]+c[j]+c[k] == a ) {
						return "Test case #" + test + ": " + c[i] + " + " + c[j] + " + " + c[k] + " = " + a;
					}
				}
			}
		}
		
		return "Test case#" + test + ": Required triple not found.";
	}
}