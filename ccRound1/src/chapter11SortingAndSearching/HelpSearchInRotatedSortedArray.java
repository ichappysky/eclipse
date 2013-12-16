package chapter11SortingAndSearching;

public class HelpSearchInRotatedSortedArray {
	public static int search(int[] array, int low, int high, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (array[mid] == target) {
			return mid;
		}
		if (array[low] == array[mid] && array[mid] == array[high]) {
			int result = search(array, low, mid - 1, target);
			if (result != -1) {
				return result;
			}
			return search(array, mid + 1, high, target);
		}
		if (array[low] <= array[mid]) {
			if (array[low] <= target && target < array[mid]) {
				return search(array, low, mid - 1, target);
			} else {
				return search(array, mid + 1, high, target);
			}
		} else {
			if (array[mid] < target && target <= array[high]) {
				return search(array, mid + 1, high, target);
			} else {
				return search(array, low, mid - 1, target);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {5,1,3 };

		System.out.println(search(a, 0, a.length - 1, 2));
		System.out.println(search(a, 0, a.length - 1, 3));
		System.out.println(search(a, 0, a.length - 1, 4));
		System.out.println(search(a, 0, a.length - 1, 1));
		System.out.println(search(a, 0, a.length - 1, 8));
	}

}
