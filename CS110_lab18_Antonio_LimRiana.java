import java.util.*;

public class CS110_lab18_Antonio_LimRiana {
	
	// Main method accepts input while in.hasNext() is true. prints out the value string.
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		String postfix = "";
		String value = "";
		while( in.hasNext() ) {
			postfix = in.nextLine();
			value = solve(postfix);
			System.out.println(value);
		}
	}
	
	// Solve method returns a string of the answer. checks each character in the string postfix and treats them accordingly.
	public static String solve( String postfix ) {
		Stack<Integer> st = new Stack<Integer>();
		int stackBoy = 0; // Stack counter
		char temp = '!';
		int intTemp = 0;
		String stringTemp = "";
		int a = 0;
		int b = 0;
		int operated = 0;
		
		// Iterates through postfix string and treats each character accordinly by either pushing to stack or popping and performing an operation.
		for ( int i = 0; i < postfix.length(); i++ ) {
			temp = postfix.charAt(i);
			intTemp = Character.getNumericValue(temp);
			stringTemp = Character.toString(temp);
			if ( stackBoy >= 2 && stringTemp.matches("^[+-/*^]$") ) {
				a = st.pop();
				b = st.pop();
				if( temp == '+' ) {
					operated = a+b;
				} else if ( temp == '*' ) {
					operated = a*b;
				} else if ( temp == '-' ) {
					operated = a-b;
				} else if ( temp == '/' ) {
					operated = (int) b/a;
				} else if ( temp == '^' ) {
					operated = (int) Math.pow(b,a);
				}
				st.push(operated);
				stackBoy-=1;
			} else if ( stackBoy >= 2 && stringTemp.matches("^[1234567890]$") ) {
				st.push(intTemp);
				stackBoy++;
			} else {
				if ( stringTemp.matches("^[1234567890]$") ) {
					st.push(intTemp);
					stackBoy++;
				} else {
					return "ERROR";
				}
			}
		}

		// Checks if stack has only one element, and then returns it.
		if ( stackBoy != 1 ) {		
			return "ERROR";
		} else {
			return Integer.toString(st.pop());
		}
	}
}