package oct14;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author yongz
 * 
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int indexOfMax = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[indexOfMax]) {
				indexOfMax = i;
			}
		}
		int total = 0;
		int curMax = A[0];
		for (int i = 1; i < indexOfMax; i++) {
			if (curMax < A[i]) {
				curMax = A[i];
			} else {
				total += curMax - A[i];
			}
		}
		curMax = A[A.length - 1];
		for (int i = A.length - 2; i > indexOfMax; i--) {
			if (curMax < A[i]) {
				curMax = A[i];
			} else {
				total += curMax - A[i];
			}
		}
		return total;
	}
}