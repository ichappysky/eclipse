package string;

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		int curA = a.length() - 1;
		int curB = b.length() - 1;
		int carry = 0;
		String result = "";
		while (curA >= 0 || curB >= 0 || carry > 0) {
			int num = 0;
			if (curA >= 0) {
				num = a.charAt(curA) - '0';
				curA--;
			}
			if (curB >= 0) {
				num += b.charAt(curB) - '0';
				curB--;
			}
			num += carry;
			result = num % 2 + result;
			carry = num / 2;
		}

		return result;
	}
}