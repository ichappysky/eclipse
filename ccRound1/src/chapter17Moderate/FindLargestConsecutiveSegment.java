package chapter17Moderate;

public class FindLargestConsecutiveSegment {
	public static int getMax(int[] nums) {
		int result = Integer.MIN_VALUE;
		if (nums == null || nums.length == 0) {
			return result;
		}
		int curMax = 0;
		for (int i = 0; i < nums.length; i++) {
			curMax += nums[i];
			result = Math.max(result, curMax);
			if (curMax < 0) {
				curMax = 0;
			}
		}
		return result;
	}

	// ================
	public static void main(String[] args) {
		int[] a = { -2, -8, -3, -2, -4, -10 };
		System.out.println(getMax(a));
		System.out.println(getMaxSum(a));
	}

	public static int getMaxSum(int[] a) {
		int maxSum = 0;
		int runningSum = 0;
		for (int i = 0; i < a.length; i++) {
			runningSum += a[i];
			if (maxSum < runningSum) {
				maxSum = runningSum;
			} else if (runningSum < 0) {
				runningSum = 0;
			}
		}
		return maxSum;
	}

}
