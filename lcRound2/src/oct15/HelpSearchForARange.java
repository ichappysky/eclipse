package oct15;

public class HelpSearchForARange {
	public int[] searchRange(int[] A, int target) {
		if (A == null || A.length == 0) {
			return new int[] { -1, -1 };
		}

		return helper(A, 0, A.length - 1, target);
	}

	private int[] helper(int[] A, int start, int end, int target) {
		if (start > end) {
			return new int[] { -1, -1 };
		}

		int mid = start + (end - start) / 2;
		if (A[mid] < target) {
			return helper(A, mid + 1, end, target);
		} else if (A[mid] > target) {
			return helper(A, start, mid - 1, target);
		} else {
			int[] leftRange = helper(A, start, mid - 1, target);
			int[] rightRange = helper(A, mid + 1, end, target);
			int[] result = new int[] { leftRange[0] == -1 ? mid : leftRange[0],
					rightRange[1] == -1 ? mid : rightRange[1] };
			return result;
		}

	}

	public static void main(String[] a) {
		HelpSearchForARange t = new HelpSearchForARange();
		System.out.print(t.searchRange(new int[] { 1 }, 1));
	}

}
