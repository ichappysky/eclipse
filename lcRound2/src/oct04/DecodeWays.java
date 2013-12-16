package oct04;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author yongz
 * 
 */
public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int f1 = 1;
		int f2 = 0;
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			result = 0;
			if (isValid(s.substring(i, i + 1))) {
				result = f1;

			}
			if (i > 0 && isValid(s.substring(i - 1, i + 1))) {
				result += f2;
			}
			if (result == 0) {
				return 0;
			}
			f2 = f1;
			f1 = result;
		}
		return result;
	}

	private boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return false;
		}
		if (s.length() == 1) {
			return true;
		}
		if (s.length() == 0 || s.length() > 2) {
			return false;
		}
		int asci = Integer.valueOf(s);
		if (asci > 26) {
			return false;
		}
		return true;
	}

	public static void main(String[] x) {
		DecodeWays t = new DecodeWays();
		t.numDecodings("10");

	}
}
