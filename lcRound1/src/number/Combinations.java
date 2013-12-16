package number;
import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {
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
		for (ArrayList<Integer> list : combine(n - 1, k - 1)) {
			list.add(n);
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		Combinations t = new Combinations();
		t.combine(1, 1);
	}
}
