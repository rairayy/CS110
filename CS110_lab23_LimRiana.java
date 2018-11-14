import java.util.*;

public class CS110_lab23_LimRiana {
	
	// Global swap counters.
	private static int swaps = 0;
	private static int p1Swaps = 0; // Counts phase 1 swaps.
	private static int p2Swaps = 0; // Counts phase 2 swaps.

	// Main method that takes in input and inserts it into a heap array. Also prints the required output.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int testCase = 0;
		while( in.hasNext() ) {
			n = in.nextInt();
			int[] inputAry = new int[n];
			int[] ary = new int[n];
			testCase++;
			System.out.printf("Test case #%d\n", testCase);
			for( int i = 0; i < n; i++ ) {
				inputAry[i] = in.nextInt();
				ary[i] =  inputAry[i];
				heapify(ary, i, n);
			}
			arrayPrinter("Input array", inputAry);
			p1Swaps = swaps;
			swaps = 0;
			heapSort(ary);
			arrayPrinter("Sorted array", ary);
			p2Swaps = swaps;
			swaps = 0;
			System.out.printf("\tPhase 1 total swaps: %d\n", p1Swaps);
			System.out.printf("\tPhase 2 total swaps: %d\n\n", p2Swaps);
		}
	}
	
	// Used to build the array into a max heap as values are being inserted.
	public static void heapify( int[] ary, int root, int n ) {
		int parent = (int) Math.floor((root-1)/2);
		if( root > 0 ) {
			while( parent >= 0 && ary[root] > ary[parent] ) {
				swap(ary, root, parent);
				swaps++;
				root = parent;
				parent = (int) Math.floor((root-1)/2);
			}
		}
	}
	
	// Reheapifies the heap after the maximum value is swapped with the last value.
	public static void reheapify( int[] ary, int parent, int n ) {
		int left = (2*parent) + 1;
		int right = (2*parent) + 2;
		while( left < n || right < n ) {
			if( left < n && right < n && ary[left] > ary[right] && ary[left] > ary[parent] ) {
				swap( ary, left, parent );
				swaps++;
				parent = left;
				left = (2*parent) + 1;
				right = (2*parent) + 2;
			} else if ( left < n && right < n && ary[left] < ary[right] && ary[right] > ary[parent] ) {
				swap( ary, right, parent );
				swaps++;
				parent = right;
				left = (2*parent) + 1;
				right = (2*parent) + 2;
			} else if( left < n && ary[left] > ary[parent] ) {
				swap( ary, left, parent );
				swaps++;
				parent = left;
				left = (2*parent) + 1;
			} else {
				return;
			}
		}
	}
	
	// Method for swapping values in an array.
	public static void swap( int[] ary, int a, int b ) {
		int temp = ary[a];
		ary[a] = ary[b];
		ary[b] = temp;
	}
	
	// Method for sorting the heap.
	public static void heapSort( int[] ary ) {
		int n = ary.length-1;
		for( int i = n; i >= 1; i-- ) {
			int temp = ary[0];
			ary[0] = ary[i];
			ary[i] = temp;
			swaps++;
			for( int j = 0; j < i; j++ ) {
				reheapify(ary, j, i);
			}
		}
	}
	
	// Prints the array using the specified format.
	public static void arrayPrinter( String s, int[] ary ) {
		int n = ary.length;
		System.out.printf("\t%s: (", s);
		for( int i = 0; i < n; i++ ) {
			if( i != n-1 )
				System.out.print(ary[i]+ ", ");
			else
				System.out.print(ary[i]);
		}
		System.out.println(")");
	}
}