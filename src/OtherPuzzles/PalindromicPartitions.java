package OtherPuzzles;
import java.util.ArrayList;

/**
 * A partitioning of the string is a palindrome partitioning if
 * every substring of the partition is a palindrome.
 * Find all possible palindromic partitions of given string.
 * 
 */

public class PalindromicPartitions {
		
	public static Boolean isPalindrome(String s){
		
		for(int i= 0; i< s.length() / 2; i ++){
			if (s.charAt(i) != s.charAt(s.length() - i - 1)){
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<String> getPartitions(String s){
				
		ArrayList<String> results = new ArrayList<String>();
		if (isPalindrome(s)){
			results.add(s);
		}
		
		for (int i = 1; i < s.length(); i ++){
			String substring = s.substring(0, i);
			if (isPalindrome(substring)){
				ArrayList<String> partitions = getPartitions(s.substring(i));
				for (String partition : partitions){
					results.add(substring + " " + partition);
				}
			}
		}
		return results;
	}
}
