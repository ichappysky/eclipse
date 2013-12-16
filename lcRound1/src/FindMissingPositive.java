public class FindMissingPositive {

	public int firstMissingPositive(int[] A) {
		if (A == null) {
			return -1;
		}
		for (int i = 0; i < A.length;) {
			if (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
			} else {
				i++;
			}
		}
		int k = 0;
		for (; k < A.length; k++) {
			if (A[k] != k + 1) {
				break;
			}
		}
		return k + 1;
	}

	
	public static void main(String[]x) {
		FindMissingPositive t = new FindMissingPositive();
		t.firstMissingPositive(new int[]{1,1});
	}
}