package chapter11SortingAndSearching;

import common.AssortedMethods;

public class MergeSortedArrays {
	public static void mergeArrays(int[] a, int[] b, int endA, int endB) {
		if (a == null || b == null || b.length == 0) {
			return;
		}

		int curEnd = endA + endB + 1;
		while (endB >= 0 && endA >= 0) {
			if (b[endB] > a[endA]) {
				a[curEnd--] = b[endB--];
			} else {
				a[curEnd--] = a[endA--];
			}
		}
		while (endB >= 0) {
			a[curEnd--] = b[endB--];
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0 };
		int[] b = { 1, 4, 7, 6, 7, 7 };
		mergeArrays(a, b, 7, 5);
		System.out.println(AssortedMethods.arrayToString(a));
	}

}
