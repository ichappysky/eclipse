package backtracking;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(candidates, 0, target, path, result);
		
		return result;
	}

	private void helper(int[] candidates, int startIndex, int target,
			ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i= startIndex;i<candidates.length; i++) {
			path.add(candidates[i]);
			helper(candidates, i, target-candidates[i], path, result);
			path.remove(path.size()-1);
		}
	}
}
