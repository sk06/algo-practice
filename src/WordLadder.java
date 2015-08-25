import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;


public class WordLadder {

	public static void main(String[] args) {
		
		String start = "hit";
		String end = "cog";
		String[] dictArray = {"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		Collections.addAll(dict, dictArray);
		
		System.out.println(ladderLength(start, end, dict));

	}
	
	private static class WordAndItsLength{
		String word;
		int length;
		
		public WordAndItsLength(String word, int length){
			this.word = word;
			this.length = length;
		}
	}

	private static int ladderLength(String start, String end, HashSet<String> dict) {
		
		int length = 1;
		
		//BFS
		LinkedList<WordAndItsLength> workQ = new LinkedList<WordAndItsLength>();
		WordAndItsLength startNode = new WordAndItsLength(start, length);
		WordAndItsLength endNode = new WordAndItsLength(end, Integer.MAX_VALUE);
		workQ.add(startNode);
		dict.add(end);
		
		while (!workQ.isEmpty()){
			WordAndItsLength currentWord = workQ.pop();
			
			if ((currentWord.word).equals(end)){
				return currentWord.length;
			}
			
			for (int i = 0; i < (currentWord.word).length(); i++){
				char[] currWordArr = (currentWord.word).toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currWordArr[i] = c;
					String newWord = new String(currWordArr);
					
					if (dict.contains(newWord)){
						workQ.add(new WordAndItsLength(newWord, currentWord.length+1));
						dict.remove(newWord);
					}
				}
			}
			
		}
		return (endNode.length < Integer.MAX_VALUE)? endNode.length : Integer.MAX_VALUE;
	}

}
