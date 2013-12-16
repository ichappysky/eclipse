package oct22;

public class HelpMedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int mid = (m + n) / 2;
		return helper(A, B, Math.max(0, mid - n), Math.min(mid, m - 1));
	}

	private double helper(int A[], int B[], int left, int right) {
		int m = A.length;
		int n = B.length;
		int mid = (m + n) / 2;
		if (left > right) {
			return helper(B, A, Math.max(0, mid - m), Math.min(n - 1, mid));
		}

		int i = (left + right) / 2;
		int j = mid - i - 1;
		if ((j >= 0 && j < n) && A[i] < B[j]) {
			return helper(A, B, i + 1, right);
		}
		if ((j >= -1 && j < n - 1) && A[i] > B[j + 1]) {
			return helper(A, B, left, i - 1);
		}
		if ((m + n) % 2 == 1 || (i == 0 && (j < 0 || j > n - 1))) {
			return A[i];
		}
		if (j < 0 || j > n - 1) {
			return (A[i] + A[i - 1]) / 2.0;
		}
		if (i == 0) {
			return (A[i] + B[j]) / 2.0;
		}
		return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
	}
}
