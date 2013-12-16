package number;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		if (num == null || num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(num);
		return perm(num, 0, new boolean[num.length]);
	}

	private ArrayList<ArrayList<Integer>> perm(int[] num, int l, boolean[] used) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (l == num.length) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		for (int i = 0; i < num.length; i++) {
			if (used[i] || (i != 0 && num[i] == num[i - 1] && used[i - 1])) {
				continue;
			}
			used[i] = true;
			for (ArrayList<Integer> x : perm(num, l + 1, used)) {
				x.add(0, num[i]);
				result.add(x);
			}
			used[i] = false;
		}
		return result;
	}

	public static void main(String[] a) {
		Permutations2 t = new Permutations2();
		t.permuteUnique(new int[] { 1, 1, 1, 2, 2 });
	}
}