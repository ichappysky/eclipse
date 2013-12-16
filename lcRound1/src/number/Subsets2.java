package number;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		// seed it with empty subset first
		result.add(new ArrayList<Integer>());
		int prevSize = 0;
		for (int i = 0; i < num.length; i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				if (i == 0 || num[i] != num[i - 1] || j >= prevSize) {
					ArrayList<Integer> cur = new ArrayList<Integer>(
							result.get(j));
					cur.add(num[i]);
					result.add(cur);
				}
			}
			prevSize = size;
		}
		return result;
	}

	public static void main(String[] x) {
		Subsets2 t = new Subsets2();
		t.subsetsWithDup(new int[]{1,2,2,2});
	}
}
