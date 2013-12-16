package number;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		if (num == null || num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}

		return helper(num, num.length - 1);

	}

	private ArrayList<ArrayList<Integer>> helper(int[] num, int index) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (index == 0) {
			result.add(new ArrayList<Integer>(Arrays.asList(num[0])));
			return result;
		}
		for (ArrayList<Integer> list : helper(num, index - 1)) {
			for (int i = 0; i <= list.size(); i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer> (list);
				tmp.add(i, num[index]);
				result.add(tmp);
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		Permutations t = new Permutations();
		int[] num = {0, 1};
		System.out.println(t.permute(num));
	}
}