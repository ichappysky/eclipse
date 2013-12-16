package oct13;

import java.util.ArrayList;

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		if (num == null || num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		return helper(num, 0);
	}

	private ArrayList<ArrayList<Integer>> helper(int[] num, int start) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (start >= num.length) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		ArrayList<ArrayList<Integer>> subresult = helper(num, start + 1);
		int cur = num[start];
		for (ArrayList<Integer> oneList : subresult) {
			for (int i = 0; i <= oneList.size(); i++) {
				ArrayList<Integer> copy = new ArrayList<Integer>(oneList);
				copy.add(i, cur);
				result.add(copy);
			}
		}
		return result;

	}
}
