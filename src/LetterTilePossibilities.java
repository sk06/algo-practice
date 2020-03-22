import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/*
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  
 * Return the number of possible non-empty sequences of letters you can make.

Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: "AAABBC"
Output: 188
 

Note:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
 */
public class LetterTilePossibilities {
	
	public int numTilePossibilities(String tiles) {
		
		Set<String> set = new HashSet<>();
        permute2("", tiles, set);
        return set.size();
    }
	
	public static void main(String[] args){
		LetterTilePossibilities solution = new LetterTilePossibilities();
		//solution.permute("", "ABC");
		System.out.println(solution.numTilePossibilities("ABC"));
		//System.out.println(solution.permute3("ABC"));
	}
	
	private void permute(String soFar, String rest) {
		System.out.println(soFar); //prints all lengths
		if (rest.isEmpty()){
			//System.out.println(soFar); // prints full length only
			return;
		} else {
			for (int i=0; i < rest.length(); i++){
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i+1);
				permute(next, remaining);		
			}	
		}
	}
	
	private void permute2(String soFar, String rest, Set<String> set) {

		if (!soFar.isEmpty())set.add(soFar); //prints all lengths
		if (rest.isEmpty()){
			return;
		} else {
			for (int i=0; i < rest.length(); i++){
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i+1);
				permute2(next, remaining, set);		
			}	
		}

	}
	
	private Set<String> permute3(String tiles) {

		if (tiles.length() <= 1) {
			return Collections.singleton(tiles);
		}
		Set<String> ret = new HashSet<>();
		for (int i = 0; i < tiles.length(); i++) {
			String temp = String.valueOf(tiles.charAt(i));
			String newTiles = tiles.substring(0, i) + tiles.substring(i + 1);
			Set<String> perms = permute3(newTiles);
			ret.addAll(perms);
			ret.addAll(perms.stream().map(p -> temp + p)
					.collect(Collectors.toSet()));
		}
		return ret;
	
	}

}
