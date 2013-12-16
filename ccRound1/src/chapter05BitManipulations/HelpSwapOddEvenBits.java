package chapter05BitManipulations;

import common.AssortedMethods;

public class HelpSwapOddEvenBits {
	public static int swapOddEvenBits(int a) {
		return (a & 0xaaaaaaaa) >> 1 | (a & 0x55555555) << 1;
	}

	public static void main(String[] args) {
		int a = 103217;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
	}

}
