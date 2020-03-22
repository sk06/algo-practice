import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 */
public class ReplaceWords {

	public String replaceWords(List<String> dict, String sentence) {
		
		Set<String> dictSet = dict.stream().collect(Collectors.toSet()); 
		StringBuilder currentWord = new StringBuilder();
		String[] words = sentence.split("\\s+");
		List<String> result = new ArrayList<>(words.length);
		for(String word : words){
			int i=0, n = word.length();
			while (i < n){
				currentWord.append(word.charAt(i));
				if (dictSet.contains(currentWord.toString()) || i == n-1){
					//append if in dict or end of the word
					result.add(currentWord.toString());
					currentWord = new StringBuilder();
					break;
				}
				i++;
			}
		}
		return String.join(" ", result);
    }
	
	public String replaceWordsTrie(List<String> dict, String sentence) {
		
		TrieNode root = buildTrie(dict);
		String[] words = sentence.split("\\s+");
		List<String> result = new ArrayList<>(words.length);

		for(String word : words){
			TrieNode current = root;
			int n = word.length();
			for (int i = 0; i<n; i++){
				current = current.getChildren().get(word.charAt(i));
				if (current == null){
					result.add(word);
					break;
				}
				if (i == n-1 || current.isLeaf){
					//append if in dict or end of the word or trie node is leaf
					result.add(word.substring(0, i+1));
					break;
				}
			}
		}
		return String.join(" ", result);
    }
	
	
	private TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode(Character.MIN_VALUE);
		for(String word : dict){
			int n = word.length();
			TrieNode current = root;
			for (int i = 0; i<n; i++){
				TrieNode child = (current.getChildren() != null && current.children.get(word.charAt(i)) != null) ? current.children.get(word.charAt(i)) : new TrieNode(word.charAt(i));
				current.addChild(child);
				if (i == n-1)
					child.isLeaf = true;
				current = child;
			}
		}
		return root;
	}
	
	class TrieNode {
		char c;
		Map<Character, TrieNode> children;
		boolean isLeaf;
		
		public TrieNode(char c){
			this.c = c;
		}
		
		public TrieNode(char c, boolean isLeaf){
			this.c = c;
			this.isLeaf = isLeaf;
		}
		
		public void addChild(TrieNode child){
			if (this.children == null){
				children = new HashMap<>();
			}
			this.children.put(child.getVal(), child);
		}
		
		public char getVal(){
			return c;
		}
		
		public Map<Character, TrieNode> getChildren(){
			return children;
		}
		
		public boolean isLeaf(){
			return isLeaf;
		}
	}

	public static void main(String[] args) {
		ReplaceWords solution = new ReplaceWords();
		//System.out.println(solution.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
		//System.out.println(solution.replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
		//System.out.println(solution.replaceWordsTrie(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
		//System.out.println(solution.replaceWordsTrie(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
		
		System.out.println(solution.replaceWordsTrie(Arrays.asList("e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"),
				"ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"));
	}
}
