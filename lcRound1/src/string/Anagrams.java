package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();

		if (strs == null || strs.length == 0) {
			return result;
		}
		Map<String, ArrayList<String>> keyToAnagrams = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			// get key
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String key = new String(tmp);
			ArrayList<String> anagrams = keyToAnagrams.get(key);
			if (anagrams == null) {
				anagrams = new ArrayList<String>();
			}
			anagrams.add(str);
			keyToAnagrams.put(key, anagrams);
		}
		for (ArrayList<String> anagrams : keyToAnagrams.values()) {
			if (anagrams.size() > 1) {
				result.addAll(anagrams);
			}
		}

		return result;
	}
}