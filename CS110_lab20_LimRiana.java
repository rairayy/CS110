import java.util.*;

public class Main {
	// Main method accepts input and implements the solve method.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = -1;
		while( in.hasNext() ) {
			a = in.nextInt();
			if( a == 0 ) {
				break;
			}
			solve(a);
		}
	}
	
	// Adds the numbers to the queue, and follows the procedure. Appends to StringBuilders.
	public static void solve( int a ) {
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder discards = new StringBuilder();
		StringBuilder remaining = new StringBuilder();
		discards.append("Discarded cards:");
		remaining.append("Remaining card: ");
		int temp = 0;
		
		for( int i = 1; i <= a; i++ ) { // Adds to queue
			q.offer(i);
		}
		
		while( q.size() > 1 ) { // Solves while queue size is still greater than 1
			discards.append(" " + Integer.toString(q.poll()));
			if( q.size() > 1 ) {
				discards.append(",");
			}
			temp = q.poll();
			q.offer(temp);
		}
		
		remaining.append(Integer.toString(q.poll())); // Adds remining integer to remaining StringBuilder
		System.out.println(discards.toString());
		System.out.println(remaining.toString());
	}
}
