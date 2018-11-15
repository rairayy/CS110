import java.util.*;

public class Main {
	
	// Main method takes input while in.hasNext() is true. Iterates through the array of elements and uses the solve method on each one. Prints out the finalString.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		while (in.hasNext()) {
			input = in.nextLine();
			String[] elements = input.split(" ");
			String finalString = "";
			for( int i = 0; i < elements.length; i++ ) {
				finalString += solve(elements[i]);
				if ( i != elements.length-1 ) {
					finalString += " ";
				}
			}
			System.out.println(finalString);
		}
	}
	
	// Pushes each character of the word, then pops them to form a new word.
	public static String solve(String word) {
		Stack<Character> st = new Stack<Character>();
		String newWord = "";
		for( int j = 0; j < word.length(); j++ ) {
			st.push(word.charAt(j));
		}
		while( !st.empty() ) {
			newWord += st.pop();
		}
		return newWord;
	}
}