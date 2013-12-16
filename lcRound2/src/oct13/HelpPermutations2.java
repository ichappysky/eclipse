package oct13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 * @author yongz
 * 
 */
public class HelpPermutations2 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		if (num == null || num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(num);
		return helper(num, num.length, new boolean[num.length]);
	}

	private ArrayList<ArrayList<Integer>> helper(int[] num, int permLen,
			boolean[] used) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (permLen == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		for (int i = 0; i < num.length; i++) {
			if (used[i] || (i > 0 && num[i] == num[i - 1] && used[i - 1])) {
				continue;
			}
			used[i] = true;
			ArrayList<ArrayList<Integer>> subresult = helper(num, permLen - 1,	used);
			for (ArrayList<Integer> onePerm : subresult) {
				if (permLen==5) {
					System.out.println(subresult);
				}
				ArrayList<Integer> copy = new ArrayList<Integer>(onePerm);
				copy.add(0, num[i]);
				result.add(copy);
			}
			used[i] = false;

		}
		return result;
	}

	public static void main(String[] a) {
		HelpPermutations2 t = new HelpPermutations2();
		System.out.println(t.permuteUnique(new int[] { 1, 1, 2 }));
	}
}