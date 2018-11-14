import java.util.*;

public class CS110_lab11_Lim {
	
	// Main function that takes in input, and runs the QSort() method
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int test = 1;
		
		// Takes in input while there is still input to take
		while(in.hasNext()) {
			n = in.nextInt();
			
			// Sets up the array
			int[] ary = new int[n];
			for ( int i = 0; i < n; i++ ) {
				ary[i] = in.nextInt();
			}
			
			// Sorts the array
			QSort(ary,0,ary.length-1);
			
			// Creates a string based on the array
			StringBuilder sb = new StringBuilder();
			for ( int i = 0; i < ary.length; i++ ) {
				if ( i != ary.length-1 ) {
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
		}
	}
	
	
	// Method for sorting the array of integers
	public static void QSort(int[] ary, int a, int b) {
		
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
			
			// Recurr the QSort() method
			QSort(ary,a,b-1);
			QSort(ary,a+1,b);
		}
	}
	
	// Method for swapping array elements
	public static void swap(int[] ary, int l, int r) {
		int temp = ary[l];
		ary[l] = ary[r];
		ary[r] = temp;
	}
}