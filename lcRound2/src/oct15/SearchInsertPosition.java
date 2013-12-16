package oct15;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (mid < start) {
			return start;
		} else {
			return mid;
		}
	}
}