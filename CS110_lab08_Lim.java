import java.util.*;

public class CS110_lab08_Lim {
	public static Scanner in = new Scanner(System.in);
	public static int test = 1;
	public static boolean palindrome = false;
	
	public static void main(String[] args) {		
		takeInput(in.nextLine());
	}
	
	public static void takeInput( String s ) {
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z[:space:]]","");
		if (isPalindrome(s, 0, s.length()-1, s.length())) {
			System.out.printf("Test case #%d: YES\n", test );
		} else {
			System.out.printf("Test case #%d: NO\n", test );
		}
		test++;
		if ( in.hasNext() ) {
			takeInput( in.nextLine() );
		}
		
	}
	
	public static boolean isPalindrome( String s, int first, int last, int len ) {
		boolean b = true;
		
		if ( s.length() == 0 ) {
			return b;
		}
		
		if ( len%2 == 0 ) {
			if ( last-first == 1 ) {
				return b;
			}
			if ( s.charAt(first) != s.charAt(last) ) {
				b = false;
				return b;
			}
			return isPalindrome( s, first+1, last-1, len);
		} else {
			if ( last-first == 0 ) {
				return b;
			}
			if ( s.charAt(first) != s.charAt(last) ) {
				b = false;
				return b;
			}
			return isPalindrome( s, first+1, last-1, len);
		}
	}
}