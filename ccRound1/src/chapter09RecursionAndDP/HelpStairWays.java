package chapter09RecursionAndDP;

import java.util.HashMap;
import java.util.Map;

public class HelpStairWays {
	public static int countWaysIterative(int n) {
		if (n < 0) {
			return 0;
		}
		int first = 0;
		int second = 0;
		int third = 1;
		for (int i = 1; i<=n;i++) {
			int result = first + second + third;
			first = second;
			second = third;
			third = result;
		}
		
		return third;

	}

	public static int countWaysRecursive(int n) {

		Map<Integer, Integer> nToWays = new HashMap<Integer, Integer>();
		return helper(n, nToWays);

	}

	private static int helper(int n, Map<Integer, Integer> map) {
		if (n < 0) {
			return 0;
		}
		// helped with starting condition
		if (n == 0) {
			return 1;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}

		int result = helper(n - 1, map) + helper(n - 2, map)
				+ helper(n - 3, map);
		map.put(n, result);
		return result;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {

			int c2 = countWaysRecursive(i);
			System.out.println(i + ": " + c2);
			System.out.println(i + ": " + countWaysIterative(i));
		}
	}

}
