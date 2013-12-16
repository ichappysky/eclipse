package oct07;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}
		if (word1 == null) {
			return word2.length();
		}
		if (word2 == null) {
			return word1.length();
		}

		Map<String, Integer> endIndexesToCountMap = new HashMap<String, Integer>();
		return helper(word1, word1.length() - 1, word2, word2.length() - 1,
				endIndexesToCountMap);

	}

	private int helper(String word1, int endIndex1, String word2,
			int endIndex2, Map<String, Integer> endIndexesToCountMap) {
		if (endIndex1 < 0 && endIndex2 < 0) {
			return 0;
		}
		if (endIndex1 < 0) {
			return endIndex2 + 1;
		}
		if (endIndex2 < 0) {
			return endIndex1 + 1;

		}
		String key = endIndex1 + ":" + endIndex2;
		if (endIndexesToCountMap.containsKey(key)) {
			return endIndexesToCountMap.get(key);
		}
		if (word1.charAt(endIndex1) == word2.charAt(endIndex2)) {
			return helper(word1, endIndex1 - 1, word2, endIndex2 - 1,
					endIndexesToCountMap);
		}
		int result = Math.min(
				Math.min(
						helper(word1, endIndex1 - 1, word2, endIndex2,
								endIndexesToCountMap) + 1,
						helper(word1, endIndex1, word2, endIndex2 - 1,
								endIndexesToCountMap) + 1),
				helper(word1, endIndex1 - 1, word2, endIndex2 - 1,
						endIndexesToCountMap) + 1);
		endIndexesToCountMap.put(key, result);
		return result;
	}

	public static void main(String[] x) {
		EditDistance t = new EditDistance();
		t.minDistance("a", "ab");
	}
}