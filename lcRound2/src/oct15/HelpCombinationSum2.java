package oct15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HelpCombinationSum2 {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> path = new ArrayList<Integer>();
		Set<ArrayList<Integer>> solutions = new HashSet<ArrayList<Integer>>();
		helper(candidates, 0, target, path, solutions, result);
		return result;
	}

	private void helper(int[] num, int startIndex, int target,
			ArrayList<Integer> path, Set<ArrayList<Integer>> solutions,
			ArrayList<ArrayList<Integer>> result) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			if (solutions.add(path)) {
				result.add(new ArrayList<Integer>(path));
			}
		}
		for (int i = startIndex; i < num.length; i++) {
			if (num[i] > target) {
				break;
			}
			path.add(num[i]);
			helper(num, i + 1, target - num[i], path, solutions, result);
			path.remove(path.size() - 1);
		}
	}

}
