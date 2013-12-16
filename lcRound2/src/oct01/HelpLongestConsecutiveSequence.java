package oct01;

import java.util.HashMap;
import java.util.Map;

public class HelpLongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxLen = 1;
		for (int i : num) {
			if (map.containsKey(i)) {
				continue;
			}
			map.put(i, 1);
			if (map.containsKey(i - 1)) {
				maxLen = Math.max(mergeTwo(i - 1, i, map), maxLen);
			}
			if (map.containsKey(i + 1)) {
				maxLen = Math.max(mergeTwo(i, i + 1, map), maxLen);
			}
		}
		return maxLen;
	}

	private int mergeTwo(int left, int right, Map<Integer, Integer> map) {
		int leftLen = map.get(left);
		int rightLen = map.get(right);
		int totalLen = leftLen + rightLen;
		int leftMostIndex = left - leftLen + 1;
		int rightMostIndex = right + rightLen - 1;
		map.put(leftMostIndex, totalLen);
		map.put(rightMostIndex, totalLen);
		return totalLen;

	}

	public static void main(String[] x) {
		HelpLongestConsecutiveSequence t = new HelpLongestConsecutiveSequence();
		t.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 });
	}
}
