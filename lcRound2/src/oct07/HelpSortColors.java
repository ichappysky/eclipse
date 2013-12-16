package oct07;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * @author yongz
 * 
 */
public class HelpSortColors {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int zeroPos = 0;
		int twoPos = A.length - 1;
		for (int i = 0; i <= twoPos; i++) {
			if (A[i] == 0) {
				swap(A, zeroPos, i);
				zeroPos++;
			} else if (A[i] == 2) {
				swap(A, twoPos, i);
				twoPos--;
				i--;
			}
		}
	}

	private void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;

	}
}