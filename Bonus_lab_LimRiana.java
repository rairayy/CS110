import java.util.*;

public class Main {
	// Main method, sorry Sir I just used one method because I didn't know how to do this using a solve method :-(
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCase = 1;
		
		// While has next
		while( in.hasNext() ) {
			int t = in.nextInt();
			if( t == 0 ) break; // stops if t is 0
			
			// Hashmap for keeping each number's respective teams
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int a;
			for( int i = 0; i < t; i++ ) {
				a = in.nextInt();
				for ( int j = 0; j < a; j++ ) {
					hm.put(in.nextInt(), i); // key is element, value is team
				}
			} in.nextLine();
			
			StringBuilder sb = new StringBuilder();
			sb.append("Scenario #" + testCase + "\n");
			testCase++;
			
			// Instatiates an array of Queues
			Queue<Integer>[] queues = new Queue[t];
			for(int i = 0; i < t; i++) {
				queues[i] = new LinkedList<Integer>(); 	
			}
			// Queue that keeps track of which is the head queue
			LinkedList<Integer> headQueue = new LinkedList<Integer>();
			boolean[] containsTeam = new boolean[t]; // Checks if the headqueue list contains the team
			
			String s = "";
			// Does the enqueue dequeue stuff
			while( !(s = in.nextLine()).equals("STOP") ) {
				String[] sA = s.split(" ");
				String op = sA[0];
				if( op.equals("ENQUEUE") ) {
					int toEnqueue = Integer.parseInt(sA[1]);
					int teamID = hm.get(toEnqueue);
					if( !containsTeam[teamID] ) { // If the headqueue does not have the team yet, add it
						containsTeam[teamID] = true;
						headQueue.addLast(teamID);
					}
					queues[teamID].offer(toEnqueue);
				} else {
					int head = headQueue.peekFirst();
					int toPoll = queues[head].poll();
					if( queues[head].size() == 0 ) { // If the queue size is 0, update the head queue
						headQueue.pollFirst();
						containsTeam[head] = false;
					}
					sb.append(toPoll + "\n");
				}
			}
			
			System.out.println(sb.toString());
			sb.setLength(0);
		}
		
	}
}