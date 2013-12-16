package chapter09RecursionAndDP;

import java.util.Arrays;

import common.AssortedMethods;

public class MagicIndex {
	public static int magicFast(int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (array[mid] == mid) {
			return mid;
		}
		if (array[mid] < mid) {
			return magicFast(array, mid + 1, end);
		} else {
			return magicFast(array, start, mid - 1);
		}
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int size = AssortedMethods.randomIntInRange(5, 20);
			int[] array = getDistinctSortedArray(size);
			System.out.println(Arrays.toString(array));
			int v2 = magicFast(array);
			System.out.println(v2);
		}
	}

	/* Creates an array that is distinct and sorted */
	public static int[] getDistinctSortedArray(int size) {
		int[] array = AssortedMethods.randomArray(size, -1 * size, size);
		Arrays.sort(array);
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1]) {
				array[i]++;
			} else if (array[i] < array[i - 1]) {
				array[i] = array[i - 1] + 1;
			}
		}
		return array;
	}
}
