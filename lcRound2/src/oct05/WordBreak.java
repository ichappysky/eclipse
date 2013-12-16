package oct05;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author yongz
 * 
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
		return helper(s, 0, dict, cache);
	}

	private boolean helper(String s, int startIndex, Set<String> dict,
			Map<Integer, Boolean> cache) {
		if (startIndex >= s.length()) {
			return true;
		}
		if (cache.containsKey(startIndex)) {
			return cache.get(startIndex);
		}
		for (int i = 1; i <= s.length() - startIndex; i++) {
			String cur = s.substring(startIndex, startIndex + i);
			if (dict.contains(cur)) {
				if (helper(s, startIndex + i, dict, cache)) {
					cache.put(startIndex, true);
					return true;
				}
			}
		}
		cache.put(startIndex, false);
		return false;
	}
}