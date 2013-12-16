package oct07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"]
 * 
 * @author yongz
 * 
 */
public class WordBreak2 {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return new ArrayList<String>();
		}

		Map<Integer, ArrayList<String>> indexToWordsMap = new HashMap<Integer, ArrayList<String>>();
		return helper(s, 0, dict, indexToWordsMap);

	}

	private ArrayList<String> helper(String s, int index, Set<String> dict,
			Map<Integer, ArrayList<String>> indexToWordsMap) {
		ArrayList<String> result = new ArrayList<String>();
		if (index >= s.length()) {
			return result;
		}
		if (indexToWordsMap.containsKey(index)) {
			return indexToWordsMap.get(index);
		}

		for (int i = 1; i <= s.length() - index; i++) {
			String cur = s.substring(index, index + i);
			if (dict.contains(cur)) {
				if (i == s.length() - index) {
					result.add(cur);
				} else {
					ArrayList<String> sentences = helper(s, index + i, dict,
							indexToWordsMap);
					for (String sentence : sentences) {
						result.add(cur + " " + sentence);
					}
				}
			}
		}
		indexToWordsMap.put(index, result);
		return result;
	}

	public static void main(String[] x) {
		WordBreak2 t = new WordBreak2();
		System.out.println(t.wordBreak("ab",
				new HashSet<String>(Arrays.asList("a", "b"))));
	}
}