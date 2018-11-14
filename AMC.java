import java.util.*;

public class AMC {
	public static void main(String[] args) {
		int n = 5000000;
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, Boolean.TRUE);
		
		for ( int i = 2; i*i <= n; i++ ) {
			if ( isPrime[i] ) {
				for ( int j = i*2; j <= n; j += i ) {
					isPrime[j] = false;
				}
			}
		}
		long sumOfPrimes = 0;
		 for (int i = 2; i <= n; i++) {
            if (isPrime[i]) sumOfPrimes+=i;
        }
		
		System.out.println(sumOfPrimes);
	}
}