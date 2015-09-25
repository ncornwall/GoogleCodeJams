package OtherPuzzles;

/**
 * Given a number n, print following pattern without using any loop.
 * 
 * Input: n = 16
 * Output: 16, 11, 6, 1, -4, 1, 6, 11, 16
 * 
 * Input: n = 10
 * Output: 10, 5, 0, 5, 10
 */
public class PatternsWithoutLoops {
	
	public static int increment = 5;
	public static int patternStart = 10;

	public static void printPattern(int n, Boolean incrementing){
		System.out.println(n);
	
		if (n == patternStart && incrementing){
			return;
		}
		else if (n <= 0 || incrementing){
			n = n + increment;
			printPattern(n, true);
		}
		else {
			n = n - increment;
			printPattern(n, false);
		}
	}
	
	public static void main(String[] args) {
		printPattern(patternStart, false);
	}
}
