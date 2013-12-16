package oct22;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return Integer.MAX_VALUE;
		}

		Arrays.sort(num);
		int result = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int cur = num[i] + num[j] + num[k];
				int curDiff = cur - target;
				if (Math.abs(cur - target) < Math.abs(result - target)) {
					result = cur;
				}
				if (curDiff == 0) {
					return target;
				} else if (curDiff > 0) {
					k--;
				} else {
					j++;
				}
			}
		}

		return result;

	}

}
