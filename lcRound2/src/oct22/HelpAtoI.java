package oct22;

public class HelpAtoI {
	public int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int i = 0;
		for (; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				break;
			}
		}
		if (i == str.length()) {
			return 0;
		}
		char cur = str.charAt(i);
		int sign = 1;
		if (cur == '-') {
			sign = -1;
			i++;
		} else if (cur == '+') {
			i++;
		} else if (cur < '0' || cur > '9') {
			return 0;
		}
		int result = 0;
		for (; i < str.length(); i++) {
			cur = str.charAt(i);
			if (cur < '0' || cur > '9') {
				return result * sign;
			}
			int curVal = cur - '0';
			if (sign == 1) {
				if ((Integer.MAX_VALUE - curVal) / 10 < result) {
					return Integer.MAX_VALUE;
				} else {
					result = result * 10 + curVal;
				}
			} else {
				if (Math.abs((Integer.MIN_VALUE + curVal) / 10) < result) {
					return Integer.MIN_VALUE;
				} else {
					result = result * 10 + curVal;
				}
			}
		}

		return result * sign;

	}
	
	public static void main(String[] x) {
		HelpAtoI t = new HelpAtoI();
		
		System.out.print(t.atoi(" -0012a42"));
	}
}
