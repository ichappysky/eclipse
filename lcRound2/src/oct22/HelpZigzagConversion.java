package oct22;

public class HelpZigzagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || s.length() <= nRows || nRows == 1) {
			return s;
		}

		char[][] chars = new char[nRows][s.length()];

		int row = 0;
		int col = 0;
		int index = 0;
		while (index < s.length()) {
			while (index < s.length() && row < nRows-1) {
				chars[row++][col] = s.charAt(index++);
			}
			while (index < s.length() && row > 0) {
				chars[row--][col++] = s.charAt(index++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j <= col; j++) {
				if (chars[i][j] > 0) {
					sb.append(chars[i][j]);
				}
			}
		}

		return sb.toString();
	}
	
	public static void main(String[]x) {
		HelpZigzagConversion t = new HelpZigzagConversion();
		System.out.print(t.convert("ABC", 2));
	}
}