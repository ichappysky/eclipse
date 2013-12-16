package number;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return result;
		}
		
		Arrays.sort(S);

		for (int i = 0; i < (1 << S.length); i++) {
			ArrayList<Integer> oneList = new ArrayList<Integer>();
			for (int j = 0, num = i; num > 0; j++, num >>= 1) {
				if ((num & 1) == 0) {
					continue;
				}
				oneList.add(S[j]);
			}
			result.add(oneList);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] s = { 1, 2 };

		Subsets t = new Subsets();
		System.out.println(t.subsets(s));
	}
}