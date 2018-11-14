import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); // Number of cases
		int m = 0; // Number of strings
		int len = 0; // String lengths
		String s = "";
		int inversions = 0;
		
		// Iterate through number of test cases
		for( int i = 0; i < n; i++ ) {
			len = in.nextInt(); // Length of string
			m = in.nextInt(); in.nextLine(); // number of strings
			
			// Create 2D ArrayList
			ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
			for( int k = 0; k < 1500; k++ ) {
				al.add(new ArrayList<String>());
			}
			
			// Iterate through each string in each test case
			for( int j = 0; j < m; j++ ) {
				s = in.nextLine();
				
				// Count number of inversions
				for( int k = 0; k < len; k++ ) {
					for( int l = k+1; l < len; l++ ) {
						if( s.charAt(k) > s.charAt(l) ) {
							inversions++;
						}
					}
				}
				
				al.get(inversions).add(s);
				inversions = 0;
			}
			
			// Print out strings in arrays.
			for( int j = 0; j < 1500; j++ ) {
				for ( int k = 0; k < al.get(j).size(); k++ ) {
					if(al.get(j).get(k) != null) {
						System.out.println(al.get(j).get(k));
					} else {
						break;
					}
				}
			}
			
			if(i != n-1)
				System.out.println();
		}
	}
}