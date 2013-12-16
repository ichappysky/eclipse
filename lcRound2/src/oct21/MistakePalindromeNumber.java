package oct21;


public class MistakePalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int divisor = 1;
		// mistake: used "divisor*10<=x"  which may overflow
		while (x/10>=divisor) {
			divisor *= 10;
		}

		while (x > 0) {
			int left = x / divisor;
			int right = x % 10;
			if (left != right) {
				return false;
			}
			x = x % divisor / 10;
			divisor /= 100;

		}

		return true;
	}

	public static void main(String[] x) {
		MistakePalindromeNumber t = new MistakePalindromeNumber();
		System.out.print(t.isPalindrome(1874994781));
	}
}