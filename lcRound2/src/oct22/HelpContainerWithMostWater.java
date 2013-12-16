package oct22;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author yongz
 * 
 */
public class HelpContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int left = 0;
		int right = height.length - 1;
		int max = 0;
		while (left < right) {
			max = Math.max(max, Math.min(height[left], height[right])
					* (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}

		}

		return max;
	}
}