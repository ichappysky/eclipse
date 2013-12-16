package oct07;

public class ClimbStairs {
	public int climbStairs(int n) {
		int[] counts = new int[n + 1];
		counts[0] = 1;
		counts[1] = 1;
		return helper(n, counts);
	}

	private int helper(int n, int[] counts) {

		if (counts[n] > 0) {
			return counts[n];
		}

		int result = helper(n - 1, counts) + helper(n - 2, counts);
		counts[n] = result;

		return result;
	}

	public int climbIterative(int n) {
		if (n <= 1) {
			return 1;
		}
		int f1 = 1;
		int f2 = 1;

		int result = 1;
		for (int i = 2; i <= n; i++) {
			result = f1 + f2;
			f1 = f2;
			f2 = result;
		}

		return result;
	}
	
	public static void main (String[] x) {
		ClimbStairs t = new ClimbStairs();
		int n =0;
		System.out.println (t.climbStairs(n));
		System.out.println (t.climbIterative(n));
		
		
	}
}