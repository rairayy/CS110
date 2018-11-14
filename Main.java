import java.util.*;

public class Main {
	
	// Main method takes in input and prints out answer
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int first = 0;
		int next = 0;
		int outOfOrder = 0;
		
		// Takes in input while scanner has next
		while ( in.hasNext() ) {
			n = in.nextInt();
			
			// Makes array of integers
			int[] ary = new int[n];
			for ( int i = 0; i < n; i++ ) {
				ary[i] = in.nextInt();
			}
			
			// Counts the number of items out of order
			for ( int i = 0; i < n; i++ ) {
				first = ary[i];
				for ( int j = i; j < n; j++ ) {
					next = ary[j];
					if ( next < first ) {
						outOfOrder++;
					}
				}
			}
			
			// Prints out answer
			System.out.printf("Minimum exchange operations : %d\n", outOfOrder);
			outOfOrder = 0;
		}
	}
}