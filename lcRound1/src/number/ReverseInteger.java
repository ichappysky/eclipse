package number;

public class ReverseInteger {
	public int reverse(int x) {
		int y = x;
		if (x < 0) {
			y = Math.abs(x);
		}
		int result = 0;
		while (y > 0) {
			result = result * 10 + y % 10;
			y /= 10;
		}
		if (x < 0) {
			return 0 - result;
		}

		return result;
	}
}