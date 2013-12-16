package string;

import java.util.ArrayList;
import java.util.Arrays;

public class TextJustification {

	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return result;
		}
		int totalLen = 0;
		int startIndex = 0;
		for (int i = 0; i < words.length; i++) {
			if (totalLen == 0) {
				totalLen = words[i].length();
				startIndex = i;
			} else {
				totalLen += words[i].length() + 1; // space associated;
			}
			if (totalLen > L) {
				result.add(composeOneLine(words, startIndex, i - 1, totalLen
						- words[i].length() - 1, false, L));
				i--;
				totalLen = 0;
			} else if (i == words.length - 1) {
				result.add(composeOneLine(words, startIndex, i, totalLen, true,
						L));
			}
		}

		return result;
	}

	private String composeOneLine(String[] words, int start, int end,
			int totalLen, boolean isLastLine, int L) {
		// single word or last line
		String result = words[start];
		if (end == start || isLastLine) {
			for (int i = start + 1; i <= end; i++) {
				result += " " + words[i];
			}
			return result + getSpaces(L - totalLen);
		}

		int paddingNum = L - totalLen;
		int wordsCount = end - start + 1;
		int avg = paddingNum / wordsCount + 1;
		int rest = paddingNum % wordsCount;
		for (int i = start + 1; i <= end; i++) {
			if (i <= start + rest) {
				result += getSpaces(avg + 1) + words[i];
			} else {
				result += getSpaces(avg) + words[i];
			}
		}

		return result;
	}

	private String getSpaces(int paddingNum) {
		char[] spaces = new char[paddingNum];
		Arrays.fill(spaces, ' ');
		return new String(spaces);
	}
}