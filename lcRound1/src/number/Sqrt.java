package number;
public class Sqrt {
	public int sqrt(int x) {
		if (x <= 1) {
			return x;
		}

		int low = 0;
		int high = x;

		while (low < high-1) {
			int mid = low + (high - low) / 2;
			int divideResult = x / mid;
			if (mid == divideResult) {
				return mid;
			} else if (mid > divideResult) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

	public static void main(String[] a) {
		Sqrt t = new Sqrt();
		System.out.print(t.sqrt(1));
	}
}