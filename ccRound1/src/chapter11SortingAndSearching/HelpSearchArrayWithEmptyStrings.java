package chapter11SortingAndSearching;

public class HelpSearchArrayWithEmptyStrings {
	public static int search(String[] array, int low, int high, String target) {
		if (array == null || array.length == 0 || target == null) {
			return -1;
		}
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;

		if (array[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (left >= low || right <= high) {
				if (left >= low && !array[left].isEmpty()) {
					mid = left;
					break;
				} else if (right <= high && !array[right].isEmpty()) {
					mid = right;
					break;
				}
				left--;
				right++;
			}

		}
		
		if (target.equals(array[mid])) {
			return mid;
		}
		if (target.compareTo(array[mid])< 0) {
			return search(array, low, mid - 1, target);
		} else {
			return search(array, mid + 1, high, target);
		}

	}

	public static void main(String[] args) {
		String[] stringList = { "apple", "", "", "banana", "", "", "",
				"carrot", "duck", "", "", "eel", "", "flower" };
		System.out.println(search(stringList, 0, stringList.length - 1, ""));

		for (String s : stringList) {
			System.out.println("<" + s + "> " + " appears at location "
					+ search(stringList, 0, stringList.length - 1, s));
		}
	}
}
