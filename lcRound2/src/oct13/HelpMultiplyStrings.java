package oct13;

public class HelpMultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			return null;
		}

		int[] products = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				products[i + j + 1] += (num1.charAt(i) - '0')
						* (num2.charAt(j) - '0');
			}
		}

		int carry = 0;
		for (int i = products.length - 1; i >= 0; i--) {
			int total = carry + products[i];
			products[i] = total % 10;
			carry = total / 10;
		}

		String result = "";
		for (int i = 0; i < products.length; i++) {
			if (result.isEmpty() && products[i] == 0) {
				continue;
			}
			result += String.valueOf(products[i]);
		}
		return result.isEmpty() ? "0" : result;

	}
}