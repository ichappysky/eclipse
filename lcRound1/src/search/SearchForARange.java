package search;

public class SearchForARange {

	public int[] searchRange(int[] A, int target) {

		return searchRangeImp(A, 0, A.length - 1, target);
	}

	public int[] searchRangeImp(int[] A, int left, int right, int target) {
		int mid = (left + right) / 2;

		if (left > right)
			return new int[] { -1, -1 };

		if (A[left] == A[right] && A[right] == target)
			return new int[] { left, right };

		if (A[mid] < target)
			return searchRangeImp(A, mid + 1, right, target);
		else if (A[mid] > target)
			return searchRangeImp(A, left, mid - 1, target);
		else {
			int[] leftRange = searchRangeImp(A, left, mid, target);
			int[] rightRange = searchRangeImp(A, mid + 1, right, target);
			if (leftRange[0] == -1)
				return rightRange;
			else if (rightRange[0] == -1)
				return leftRange;
			else
				return new int[] { leftRange[0], rightRange[1] };
		}
	}

	public static void main(String[] a) {
		SearchForARange t = new SearchForARange();
		System.out.print(t.searchRange(new int[] { 1, 3 }, 1));
	}

}