package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		ArrayList<Integer> path = new ArrayList<Integer>();
		Set<ArrayList<Integer>> solutionKeys = new HashSet<ArrayList<Integer>>();
		helper(num, 0, target, path, solutionKeys, result);
		return result;
	}

	private void helper(int[] num, int startIndex, int target,
			ArrayList<Integer> path, Set<ArrayList<Integer>> solutionKeys,
			ArrayList<ArrayList<Integer>> result) {
		if (target < 0) {
			return;

		}
		if (target == 0) {
			
			if (solutionKeys.add(path)) {
				result.add(new ArrayList<Integer>(path));
			}
			return;
		}

		for (int i = startIndex; i < num.length; i++) {
			path.add(num[i]);
			helper(num, i + 1, target - num[i], path, solutionKeys,
					result);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] a) {
		CombinationSum2 t = new CombinationSum2();
		t.combinationSum2(new int[] { 1, 2 }, 4);
	}
}