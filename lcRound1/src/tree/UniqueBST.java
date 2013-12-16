package tree;

import java.util.HashMap;
import java.util.Map;

public class UniqueBST {
	public int numTrees(int n) {
		if (n <= 1) {
			return 1;
		}
		Map<Integer, Integer> nToCountMap = new HashMap<Integer, Integer>();
		nToCountMap.put(0, 1);
		nToCountMap.put(1, 1);
		return helper(n, nToCountMap);
	}

	private int helper(int n, Map<Integer, Integer> nToCountMap) {
		if (nToCountMap.containsKey(n)) {
			return nToCountMap.get(n);
		}
		int sum = 0;
		for (int i = 0; i <= n - 1; i++) {
			int leftCount = helper(i, nToCountMap);
			int rightCount = helper(n - 1 - i, nToCountMap);
			sum += leftCount * rightCount;
		}
		nToCountMap.put(n, sum);
		return sum;
	}
}