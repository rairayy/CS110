import java.util.*;

public class CS110_lab02_Lim {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); in.nextLine();
		boolean[] primes = new boolean[10000];
		Arrays.fill(primes, Boolean.TRUE);
		
		for ( int i = 2; i < 10000; i++ ) {
			if ( primes[i] == true ) {
				for ( int j = i*2; j < 10000; j += i ) {
					primes[j] = false;
				}
			}
		}
		
		primes[0] = false;
		primes[1] = false;
		
		int k1 = 0;
		int k2 = 0;
		int ctr = 0;
		for ( int i = 0; i < n; i++ ) {
			k1 = in.nextInt();
			k2 = in.nextInt();
			in.nextLine();
			
			for ( int j = k1; j <= k2; j++ ) {
				if ( primes[j] == true ) {
					ctr++;
				}
			}
			
			System.out.println(ctr);
			ctr = 0;
		}
		
		// System.out.println(Arrays.toString(primes));
		
	}
}