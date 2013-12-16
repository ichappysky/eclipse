package chapter17Moderate;

public class HelpSwapIntegersWithoutVariable {
	public static void swap(int a, int b) {

		System.out.println("a: " + Integer.toBinaryString(a));
		System.out.println("b: " + Integer.toBinaryString(b));
		a = a ^ b;

		System.out.println("after 1st\na: " + Integer.toBinaryString(a));
		System.out.println("b: " + Integer.toBinaryString(b));
		b = a ^ b;

		System.out.println("after 2\na: " + Integer.toBinaryString(a));
		System.out.println("b: " + Integer.toBinaryString(b));
		a = a ^ b;

		System.out.println("after 3\na: " + Integer.toBinaryString(a));
		System.out.println("b: " + Integer.toBinaryString(b));
	}

	public static void main(String[] args) {
		int a = 1672;
		int b = 9332;

		System.out.println("a: " + Integer.toBinaryString(a));
		System.out.println("a: " + Integer.toBinaryString(a^0));
		System.out.println("b: " + b);

		swap(a, b);
	}

}
