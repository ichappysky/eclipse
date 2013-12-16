package oct18;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length. The order of elements can be changed. It doesn't
 * matter what you leave beyond the new length.
 * 
 * @author yongz
 * 
 */
public class MistakeRemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int end = 0;
		int cur = 0;

		while (cur < A.length) {
			if (A[cur] != elem) {
				A[end] = A[cur];
				end++;
			}
			cur++;
		}

		// mistake: returned "end+1"
		return end;

	}
}
