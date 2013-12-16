import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinationsOfPhoneNumber {
	private String[] letters = new String[] { "0", "1", "abc", "def", "ghi",
			"jkl", "mno", "pqrs", "tuv", "wxyz" };

	public ArrayList<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}

		return helper(digits, 0);
	}

	private ArrayList<String> helper(String digits, int index) {
		ArrayList<String> result = new ArrayList<String>();
		if (index == digits.length()) {
			result.add("");
			return result;
		}
		ArrayList<String> subResult = helper(digits, index + 1);
		String cur = letters[digits.charAt(index) - '0'];
		for (int i = 0; i < cur.length(); i++) {
			char letter = cur.charAt(i);

			for (String subString : subResult) {
				result.add(letter + subString);
			}
		}
		return result;
	}
	
	public static void main(String[] ab) {
		LetterCombinationsOfPhoneNumber a = new LetterCombinationsOfPhoneNumber();
		System.out.print(a.letterCombinations("2"));
	}
}