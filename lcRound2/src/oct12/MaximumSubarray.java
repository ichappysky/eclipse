package oct12;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		int curMin = 0;
		int max = Integer.MIN_VALUE;
		for (int a : A) {
			curMin += a;
			max = Math.max(max, curMin);
			if (curMin < 0) {
				curMin = 0;
			}

		}
		return max;
	}
}