import java.util.*;

public class Main {
	
	// Main method that takes in input and runs the solve() method
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		long temp = 0;
		int tempIndex = 0;
		ArrayList<Long> ll = new ArrayList<Long>();
		
		// Adds to the ArrayList<> while there is still input
		while(in.hasNext()) {
			temp = in.nextLong();
			if (ll.size() >= 1) {
				
				// Inserts when it finds a value that is larger
				for ( int i = 0; i < ll.size(); i++ ) {
					if(ll.get(i) <= temp) {
						tempIndex = i+1;
					}
				}
				ll.add(tempIndex,temp);
			} else {
				ll.add(temp);
			}			
			// System.out.println(Arrays.toString(ll.toArray()));
			solve(ll);
			tempIndex = 0;
		}
	}
	
	// Method for printing the median
	public static void solve(ArrayList<Long> ll) {
		int size = ll.size();
		if ( size%2 == 0 ) {
			System.out.println((ll.get(size/2)+ll.get(size/2-1))/2);
		} else {
			System.out.println(ll.get(size/2));
		}
	}
}