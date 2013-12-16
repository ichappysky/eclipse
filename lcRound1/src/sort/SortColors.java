package sort;
public class SortColors {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int zeroPos = 0;
		int twoPos = A.length - 1;
		// this is maintained
		// 0000 zeroPos 111 ixxxx twoPos 2222
		for (int i = 0; i <= twoPos; i++) {
			if (A[i] == 0) {
				swap(A, zeroPos, i);
				zeroPos++;
			} else if (A[i] == 2) {
				swap(A, twoPos, i);
				twoPos--;
				// go back once so we can check i in next iteration;
				i--;
			}
			// move forward if A[i]==1
		}

	}

	private void swap(int[] a, int zeroPos, int i) {
		int tmp = a[zeroPos];
		a[zeroPos] = a[i];
		a[i] = tmp;

	}
}