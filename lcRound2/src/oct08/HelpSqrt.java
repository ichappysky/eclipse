package oct08;

public class HelpSqrt {
	public int sqrt(int x) {
		if (x < 0) {
			throw new IllegalArgumentException();
		}
		if (x <= 1) {
			return x;
		}

		int low = 0;
		int high = x;

		// compare to high-1 (vs high) to avoid infinite loop
		while (low < high - 1) {
			int mid = low + (high - low) / 2;
			int divident = x / mid;
			if (divident == mid) {
				return mid;
			} else if (divident < mid) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

	public static void main(String[] x) {
		HelpSqrt t = new HelpSqrt();
		System.out.println(t.sqrt(0.25));
	}

	/**
	 * 
	 https://code.google.com/p/elements-of-programming-interviews/source/
	 * browse/trunk/Square_root.cpp
	 */
	public double sqrt(double x) {
		double epsilon = 0.000001;
		if (x < 0) {
			throw new IllegalArgumentException();
		}
		double low = 1.0;
		double high = x;

		if (x < 1) {
			low = x;
			high = 1.0;
		}
		while (Math.abs(low - high) > epsilon) {
			double mid = low + (high - low) / 2;
			double divident = x / mid;
			if (Math.abs(divident - mid) < epsilon) {
				return mid;
			} else if (divident < mid) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

}