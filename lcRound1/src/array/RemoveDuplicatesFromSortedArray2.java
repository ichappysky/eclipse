package array;

public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int cur = 0;
		int dupCount = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[cur]) {
				dupCount++;
				continue;
			}
			if (dupCount == 0) {
				cur++;
				A[cur] = A[i];

			} else {
				// exact one duplicate, jump to i
				A[cur + 1] = A[cur];
				A[cur + 2] = A[i];
				cur = cur + 2;
			}
			dupCount = 0;

		}

		if (dupCount > 0) {
			cur++;
			A[cur] = A[cur - 1];
		}
		return cur+1;
	}
}