package chapter18hard;

public class HelpCountTwos {
	public static int count(int n) {
		if (n <= 0) {
			return 0;
		}

		int len = String.valueOf(n).length();
		int result = 0;
		for (int i = 0; i < len; i++) {
			result += helper(n, i);
		}
		return result;
	}

	private static int helper(int n, int d) {
		int base = (int) Math.pow(10, d);
		int nextBase = 10 * base;

		int roundDown = n - n % nextBase;
		int roundUp = roundDown + nextBase;
		int curDigit = (n / base) % 10;
		if (curDigit > 2) {
			return roundUp / 10;
		} else if (curDigit < 2) {
			return roundDown / 10;
		} else {
			return roundDown / 10 + n % base + 1;
		}
	}

	// =================
	public static void main(String[] args) {
		count (637);
	}

	public static int count2sR(int n) {
		/* Alternate, messier, solution */

		// Example: n = 513

		// Base case
		if (n == 0) {
			return 0;
		}

		// Split apart 513 into 5 * 100 + 13.
		// [Power = 100; First = 5; Remainder = 13]
		int power = 1;
		while (10 * power < n) {
			power *= 10;
		}
		int first = n / power;
		int remainder = n % power;

		// Counts 2s from first digit
		int nTwosFirst = 0;
		if (first > 2) {
			nTwosFirst += power;
		} else if (first == 2) {
			nTwosFirst += remainder + 1;
		}

		// Count 2s from all other digits
		int nTwosOther = first * count2sR(power - 1) + count2sR(remainder);

		return nTwosFirst + nTwosOther;
	}
}
