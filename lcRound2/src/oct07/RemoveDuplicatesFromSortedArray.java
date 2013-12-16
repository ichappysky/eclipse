package oct07;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int prev = 0;
		for (int cur = 0; cur < A.length; cur++) {
			if (A[prev] == A[cur]) {
				continue;
			}
			A[++prev] = A[cur];
		}

		return prev + 1;
	}
}