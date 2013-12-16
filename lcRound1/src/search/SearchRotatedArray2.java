package search;

public class SearchRotatedArray2 {
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		return helper(A, 0, A.length - 1, target);
	}

	private boolean helper(int[] a, int s, int e, int target) {
		if (s > e) {
			return false;
		}
		int mid = s + (e - s) / 2;
		if (a[mid] == target) {
			return true;
		}
		if (a[s] == a[e] && a[s] == a[mid]) {
			return helper(a, s, mid - 1, target)
					|| helper(a, mid + 1, e, target);
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