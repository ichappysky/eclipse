package oct21;

public class ReverseInteger {
	public int reverse(int x) {
		int y = Math.abs(x);
		int result = 0;
		while (y > 0) {
			result = 10 * result + y % 10;
			y /= 10;
		}

		return x > 0 ? result : -result;

	}

}
