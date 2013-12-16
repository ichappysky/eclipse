package oct08;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * @author yongz
 * 
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int startOfNines = digits.length;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				break;
			}
			startOfNines = i;
		}

		if (startOfNines == 0) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
		int[] result = new int[digits.length];
		for (int i = 0; i < digits.length; i++) {
			if (i < startOfNines - 1) {
				result[i] = digits[i];
			} else if (i == startOfNines - 1) {
				result[i] = digits[i] + 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}

}