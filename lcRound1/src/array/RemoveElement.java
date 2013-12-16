package array;

public class RemoveElement {
	public int removeElement(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int behind = 0;
		int forward = 0;
		for (; forward < A.length; forward++) {
			if (A[forward] == target) {
				continue;
			}
			A[behind] = A[forward];
			behind++;
		}
		return behind;
	}
}