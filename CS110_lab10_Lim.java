import java.util.*;

public class CS110_lab10_Lim {

	public static int length = 1;
	// Main method for taking in input
	public static void main(String[] args) {	
	
		// Read the test cases
		Scanner in = new Scanner( System.in );
		while (in.hasNext()) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			solve( n1, n2 );
		}
	}
	
	// Computes for the max cycle length of all numbers between n1 and n2 by calling on the computeCycleLength method within a for-loop and then updating the variable max when necessary
	public static void solve( int n1, int n2 ) {
		
		int max = 1;
		
		// Iterates from n1 to n2 and compares the result of computeCycleLength() with the current max value
		if ( n1 < n2 ) {
			for ( int i = n1; i <= n2; i++ ) {
				length = 1;
				max = Math.max(max, computeCycleLength(i));
			}
		} else {
			for ( int i = n2; i <= n1; i++ ) {
				length = 1;
				max = Math.max(max, computeCycleLength(i));
			}			
		}

		// Print the output to the console 
		System.out.printf( "%d %d %d\n", n1, n2, max );
	}

	// Recursively computes the cycle length of an integer n
	// If n is even, n = n/2
	// If n is odd, n = (n*3)+1
	public static int computeCycleLength( int n ) {
		
		// int length = 1;
		if ( n == 1 ) { // base case
			return length;
		} else {
			length++;
			if ( n%2 == 0 ) {
				n = n/2;
				return computeCycleLength(n);
			} else {
				n = (n*3) + 1;
				return computeCycleLength(n);
			}
		}
		
	}

}