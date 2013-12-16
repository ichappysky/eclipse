public class TrappingRainWater {
	public int trap(int[] A) {
		if (A == null && A.length <= 2) {
			return 0;
		}

		// find index of max
		int indexOfMax = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[indexOfMax] < A[i]) {
				indexOfMax = i;
			}
		}
		int result = 0;
		int curHigh = 0;
		// left part
		for (int i = 0; i < indexOfMax; i++) {
			if (curHigh < A[i]) {
				curHigh = A[i];
			} else {
				result += curHigh - A[i];
			}
		}

		// right part
		curHigh = 0;
		for (int i = A.length - 1; i > indexOfMax; i--) {
			if (curHigh < A[i]) {
				curHigh = A[i];
			} else {
				result += curHigh - A[i];
			}
		}

		return result;
	}
}