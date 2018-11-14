import java.util.*;

public class CS110_lab22_LimRiana {
	// Main method accepts in put while scanner hasNext() is true and uses the sovle method
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = ""; // input string
		String[] initA; // temporary array for splitting the string
		String trav = ""; // traversal type
		String string = ""; // string to put in array
		int stringLen = 0; // length of string
		while( in.hasNext() ) {
			s = in.nextLine();
			initA = s.split(" ");
			trav = initA[0];
			string = initA[1];
			stringLen = string.length();
			char[] toBinTree = new char[stringLen];
			for( int i = 0; i < stringLen; i++ ) {
				toBinTree[i] = string.charAt(i);
			}
			solve(trav, toBinTree);
			System.out.println();
		}
	}
	// solve method checks what the traversal type is and implements the methods
	public static void solve( String trav, char[] toBinTree ) {
		if( trav.equals("POSTORDER")) {
			postorder(toBinTree, 0);
		} else if ( trav.equals("PREORDER")) {
			preorder(toBinTree, 0);
		} else {
			inorder(toBinTree, 0);
		}
	}
	// recursively uses preorder traversal on the binary tree array and prints
	public static void preorder( char[] toBinTree, int root ) {
		System.out.print(toBinTree[root]);
		int leftChild = (2*root)+1;
		int rightChild = (2*root)+2;
		if( leftChild >= toBinTree.length ) {
			return;
		}
		if( rightChild >= toBinTree.length ) {
			return;
		}
		if( toBinTree[leftChild] != '-' ) {
			preorder( toBinTree, leftChild );
		}
		if( toBinTree[rightChild] != '-' ) {
			preorder( toBinTree, rightChild );
		}
		if( toBinTree[leftChild] == '-' && toBinTree[rightChild] == '-' ) {
			return;
		}
	}
	// recursively uses postorder traversal on the binary tree array and prints
	public static void postorder( char[] toBinTree, int root ) {
		int leftChild = (2*root)+1;
		int rightChild = (2*root)+2;
		if( root >= toBinTree.length ) {
			return;
		}
		if( leftChild < toBinTree.length && toBinTree[leftChild] != '-' ) {
			postorder( toBinTree, leftChild );
		}
		if( rightChild < toBinTree.length &&  toBinTree[rightChild] != '-' ) {
			postorder( toBinTree, rightChild );
		}
		System.out.print(toBinTree[root]);
	}
	// recursively uses inorder traversal on the binary tree array and prints
	public static void inorder( char[] toBinTree, int root ) {
		int leftChild = (2*root)+1;
		int rightChild = (2*root)+2;
		if( root >= toBinTree.length ) {
			return;
		}
		if( leftChild < toBinTree.length && toBinTree[leftChild] != '-' ) {
			inorder( toBinTree, leftChild );
		} else {
			inorder( toBinTree, rightChild );
		}
		System.out.print(toBinTree[root]);
		if( rightChild < toBinTree.length &&  toBinTree[rightChild] != '-' ) {
			inorder( toBinTree, rightChild );
		}
	}
}