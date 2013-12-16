package string;

public class ZigzagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || s.length() <= nRows || nRows == 1) {
			return s;
		}

		int[][] s2 = new int[nRows][s.length()];
		// set to 1 to not conflict with 0s
		int index = 1;
		int row = 0;
		int col = 0;
		while (index <= s.length()) {
			while (row < nRows - 1 && index <= s.length()) {
				s2[row++][col] = index++;
			}
			while (row > 0 && index <= s.length()) {
				s2[row--][col++] = index++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < col; j++) {
				int cur = s2[i][j];
				if (cur > 0) {
					sb.append(s.charAt(cur - 1));
				}
			}
		}

		return sb.toString();
	}
}