package chapter09RecursionAndDP;

public class CountCoins {

	public static int makeChange2(int n) {
		int[] coins = new int[] { 25, 10, 5, 1 };
		int[][] map = new int[n + 1][4];

		return helper(n, coins, 0, map);
	}

	private static int helper(int n, int[] coins, int index, int[][] map) {
		if (map[n][index] > 0) {
			return map[n][index];
		}
		if (index >= coins.length - 1) {
			return 1;
		}

		int curCoin = coins[index];
		int ways = 0;
		for (int remain = n; remain >= 0; remain -= curCoin) {
			ways += helper(remain, coins, index + 1, map);
		}
		map[n][index] = ways;
		return ways;

	}

	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println("makeChange(" + i + ") = " + makeChange(i));
		}
	}

	public static int makeChange(int n) {
		int x = makeChange1(n);
		int y = makeChange2(n);
		if (x != y) {
			System.out.println("Error: n = " + n +" expect:" + x + " Got:" + y);
		}
		return x;
	}

	public static int makeChange(int amount, int[] denoms, int index) {
		if (index >= denoms.length - 1)
			return 1; // one denom remaining -> one way to do it
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1); // go to
																	// next
																	// denom
		}
		return ways;
	}

	public static int makeChange1(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		return makeChange(n, denoms, 0);
	}
}
