import java.util.*;

public class Lab09_Bandiola_Lim {
	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		
		// Read test cases
		int numCases = sc.nextInt();
		for (int i = 1; i <= numCases; ++i) {
			sc.nextLine(); sc.nextLine(); // flush out the extra newline characters
			
			//read the contents of the dictionary
			String input = sc.nextLine();
			String[] dictionary = input.split(" ");  // use white space  as delimiter
			
			// read the target strings that will be searched for in the dictionary
			int numTargets = sc.nextInt();
			String[] arrTargets = new String[numTargets];
			for (int j = 0; j < numTargets; ++j) {
				arrTargets[j] = sc.next();
			}
			
			//solve the problem instance
			solve(i,dictionary,arrTargets);
			
		}
		sc.close();

	}
	
	// int i: test case
	// String[] dictionary: Array of all words to compare to
	//String[] arrTargets: Array of words to be compared
	public static void solve(int i, String[] dictionary, String[] arrTargets) {
		// for each element in arrTargets, do a binary search
		for ( int j = 0; j < arrTargets.length; j++ ) {
				System.out.printf("Test case #%d.%d: %d (%s)\n", i, j+1, BinarySearch(dictionary, arrTargets[j], 0, dictionary.length-1), arrTargets[j]);
		}
		System.out.println(); //print a line break after each test case
	}
	
	// String[] dictionary: Array of all words to compare to
	// String arrTargets: the actual word to be compared to each and every word in the dictionary
	// int start: start of index of comparison
	// int end: end of index of comparison
	public static int BinarySearch( String[] dictionary, String arrTargets, int start, int end ) {
		int middle = (int) Math.floor((start+end)/2);
		if( start > end ) {
			return -1;
		} else {
			if (arrTargets.compareTo(dictionary[middle]) == 0) {
				return middle;
			} else if (arrTargets.compareTo(dictionary[middle]) < 0) { // negative, target is before middle
				return BinarySearch( dictionary, arrTargets, start, middle-1 );
			} else { // positive, target is after middle
				return BinarySearch( dictionary, arrTargets, middle+1, end);
			}
		}
	}
}