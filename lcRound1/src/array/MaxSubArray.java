package array;
public class MaxSubArray {
	public int maxSubArray(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int curMax = 0;
		for (int i : a) {
			curMax += i;
			if (max < curMax) {
				max = curMax;
			}
			if (curMax < 0) {
				curMax = 0;
			}
		}

		return max;
	}
}
