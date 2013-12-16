import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 4) {
			return result;
		}
		Map<Integer, ArrayList<Pair>> sumToPairsMap = new HashMap<Integer, ArrayList<Pair>>();

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				ArrayList<Pair> list = sumToPairsMap.get(sum);
				if (list == null) {
					list = new ArrayList<Pair>();
					sumToPairsMap.put(sum, list);
				}
				list.add(new Pair(i, j));
			}
		}

		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int key = target - num[i] - num[j];
				ArrayList<Pair> list = sumToPairsMap.get(key);
				if (list == null) {
					continue;
				}
				for (Pair pair : list) {
					if (pair.i == i || pair.j == i || pair.i == j
							|| pair.j == j) {
						continue;
					}
					ArrayList<Integer> oneList = new ArrayList<Integer>(
							Arrays.asList(num[i], num[j], num[pair.i],
									num[pair.j]));
					Collections.sort(oneList);
					set.add(oneList);
				}
			}
		}
		result.addAll(set);
		return result;

	}
}

class Pair {
	public int i;
	public int j;

	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
}