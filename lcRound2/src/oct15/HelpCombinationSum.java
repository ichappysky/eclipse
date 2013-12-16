package oct15;

import java.util.ArrayList;
import java.util.Arrays;

public class HelpCombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(candidates, 0, target, path, result);
		return result;
	}

	private void helper(int[] num, int startIndex, int target,
			ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<Integer>(path));
		}
		for (int i = startIndex; i < num.length; i++) {
			if (num[i] > target) {
				break;
			}
			path.add(num[i]);
			helper(num, i, target - num[i], path, result);
			path.remove(path.size() - 1);
		}
	}

}
