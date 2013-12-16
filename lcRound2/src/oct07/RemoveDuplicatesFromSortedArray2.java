package oct07;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int prev = 0;
		int count = 1;
		for (int cur = 1; cur < A.length; cur++) {
			if (A[prev] == A[cur]) {
				count++;
				if (count<3) {
					A[++prev] = A[cur];
				}
			} else {
				A[++prev] = A[cur];
				count =1;
			}

		}

		return prev+1;
	}

	public static void main(String[] x) {
		RemoveDuplicatesFromSortedArray2 t = new RemoveDuplicatesFromSortedArray2();
		int[] a = new int[] { 1, 1, 1, 1, 2, 2, 2,3,3,3,4,5,6,7,7,7,7 };
		System.out.println(t
				.removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}
}