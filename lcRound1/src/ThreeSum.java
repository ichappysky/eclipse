import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		if (num == null || num.length < 3) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				int cur = num[i] + num[j] + num[k];
				if (cur < 0) {
					j++;
				} else if (cur > 0) {
					k--;
				} else {
					result.add(new ArrayList<Integer>(Arrays.asList(num[i],
							num[j], num[k])));
					j++;
					k--;
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(result);
	}
}