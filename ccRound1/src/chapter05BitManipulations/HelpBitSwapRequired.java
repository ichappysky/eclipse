package chapter05BitManipulations;

import common.AssortedMethods;

public class HelpBitSwapRequired {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c &= (c - 1)) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = 23432;
		int b = 512132;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		System.out.println(AssortedMethods.toFullBinaryString(b));
		System.out.println(AssortedMethods.toFullBinaryString(a^b));
		int nbits = bitSwapRequired(a, b);
		System.out.println("Required number of bits: " + nbits );
	}
}
