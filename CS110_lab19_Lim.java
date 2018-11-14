import java.util.*;

public class Main {
	// Main method that accepts input for a number of test cases.
	public static void main( String[] args ) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt(); in.nextLine();
		String line = "";
		for ( int i = 0; i < cases; i++ ) {
			StringBuilder infix = new StringBuilder();
			if( i == 0 ) {
				in.nextLine();
			}
			while ( in.hasNext() ) {
				line = in.nextLine();
				if ( line.trim().isEmpty() ) {
					break;
				} else {
					infix.append(line);
				}
			}
			solve(infix.toString());
			if( i != cases-1 ) {
				System.out.println();
			}
		}
	}
	// Solves the string infix and converts to postfix. Prints the final postfix string.
	public static void solve( String infix ) {
		Stack<String> st = new Stack<String>();
		StringBuilder postfix = new StringBuilder();
		String stringTemp = "";
		int len = infix.length();
		char current = '?';
		for( int i = 0; i < len; i++ ) { // Iterates through entire string infix
			current = infix.charAt(i);
			stringTemp = Character.toString(current);
			if( stringTemp.matches("^[+-/*(]$") ) {
				if ( stringTemp.matches("^[+-]$") ) { // If stringTemp is division/multiplication, checks if the next item in the stack is at equal or higher priority, then it keeps popping until it can be added
					while ( !st.isEmpty() && st.peek().matches("^[*/+-]$") ) {
						postfix.append(st.pop());
					}
					st.push(stringTemp);
				} else if ( stringTemp.matches("^[/*]$") ) { // If stringTemp is division/multiplication, checks if the next item in the stack is at equal priority, then it keeps popping until it can be added
					while ( !st.isEmpty() && st.peek().matches("^[*/]$") ) {
						postfix.append(st.pop());
					}
					st.push(stringTemp);
				} else { // If parentheses
					st.push(stringTemp);
				}
			} else if ( stringTemp.equals(")") ) { // Deals with parentheses
				while( !st.peek().equals("(") ) {
					postfix.append(st.pop());						
				}
				st.pop();
			} else { // If number, append to postfix
				postfix.append(stringTemp);
			}
		}
		while ( !st.isEmpty() ) { // Adds the remaining contents to the 
			postfix.append(st.pop());			
		}
		System.out.println(postfix.toString());
	}	
}