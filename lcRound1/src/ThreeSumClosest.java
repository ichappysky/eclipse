import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);

		int min;
		min = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int curSum = num[i] + num[j] + num[k];
				int curDiff = target - curSum;
				if (Math.abs(curDiff) < Math.abs(target - min)) {
					min = curSum;
				}
				if (curDiff < 0) {
					k--;
				} else if (curDiff > 0) {
					j++;

				} else {
					return min;
				}
			}
		}
		return min;
	}

	public static void main(String[] a) {
		ThreeSumClosest t = new ThreeSumClosest();
		System.out
				.println(t.threeSumClosest(new int[] { 1, 1, -1, -1, 3 }, -1));
	}
}