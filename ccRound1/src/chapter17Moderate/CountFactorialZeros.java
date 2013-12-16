package chapter17Moderate;

public class CountFactorialZeros {
	public static int count(int n) {
		if (n < 0) {
			return -1;
		}
		int result = 0;
		while (n > 0) {
			n /= 5;
			result += n;
		}
		return result;
	}
	
	//=============================================

	public static void main(String[] args) {
		for (int i = 1; i < 1222; i++) {
			System.out.println(i + "! (expected " + countFactZeros(i) + ") has " + count(i)
					+ " zeros");
		}
	}

	public static int countFactZeros(int num) {
		int count = 0;
		if (num < 0) {
			System.out.println("Factorial is not defined for negative numbers");
			return 0;
		}
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}
		return count;
	}
}
