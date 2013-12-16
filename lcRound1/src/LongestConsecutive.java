import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
	public class Solution {
		public int longestConsecutive(int[] num) {
			if (num == null || num.length==0) {
				return 0;
			}
			// boundaries of each segment have segment length as value; the
			// inside element has 1
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int max = 1;
			for (int i : num) {
				if (map.containsKey(i)) {
					continue;
				}
				map.put(i, 1);
				if (map.containsKey(i - 1)) {
					int mergedLen = mergeTwoSeg(map, i - 1, i);
					max = max < mergedLen ? mergedLen : max;
				}
				if (map.containsKey(i + 1)) {
					int mergedLen = mergeTwoSeg(map, i, i + 1);
					max = max < mergedLen ? mergedLen : max;
				}
			}

			return max;
	    }

		// return length of merged seg.
		private int mergeTwoSeg(Map<Integer, Integer> map, int left, int right) {
			int leftLen = map.get(left);
			int rightLen = map.get(right);
			int totalLen = leftLen+ rightLen;
			int leftMostIndex = left - leftLen + 1;
			int rightMostIndex = right + rightLen - 1;
			map.put(leftMostIndex , totalLen);
			map.put(rightMostIndex, totalLen);
			return totalLen;
		}
	}
}
