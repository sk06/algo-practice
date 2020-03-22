import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible 
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {
	
	public List<Integer> partitionLabels(String S) {
		
		Map<Character, Integer> indexMap = new HashMap<>();
		for (int i =0 ; i< S.length(); i++){
			indexMap.put(S.charAt(i), i);
		}
		
		List<Integer> indices = new ArrayList<>();
		for (int i =0 ; i< S.length(); ){
			char s = S.charAt(i);
			int index = indexMap.get(s);
			index = getTrueEndOfPartition(S, indexMap, i, index);
			indices.add((index-i)+1);
			i = index+1;
		}
		return indices; 
    }
	
	public int getTrueEndOfPartition(String S, Map<Character, Integer> indexMap, int start, int end) {
		int indexSoFar = 0;
		for (int i =start ; i <= end; i++){
			int index = indexMap.get(S.charAt(i));
			if (indexSoFar<=index){
				indexSoFar = index;
				end = indexSoFar;
			}
		}
		return indexSoFar;		
	}

	public static void main(String[] args) {
		PartitionLabels solution = new PartitionLabels();
		System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(solution.partitionLabels("vhaagbqkaq"));
		System.out.println(solution.partitionLabels("qiejxqfnqceocmy"));
	}

}
