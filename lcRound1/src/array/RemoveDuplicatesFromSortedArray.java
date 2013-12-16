package array;
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int cur = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[cur] == A[i]) {
				continue;
			}
			cur = cur + 1;
			A[cur] = A[i];
		}

		return cur + 1;
	}
}