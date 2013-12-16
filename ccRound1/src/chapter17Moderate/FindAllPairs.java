package chapter17Moderate;

import java.util.Arrays;

public class FindAllPairs {
	public static void printPairs(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return;
		}
		Arrays.sort(nums);

		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int sum = nums[low] + nums[high];
			if (sum == target) {
				System.out.println(nums[low] + ", " + nums[high]);
				low++;
				high--;
			} else if (sum < target) {
				low++;
			} else {
				high--;
			}
		}
	}

	// ==================
	public static void main(String[] args) {
		int[] test = { 9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0 };
		printPairs(test, 12);
		System.out.println("========");
		printPairSums(test, 12);
	}

	public static void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				++first;
				--last;
			} else {
				if (s < sum) {
					++first;
				} else {
					--last;
				}
			}
		}
	}

}
