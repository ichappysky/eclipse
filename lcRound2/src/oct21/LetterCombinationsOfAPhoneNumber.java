package oct21;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinationsOfAPhoneNumber {

	public ArrayList<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}

		ArrayList<String> result = new ArrayList<String>();
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int cur = digits.charAt(i) - '0';

			char[] mappedChars = getMappedChars(cur);
			ArrayList<String> tmp = new ArrayList<String>();
			for (char c : mappedChars) {
				for (String str : result) {
					tmp.add(str + c);
				}
			}
			result = tmp;
		}
		return result;
	}

	private char[] getMappedChars(int cur) {
		switch (cur) {
		case 0:
			return new char[] { '0' };
		case 1:
			return new char[] { '1' };
		case 2:
			return new char[] { 'a', 'b', 'c' };
		case 3:
			return new char[] { 'd', 'e', 'f' };
		case 4:
			return new char[] { 'g', 'h', 'i' };
		case 5:
			return new char[] { 'j', 'k', 'l' };
		case 6:
			return new char[] { 'm', 'n', 'o' };
		case 7:
			return new char[] { 'p', 'q', 'r', 's' };
		case 8:
			return new char[] { 't', 'u', 'v' };
		case 9:
			return new char[] { 'w', 'x', 'y', 'z' };
		}
		return null;
	}
}
