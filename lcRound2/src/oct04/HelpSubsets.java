package oct04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets.
 * 
 * For example, If S = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author yongz
 * 
 */
public class HelpSubsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (s == null || s.length == 0) {
			return result;
		}
		Arrays.sort(s);
		for (int i = 0; i < (1 << s.length); i++) {
			ArrayList<Integer> oneList = new ArrayList<Integer>();
			for (int j = 0, num = i; num > 0; num >>= 1, j++) {
				if ((num & 1) == 1) {
					oneList.add(s[j]);
				}
			}
			result.add(oneList);
		}
		return result;

	}
}