package array;
public class MergeSortedArrays {
	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		while (j >= 0) {
			// A is done. Copy rest of B to A
			if (i < 0) {
				A[j] = B[j];
				j--;
			} else if (A[i] < B[j]) {
				A[i + j + 1] = B[j];
				j--;
			} else {
				A[i + j + 1] = A[i];
				i--;
			}
		}
	}

}
