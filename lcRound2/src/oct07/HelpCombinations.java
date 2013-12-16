package oct07;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n. For example, If n = 4 and k = 2, a solution is: [ [2,4], [3,4],
 * [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author yongz
 * 
 */
public class HelpCombinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// f(n, k) = f(n-1, k) + f(n-1, k-1)
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n < k || n <= 0 || k <= 0) {
			return result;
		}
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				result.add(new ArrayList<Integer>(Arrays.asList(i)));
			}
			return result;
		}
		result.addAll(combine(n - 1, k));
		for (ArrayList<Integer> oneList : combine(n - 1, k - 1)) {
			oneList.add(n);
			result.add(oneList);
		}

		return result;

	}
}