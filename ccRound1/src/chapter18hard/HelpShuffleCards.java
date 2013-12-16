package chapter18hard;

import common.AssortedMethods;

public class HelpShuffleCards {
	public static void shuffle(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			int index = (int) (Math.random() * (i + 1));
			int tmp = nums[i];
			nums[i] = nums[index];
			nums[index] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] cards = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(AssortedMethods.arrayToString(cards));
		shuffle(cards);
		System.out.println(AssortedMethods.arrayToString(cards));
	}

}
