package oct09;

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		int curA = a.length() - 1;
		int curB = b.length() - 1;
		int carry = 0;
		String result = "";
		while (curA >= 0 || curB >= 0 || carry > 0) {
			int sum = 0;
			if (curA >= 0) {
				sum += a.charAt(curA) - '0';
				curA--;
			}
			if (curB >= 0) {
				sum += b.charAt(curB) - '0';
				curB--;
			}
			sum += carry;
			result = String.valueOf(sum % 2) +result;
			carry = sum / 2;
		}
		return result;
	}
}