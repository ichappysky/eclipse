package oct16;

import java.util.Arrays;

public class HelpNextPermutation {
	public void nextPermutation(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (num == null || num.length == 0) {
			return;
		}

		int i = num.length - 1;
		for (; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				break;
			}
		}
		if (i == 0) {
			for (int s = 0, e = num.length - 1; s < e; s++, e--) {
				swap(num, s, e);
			}
			return;
		}
		i--;
		for (int j = i + 1; j <= num.length; j++) {
			if (j < num.length && num[j] > num[i]) {
				continue;
			}
			swap(num, i, j - 1);
			for (int s = i + 1, e = num.length - 1; s < e; s++, e--) {
				swap(num, s, e);
			}
			return;
		}

	}

	private void swap(int[] num, int i, int j) {
		int tmp = num[j];
		num[j] = num[i];
		num[i] = tmp;
	}

	public static void main(String[] x) {
		HelpNextPermutation t = new HelpNextPermutation();
		int[] a =new int[] { 1, 1, 5, 1 };
		t.nextPermutation(a);
		System.out.print(Arrays.toString(a));
	}
}
