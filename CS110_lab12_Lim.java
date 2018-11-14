import java.util.*;

public class CS110_lab12_Lim {
	
	// Main method that takes in user input and runs the sorting methods
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int oddCount = 0;
		int evenCount = 0;
		int test = 1;
		int lastEven = 0;
		int lastOdd = 0;
		
		while( in.hasNext() ) {
			n = in.nextInt();
			boolean[] parity = new boolean[n];
			int[] ary = new int[n];
			
			// Updates array to check for parity and updates main array
			for ( int i = 0; i < n; i++ ) {
				ary[i] = in.nextInt();
				if ( ary[i]%2 == 0 ) {
					parity[i] = true;
					evenCount++;
				} else {
					oddCount++;
				}
			}
			
			// Creates odd and even arrays
			int[] odds = new int[oddCount];
			int[] evens = new int[evenCount];
			
			// Updates odd and even arrays
			lastEven = 0;
			for ( int i = 0; i < n; i++ ) { // Odd array
				if(parity[i]) {
					evens[lastEven] = ary[i];
					lastEven++;
				}
			}
			
			lastOdd = 0;
			for ( int i = 0; i < n; i++ ) { // Odd array
				if(!parity[i]) {
					odds[lastOdd] = ary[i];
					lastOdd++;
				}
			}
			
			// Sort odd and even arrays
			sortOdds(odds,0,odds.length-1);
			sortEvens(evens,0,evens.length-1);
			
			// Updates main array with sorted odd and even arrays based on parity
			lastEven = 0;
			lastOdd = 0;
			for ( int i = 0; i < n; i++ ) {
				if (parity[i]) { // Needs even
					ary[i] = evens[lastEven];
					lastEven++;
				} else { // Needs odd
					ary[i] = odds[lastOdd];
					lastOdd++;
				}
			}
			
			// Creates a string based on the array
			StringBuilder sb = new StringBuilder();
			for ( int i = 0; i < n; i++ ) {
				if ( i != n-1 ) {
					sb.append(ary[i] + " ");
				} else {
					sb.append(ary[i]);
				}
			}
			
			// Prints out the string and conditionally places line breaks
			System.out.println("Test case #" + test + ":");
			if ( in.hasNext() ) {
				System.out.print(sb.toString() + "\n\n");
			} else {
				System.out.print(sb.toString());
			}
			
			// Resets the StringBuilder
			sb.setLength(0);
			
			// Increments counter variable
			test++;
			oddCount = 0;
			evenCount = 0;
		}		
	}
	
	// Method for sorting the odd array
	public static void sortOdds(int[] ary, int a, int b) {
		if ( a < b ) {
			int pivot = ary[b];
			int l = a;
			int r = b-1;
			// Runs while the left and right side indicators haven't intersected yet
			while ( l <= r ) {
				// Looks for an element in the left side that is smaller than the pivot (out of place)
				while ( l <= r && ary[l] >= pivot ) {
					l = l+1;
				}
				// Looks for an element in the right side that is larger than the pivot (out of place)
				while ( r >= l && ary[r] <= pivot ) {
					r = r-1;
				}
				// Swap the left and right elements
				if ( l < r ) {
					swap(ary,l,r);
				}
			}
			// Put pivot where it should be
			swap(ary,l,b);
			
			// Recurr the sortOdds() method
			sortOdds(ary,a,b-1);
			sortOdds(ary,a+1,b);
		}
	}
	
	
	// Method for sorting the even array
	public static void sortEvens(int[] ary, int a, int b) {
		// Runs if a and b haven't intersected yet
		if ( a < b ) {
			int pivot = ary[b];
			int l = a;
			int r = b-1;
			
			// Runs while the left and right side indicators haven't intersected yet
			while ( l <= r ) {
				
				// Looks for an element in the left side that is larger than the pivot (out of place)
				while ( l <= r && ary[l] <= pivot ) {
					l = l+1;
				}
				// Looks for an element in the right side that is smaller than the pivot (out of place)
				while ( r >= l && ary[r] >= pivot ) {
					r = r-1;
				}
				
				// Swap the left and right elements
				if ( l < r ) {
					swap(ary,l,r);
				}
			}
			
			// Put pivot where it should be
			swap(ary,l,b);
			
			// Recurr the sortEvens() method
			sortEvens(ary,a,b-1);
			sortEvens(ary,a+1,b);
		}
	}
	
	// Method for swapping array elements
	public static void swap(int[] ary, int l, int r) {
		int temp = ary[l];
		ary[l] = ary[r];
		ary[r] = temp;
	}
}