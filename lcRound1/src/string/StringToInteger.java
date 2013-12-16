package string;

public class StringToInteger {
	public int atoi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				break;
			}
		}
		if (i == s.length()) {
			return 0;
		}
		// determine sign
		int sign = 1;
		char cur = s.charAt(i);
		if (cur == '-') {
			sign = -1;
			i++;
		} else if (cur == '+') {
			i++;
		} else if (cur < '0' || cur > '9') {
			return 0;
		}

		int result = 0;
		for (int j = i; j < s.length(); j++) {
			char tmp = s.charAt(j);
			if (tmp < '0' || tmp > '9') {
				return result * sign;
			}
			int curVal = tmp - '0';
			if (sign == 1) {
				if ((Integer.MAX_VALUE - curVal) / 10 < result) {
					return Integer.MAX_VALUE;
				} else {
					result = result * 10 + curVal;
				}
			} else {
				if ((Integer.MIN_VALUE + curVal) / 10 > result * -1) {
					return Integer.MIN_VALUE;
				} else {
					result = result * 10 + curVal;
				}
			}
		}
		return result * sign;
	}

	public static void main(String[] a) {
		StringToInteger t = new StringToInteger();
		System.out.println(t.atoi("-2147483647"));
	}
}