package chapter18hard;

public class HelpAddWithoutPlusOperation {
	public static int add(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sumNoCarry = a ^ b;
		int carry = (a & b) << 1;
		return add(sumNoCarry, carry);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int a = randomInt(100);
			int b = randomInt(100);
			int sum = add(a, b);
			System.out.println(a + " + " + b + " = " + sum);
		}
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

}
