package oct03;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author yongz
 * 
 */
public class UniqueBST {
	public int numTrees(int n) {
		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;
		return helper(n, num);
	}

	private int helper(int n, int[] num) {
		if (num[n] > 0) {
			return num[n];
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += helper(i, num) * helper(n - 1 - i, num);
		}
		num[n] = result;
		return result;
	}
}