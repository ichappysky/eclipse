package chapter18hard;

import common.AssortedMethods;

public class HelpPickNumbers {
	public static int[] pick(int[] nums, int m) {
		if (nums == null || nums.length == 0 || m <= 0) {
			return null;
		}
		int[] result = new int[m];
		int[] copy = nums.clone();
		for (int i = 0; i < m; i++) {
			int index = (int) (Math.random() * (copy.length - i)) + i;

			result[i] = copy[index];
			copy[index] = copy[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] cards = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(AssortedMethods.arrayToString(cards));
		int[] set = pick(cards, 4);
		System.out.println(AssortedMethods.arrayToString(set));
	}

}
