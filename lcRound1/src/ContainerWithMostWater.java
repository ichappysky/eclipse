public class ContainerWithMostWater {
	public int maxArea(int[] h) {
		if (h == null || h.length <= 1) {
			return 0;
		}
		int left = 0;
		int right = h.length - 1;
		int max = 0;

		while (left <= right) {
			max = Math.max(max, Math.min(h[left], h[right]) * (right - left));
			if (h[left] < h[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}