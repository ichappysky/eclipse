package chapter17Moderate;

public class HelpGetMaxWithoutIfElse {
	public static int max(int a, int b) {
		int signA = sign(a);
		int signB = sign(b);
		int c = a - b;
		int signAMinusB = sign(c);
		int differentSign = signA ^ signB;
		int useA = differentSign * signA + flip(differentSign) * signAMinusB;
		int useB = flip(useA);
		return a * useA + b * useB;
	}

	private static int sign(int a) {
		int sign = ((a >> 31) & 1);
		return flip(sign);
	}

	private static int flip(int a) {
		return a ^ 1;
	}

	// ============
	public static void main(String[] args) {
		int a = 26;
		int b = -15;

		System.out.println("max(" + a + ", " + b + ") = " + max(a, b));

		a = -15;
		b = Integer.MAX_VALUE;
		System.out.println("max(" + a + ", " + b + ") = " + max(a, b));
	}

}
