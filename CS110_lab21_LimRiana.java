import java.util.*;

public class Main {
	// Main method accepts input and implements the solve method.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		while( in.hasNext() ) {
			n = in.nextInt();
			if( n == 0 ) {
				break;
			}
			solve(n);
		}
	}
	// Adds integers 1 to n to a queue, creates a copy of this queue, and then brute forces for the smallest m.
	public static void solve( int n ) {
		Queue<Integer> q = new LinkedList<Integer>();
		int checker = 0;
		int toPoll = 0;
		int temp = 0;
		for( int i = 1; i <= n; i++ ){ // Adds to queue
			q.offer(i);
		}
		for( int i = 1; i <= 1000; i++ ) {
			Queue<Integer> tempQ = new LinkedList<Integer>(q); // Copies queue
			checker = i;
			while( tempQ.size() > 1 ) {
				toPoll = tempQ.poll();
				if( checker == i ) {
					checker = 1;
				} else {
					tempQ.offer(toPoll);
					checker++;
				}
			}
			temp = tempQ.poll(); 
			if ( temp == 13 ) { // Checks if last item is 13, then prints the i as the final answer.
				System.out.println(i);
				break;
			}
			
		}
		
	}
}