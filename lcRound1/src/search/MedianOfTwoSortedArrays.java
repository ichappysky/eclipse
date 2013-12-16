package search;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length, n = B.length, mid = (m + n) / 2;
		return findMedian(A, B, Math.max(0, mid - n), Math.min(m - 1, mid));

	}

	private double findMedian(int A[], int B[], int left, int right) {
		int m = A.length;
		int n = B.length;
		int mid = (m + n) / 2;
		if (left > right) {
			return findMedian(B, A, Math.max(0, mid - m), Math.min(n - 1, mid));
		}

		int i = (left + right) / 2, j = mid - i - 1;
		if (j >= 0 && A[i] < B[j]) // A[i] < median
			return findMedian(A, B, i + 1, right);
		if (j < n - 1 && A[i] > B[j + 1]) // A[i] > median
			return findMedian(A, B, left, i - 1);
		// found median
		// m+n is odd
		if ((m + n) % 2 == 1 || (i == 0 && (j < 0 || j >= n)))
			return A[i];
		// m+n is even
		if (j < 0 || j >= n)
			return (A[i] + A[i - 1]) / 2.0;
		if (i == 0)
			return (A[i] + B[j]) / 2.0;
		return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
	}

	public static void main(String[] x) {
		MedianOfTwoSortedArrays t = new MedianOfTwoSortedArrays();
		System.out.println(t.findMedianSortedArrays(new int[] {1,2,3,4},
				new int[] { 5,6 }));
	}
}