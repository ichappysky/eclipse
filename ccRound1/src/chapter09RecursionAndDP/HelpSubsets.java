package chapter09RecursionAndDP;

import java.util.ArrayList;

public class HelpSubsets {
	public static ArrayList<ArrayList<Integer>> getSubsets(
			ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (index < 0) { // was wrong with index==0
			result.add(new ArrayList<Integer>()); // missed this
			return result;
		}

		ArrayList<ArrayList<Integer>> subResult = getSubsets(set, index - 1);
		result.addAll(subResult);
		int cur = set.get(index);
		for (ArrayList<Integer> oneList : subResult) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.addAll(oneList);
			newList.add(cur);
			result.add(newList);
		}
		return result;
	}

	public static ArrayList<ArrayList<Integer>> getSubsets2(
			ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < (1 << set.size()); i++) {

			result.add(convertIntToList(set, i));
		}
		return result;
	}

	private static ArrayList<Integer> convertIntToList(ArrayList<Integer> set,
			int num) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int index = 0;
		for (int i = num; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				result.add(set.get(index));
			}
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		System.out.println(list);
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list,
				list.size() - 1);
		System.out.println(subsets.toString());

		 ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
		 System.out.println(subsets2.toString());
	}

}
