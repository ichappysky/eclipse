package oct22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HelpFourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		if (num == null || num.length < 4) {
			return new ArrayList<ArrayList<Integer>>();
		}

		Map<Integer, ArrayList<Pair>> sumToPairsMap = new HashMap<Integer, ArrayList<Pair>>();
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				if (!sumToPairsMap.containsKey(sum)) {
					sumToPairsMap.put(sum, new ArrayList<Pair>());
				}
				sumToPairsMap.get(sum).add(new Pair(i, j));
			}
		}

		Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int pal = target - num[i] - num[j];
				ArrayList<Pair> palPairs = sumToPairsMap.get(pal);
				if (palPairs==null) {
					continue;
				}
				for (Pair p : palPairs) {
					if (p.i == i || p.j == i || p.i == j || p.j == j) {
						continue;
					}
					ArrayList<Integer> solution = new ArrayList<Integer>(
							Arrays.asList(num[i], num[j], num[p.i], num[p.j]));
					Collections.sort(solution);
					result.add(solution);
				}
			}
		}

		return new ArrayList<ArrayList<Integer>>(result);

	}

	public static void main(String[] x) {
		HelpFourSum t = new HelpFourSum();
		t.fourSum(new int[] { 0, 0, 0, 0 }, 1);
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
