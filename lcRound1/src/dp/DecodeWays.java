package dp;
public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		// initialize f(i-2), f(i-1)
		int f_i_2 = 1;
		int f_i_1 = 1;
		int f_i = 1;
		for (int i = 1; i < s.length(); i++) {
			// handle 0;
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
					f_i = f_i_2;
					continue;
				} else {
					return 0;
				}
			}
			int num = Integer.valueOf(s.substring(i - 1, i + 1));
			if (num > 26 || num < 10) {
				f_i = f_i_1;
			} else {
				f_i = f_i_1 + f_i_2;

			}
			f_i_2 = f_i_1;
			f_i_1 = f_i;
		}

		return f_i;
	}

	public static void main(String[] args) {
		DecodeWays t = new DecodeWays();

		System.out.println(t.numDecodings("10"));
	}
}
