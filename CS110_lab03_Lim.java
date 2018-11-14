import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class CS110_lab03_Lim {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Pair> pairs1 = new ArrayList<Pair>();
		ArrayList<Pair> pairs2 = new ArrayList<Pair>();
		TreeMap<Double, String> map = new TreeMap<Double, String>();
		
		int test = 0;
		
		
		int tempX = 0;
		int tempY = 0;
		
		int tempX1 = 0;
		int tempX2 = 0;
		int tempY1 = 0;
		int tempY2 = 0;
		
		double tempDist = 0.0;
		String tempString = "";
		
		double firstDist = 0.0;
		String firstPair = "";
		
		
		for ( int i = 1; i <= n; i++ ) {
			test = in.nextInt(); in.nextLine();
			
			for ( int j = 0; j < test; j++ ) {
				Pair pair = new Pair(0,0);
		
				tempX = in.nextInt();
				tempY = in.nextInt(); in.nextLine();
				
				pair.updateX(tempX);
				pair.updateY(tempY);
				pairs1.add( pair );
				pairs2.add( pair );
				
			}
			
			for ( int k = 0; k < pairs1.size(); k++) {
				for ( int m = 0; m < pairs2.size(); m++ ) {
					if ( k != m ) {
						tempX1 = (pairs1.get(k)).getX();
						tempY1 = (pairs1.get(k)).getY();
						tempX2 = (pairs2.get(m)).getX();
						tempY2 = (pairs2.get(m)).getY();

						tempDist = Math.sqrt(((tempX2-tempX1)*(tempX2-tempX1))+((tempY2-tempY1)*(tempY2-tempY1)));
						
						tempString = "(" + tempX2 + "," + tempY2 + ") - (" + tempX1 + "," + tempY1 + ")";
						
						map.put(tempDist, tempString);
					}
				}
			}
			
			firstDist = map.firstKey();
			firstPair = map.get(firstDist);
			
			System.out.printf("Test case #%d: %s dist=", i, firstPair);
			DecimalFormat df = new DecimalFormat(".0");
			df.setRoundingMode(RoundingMode.DOWN);
			System.out.println(df.format(firstDist));
			
			map.clear();
			pairs1.clear();
			pairs2.clear();
			
		}
		
	}
	
	public static class Pair {
		int x;
		int y;
		
		public Pair( int x, int y ) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public void updateX( int n ) {
			x = n;
		}
		
		public void updateY( int n ) {
			y = n;
		}
	}
}












