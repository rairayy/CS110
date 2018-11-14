import java.util.*;

public class CS110_lab06_Lim {
	
	static TreeSet<Integer> t = new TreeSet<>();
	static ArrayList<Integer> al = new ArrayList<>();
	
	// Main method. Adds values to the TreeSet and ArrayList. Executes the solve function.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = 0;
		int temp = 0;
		
		for ( int i = 1; i <= m; i++ ) {
			n = in.nextInt();
			for ( int j = 0; j < n; j++ ) {
				temp = in.nextInt();
				if ( al.contains(temp) ) {
					t.add(temp);				
				} else {
					al.add(temp);
				}
			}
			solve(temp, i);
		}
	}
	
	// Solve method. Removes the first item from the TreeSet, and then checks if it is empty. Prints out the final answer.
	public static void solve( int temp, int i ) {
		t.pollFirst();
		if ( !t.isEmpty() )
			System.out.printf("Test Case #%d: %d\n", i, t.first());
		else
			System.out.printf("Test Case #%d: -1\n", i);
		
		t.clear();
		al.clear();
	}
}