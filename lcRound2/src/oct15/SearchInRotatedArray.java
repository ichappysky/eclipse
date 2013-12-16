package oct15;

public class SearchInRotatedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] == target) {
				return mid;
			}

			// mistake: used < instead of <=
			if (A[low] <= A[mid]) {
				if (A[low] <= target && target < A[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}