package string;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 1;
		}
		if (word1 == null) {
			return word2.length();
		}
		if (word2 == null) {
			return word1.length();
		}
		Map<String, Integer> distanceMap = new HashMap<String, Integer>();
		return helper(word1, 0, word2, 0, distanceMap);
	}

	private int helper(String word1, int i, String word2, int j,
			Map<String, Integer> distanceMap) {
		String key = i + "_" + j;
		if (distanceMap.containsKey(key)) {
			return distanceMap.get(key);
		}
		int steps = 0;
		if (j == word2.length() && i < word1.length()) {
			steps = word1.length() - i;
		} else if (i == word1.length() && j < word2.length()) {
			steps = word2.length() - j;
		} else if (i < word1.length() && j < word2.length()) {
			if (word1.charAt(i) == word2.charAt(j)) {
				return helper(word1, i + 1, word2, j + 1, distanceMap);
			}
			int replaceSteps = helper(word1, i + 1, word2, j + 1, distanceMap) + 1;
			int addSteps = helper(word1, i, word2, j + 1, distanceMap) + 1;
			int deleteSteps = helper(word1, i + 1, word2, j, distanceMap) + 1;
			steps = Math.min(replaceSteps, Math.min(addSteps, deleteSteps));
		}
		distanceMap.put(key, steps);
		return steps;
	}
}
