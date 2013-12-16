package string;
public class DistinctSubSequences {
	public int numDistinct(String S, String T) {
		int[] occurence = new int[T.length() + 1];

		occurence[0] = 1;
		// f(i, j) = f(i - 1, j) + (S[i] == T[j])? f(i - 1, j - 1) : 0
		// ith iteration relies only on i-1 th iteration, and j relies on j-1
		// so we can use one dim array and do backwards for j to 're-use' the
		// (i-1, j);
		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length() - 1; j >= 0; j--)
				if (S.charAt(i) == T.charAt(j)) {
					// occurrence[j+1] represents f(i, j)
					// having occurrence[0] to avoid boundary check
					occurence[j + 1] += occurence[j];
				}
		}
		return occurence[T.length()];
	}

	public static void main(String[] args) {
		DistinctSubSequences t = new DistinctSubSequences();

		System.out.println(t.numDistinct("rabbbitabc", "rabbit"));
	}
}
