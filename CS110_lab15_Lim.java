import java.util.*;

public class CS110_lab15_Lim {
	
	// Main method that takes in input and calls the sort() method.
	public static void main( String[] args ) {
		
		Scanner sc = new Scanner( System.in );
		int n = 0;
		double mod = 0;
		int ctr = 1;
		int value = 0;
		int repition = 0;
		
		// Variables for formatting
		int totalReps = 0;
		int cols = 0;
		int maxNum = 0;
		int maxLength = 0;
		boolean hasNeg = false;
		
		// Takes in input while scanner has next
		while(sc.hasNext()) {
			n = sc.nextInt();
			
			// Instantiates negative, positive, and final ArrayList<>s
			ArrayList<Integer> negArray = new ArrayList<Integer>();
			ArrayList<Integer> posArray = new ArrayList<Integer>();
			ArrayList<Integer> finalArray = new ArrayList<Integer>();
			
			// Putting input inside the array
			for ( int i = 0; i < n; i++ ) {
				value = sc.nextInt();
				repition = sc.nextInt();
				totalReps += repition;
				if ( value >= 0 ) {
					maxNum = Math.max(value, maxNum);
					for( int j = 0; j < repition; j++ ) {
						posArray.add(value);
					}
				} else {
					value = value*-1;
					maxNum = Math.max(value, maxNum);
					for ( int j = 0; j < repition; j++ ) {
						negArray.add(value);						
					}
					hasNeg = true;
				}
			}

			cols = sc.nextInt();
			
			// Uses radix sort on both posArray and negArray.
			maxLength = Integer.toString(maxNum).length();
			for ( int i = 0 ; i < maxLength ; i++ ) {
				mod = Math.pow(10,i);
				sort( posArray, mod );
				sort( negArray, mod );
			}
			
			// Adds the stuff in the negative array to the final array
			for ( int i = negArray.size()-1; i >= 0; i-- ) {
				finalArray.add(-1*negArray.get(i));
			}
			// Adds the stuff in the positive array to the final array
			for ( int i = 0; i < posArray.size(); i++ ) {
				finalArray.add(posArray.get(i));
			}
			
			int finIndex = 0;
			int colCounter = 0;
			int padding = 0;
			int insert = 0;
			
			if ( hasNeg ) {
				maxLength++;
			}
			
			// Prints out the contents of the final array
			System.out.println( "Test case #" + ctr + ":" );
			while ( finIndex < totalReps ) {
				insert = finalArray.get(finIndex);
				System.out.printf("%"+maxLength+"d\t", insert);
				finIndex++;
				colCounter++;
				if ( colCounter == cols && finIndex != totalReps) {
					colCounter = 0;
					System.out.println();					
				}
				if ( finIndex == totalReps ) {
					System.out.println("\n");
				}
			}
			
			finIndex = 0;
			totalReps = 0;
			maxLength = 0;
			maxNum = 0;
			hasNeg = false;
			ctr++;
		}
	}

	// Performs radix sort on array
	public static void sort( ArrayList<Integer> array, double mod ) {
		int index = 0;
		int ogarrayindex = 0;
		int tempInt = 0;
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		
		for ( int i = 0; i < 10; i++ ) {
			al.add(new ArrayList<Integer>());	
		}
		
		// Getting indices and adding to the ArrayList
		for ( int i = 0 ; i < array.size() ; i++ ) {
			index = (int) Math.floor(array.get(i)/mod)%10;
			al.get(index).add(array.get(i));
		}
		
		// Returns the sorted array back to the array
		ArrayList<Integer> tempAl = new ArrayList<Integer>();
		for ( int bucketNumber = 0; bucketNumber < 10; bucketNumber++ ) {
			for ( int bucketBucket = 0; bucketBucket < al.get(bucketNumber).size(); bucketBucket++ ) {
				array.set(ogarrayindex, al.get(bucketNumber).get(bucketBucket));
				ogarrayindex++;
			}
		}
	}
	
}