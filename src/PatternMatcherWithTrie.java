import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class PatternMatcherWithTrie {

	public static void main(String[] args) {
		String[] hayStackArr = {"abc","acd","akc","abcd","random","dabce","dacce","bcdewe","bcdewe"};
		HashSet<String> haystack = new HashSet<String>();
		Collections.addAll(haystack, hayStackArr);

		String input = "a**";

		List<String> output = new ArrayList<String>();

		checkNeedle(input, haystack, output);


	}
	
	public static class TrieNode{
		private char val;
		private List<TrieNode> children;
		
	}

	private static void checkNeedle(String input, HashSet<String> haystack,
			List<String> output) {
		TrieNode hayStackTrie = createTrieForHayStack(haystack);
		
		
	}

	private static TrieNode createTrieForHayStack(HashSet<String> haystack) {
		TrieNode root = new TrieNode();
		return null;
	}
	
	

}
