package oct10;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author yongz
 * 
 */
public class HelpPermutationSequence {
	public String getPermutation(int n, int k) {
		List<String> str = new ArrayList<String>();
		int[] factorial = new int[n + 1];
		factorial[0] = 1;
		for (int i = 1; i <= n; ++i) {
			str.add(String.valueOf((char) (i + '0')));
			factorial[i] = factorial[i - 1] * i;
		}
		String result = "";
		--k; // convert to 0-based index
		for (int i = n - 1; i >= 0; --i) {
			int quotient = k / factorial[i];
			result += str.get(quotient);
			str.remove(quotient);
			k %= factorial[i];
		}
		return result;
	}

	public static void main(String[] x) {
		HelpPermutationSequence t = new HelpPermutationSequence();
		t.getPermutation(3, 4);
	}
}