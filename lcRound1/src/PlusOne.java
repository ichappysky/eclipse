public class PlusOne {
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			int[] one = new int[1];
			one[0] = 1;
			return one;
		}

		boolean hasCarryOver = false;
		int lastIndex = digits.length - 1;
		if (digits[lastIndex] == 9) {
			digits[lastIndex] = 0;
			hasCarryOver = true;
		} else {
			digits[lastIndex] =  digits[lastIndex] +1;
		}
		for (int i = digits.length - 2; i >= 0; i--) {
			if (hasCarryOver) {
				if (digits[i] == 9) {
					digits[i] = 0;
					hasCarryOver = true;
				} else {
					digits[i] = digits[i] + 1;
					hasCarryOver = false;
				}
			}
		}

		if (hasCarryOver) {
			int[] newResult = new int[digits.length + 1];
			newResult[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				newResult[i + 1] = digits[i];
			}
			return newResult;
		} else {
			return digits;
		}
	}

}
