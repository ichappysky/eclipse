package chapter09RecursionAndDP;

import java.util.Arrays;

import common.AssortedMethods;

public class HelpMagicIndexWithDuplicates {
	public static int magicFast(int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (array[mid] == mid) {
			return mid;
		}
		int result = magicFast(array, start, Math.min(mid - 1, array[mid]));
		if (result >= 0) {
			return result;
		}
		return magicFast(array, Math.max(mid + 1, array[mid]), end);
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	/* Creates an array that is sorted */
	public static int[] getSortedArray(int size) {
		int[] array = AssortedMethods.randomArray(size, -1 * size, size);
		Arrays.sort(array);
		return array;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int size = AssortedMethods.randomIntInRange(5, 20);
			int[] array = getSortedArray(size);
			int v2 = magicFast(array);
			if (v2 == -1 && magicSlow(array) != -1) {
				int v1 = magicSlow(array);
				System.out.println("Incorrect value: index = -1, actual = "
						+ v1 + " " + i);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			} else if (v2 > -1 && array[v2] != v2) {
				System.out.println("Incorrect values: index= " + v2
						+ ", value " + array[v2]);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			}
		}
	}

	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

}
