package search;

public class SearchRotatedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		return helper(A, 0, A.length - 1, target);
	}

	private int helper(int[] a, int s, int e, int target) {
		if (s > e) {
			return -1;
		}
		int mid = (s + e) / 2;
		if (target == a[mid]) {
			return mid;
		}
		if (a[s] <= a[mid]) {
			if (a[s] <= target && target < a[mid]) {
				return helper(a, s, mid - 1, target);
			} else {
				return helper(a, mid + 1, e, target);
			}
		} else {
			if (a[mid] < target && target <= a[e]) {
				return helper(a, mid + 1, e, target);
			} else {
				return helper(a, s, mid - 1, target);
			}
		}
	}
}