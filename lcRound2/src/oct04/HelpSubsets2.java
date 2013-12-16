package oct04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets.
 * 
 * For example, If S = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author yongz
 * 
 */
public class HelpSubsets2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDupIterative(int[] s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (s == null || s.length == 0) {
			return result;
		}
		Arrays.sort(s);
		result.add(new ArrayList<Integer>());
		int prevSize = 0;
		for (int i = 0; i < s.length; i++) {
			int curSize = result.size();
			for (int j = 0; j < curSize; j++) {
				if (i == 0 || s[i] != s[i - 1] || j >= prevSize) {
					ArrayList<Integer> curList = new ArrayList<Integer>(
							result.get(j));
					curList.add(s[i]);
					result.add(curList);
				}
			}
			prevSize = curSize;
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDupRecursive(int[] s) {
		ArrayList<Integer> path = new ArrayList<Integer>();

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (s == null || s.length == 0) {
			return result;
		}
		Arrays.sort(s);
		helper(s, 0, path, result);
		return result;
	}

	void helper(int[] s, int begin, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> result) {
		result.add(new ArrayList<Integer>(path));

		for (int i = begin; i < s.length; ++i) {
			if (i != begin && s[i] == s[i - 1])
				continue;

			path.add(s[i]);
			helper(s, i + 1, path, result);
			if (i==0) {
				System.out.print("ya");
			}
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] x) {
		HelpSubsets2 t = new HelpSubsets2();
		System.out.println(t.subsetsWithDupRecursive(new int[] { 1, 1, 2 }));
	}
}
