package number;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1) {
			return;
		}
		int i = num.length - 1;
		for (; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				break;
			}
		}
		// reached 0 meaning didn't find smaller # ahead - the last seq of perm
		// reverse whole num
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

	private void swap(int[] num, int j, int i) {
		int tmp = num[j];
		num[j] = num[i];
		num[i] = tmp;
	}

	public static void main(String[] x) {
		NextPermutation t = new NextPermutation();
		int[] num = new int[] { 1, 3, 4 };
		t.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
}