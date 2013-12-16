package number;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			return null;
		}
		int[] muls = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				muls[i + j + 1] += (num1.charAt(i) - '0')
						* (num2.charAt(j) - '0');
			}
		}
		int carry = 0;
		for (int i = muls.length - 1; i >= 0; i--) {
			int total = muls[i] + carry;
			muls[i] = total % 10;
			carry = total / 10;
		}
		String result = "";
		for (int i = 0; i < muls.length; i++) {
			if (muls[i] == 0 && result.equals("")) {
				continue;
			}
			result += muls[i];
		}

		if (result.equals("")) {
			return "0";
		}

		return result;
	}

	public static void main(String[] a) {
		MultiplyStrings t = new MultiplyStrings();
		t.multiply("123", "456");
	}
}