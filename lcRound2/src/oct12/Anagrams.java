package oct12;

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

		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			String key = getKey(str);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		for (ArrayList<String> value : map.values()) {
			if (value.size() > 1) {
				result.addAll(value);
			}
		}

		return result;

	}

	private String getKey(String str) {
		char[] tmp = str.toCharArray();
		Arrays.sort(tmp);
		return String.valueOf(tmp);
	}
}