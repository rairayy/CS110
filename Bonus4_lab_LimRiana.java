import java.util.*;

public class Bonus4_lab_LimRiana {
	
	public static Node root;
	
	// Main method accepts input and inserts into the tree. Also prints expected output.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int temp = 0;
		int testCase = 0;
		while(in.hasNext()) {
			n = in.nextInt();
			temp = in.nextInt();
			root = new Node(temp);
			for( int i = 1; i < n; i++ ) {
				temp = in.nextInt();
				insert( new Node(temp), root );
			}
			System.out.printf("Test case #%d: ", ++testCase);
			preorder(root);
			System.out.println();
		}
	}
	
	// Inserts node into the tree.
	public static Node insert( Node newNode, Node root ) {
		int key = newNode.key;
		if( root == null ) {
			root = newNode;
			return root;
		}
		if( key < root.key ) {
			root.leftChild = insert( newNode, root.leftChild );
		} else if ( key > root.key ) {
			root.rightChild = insert( newNode, root.rightChild );
		}
		return root;
	}
	
	// Does preorder traversal on the tree and prints each node.
	public static void preorder( Node root ) {
		System.out.print(root.key + " ");
		if( root.leftChild != null ) {
			preorder( root.leftChild );
		}
		if( root.rightChild != null ) {
			preorder( root.rightChild );
		}
		if( root.leftChild == null && root.rightChild == null ) {
			return;
		}
	}
	
	// Node class.
	public static class Node {
		int key;
		Node leftChild;
		Node rightChild;
		
		public Node( int val ) {
			key = val;
			leftChild = null;
			rightChild = null;
		}
	}
}