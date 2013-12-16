import java.util.ArrayList;
import java.util.List;

public class MinPathInTriagle {
	/** recursive one **/
	public int minimumTotalRecursive(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function

		return minHelper(triangle, 0, 0);
	}

	private int minHelper(ArrayList<ArrayList<Integer>> tri, int i, int j) {
		int rowCount = tri.size();
		assert (i < rowCount);
		// bottom line, return itself
		int cur = tri.get(i).get(j);
		if (i == rowCount - 1) {
			return cur;
		}

		return Math.min(minHelper(tri, i + 1, j), minHelper(tri, i + 1, j + 1))
				+ cur;
	}

	/** iterative */
	public int minimumTotal(ArrayList<ArrayList<Integer>> tri) {
		int rowCount = tri.size();
		List<Integer> minRow = new ArrayList<Integer>();

		// initialize
		for (int j = 0; j < rowCount; j++) {
			minRow.add(j, tri.get(rowCount - 1).get(j));
		}
		// bottom up
		for (int i = rowCount - 2; i >= 0; i--) {
			ArrayList<Integer> curRow = tri.get(i);
			for (int j = 0; j <= i; j++) {
				minRow.set(
						j,
						curRow.get(j)
								+ Math.min(minRow.get(j), minRow.get(j + 1)));
			}
		}

		return minRow.get(0);
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(0, -10);
		tri.add(0, row);
		MinPathInTriagle t = new MinPathInTriagle();
		System.out.println(t.minimumTotal(tri));
	}
}
