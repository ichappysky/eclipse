package chapter17Moderate;

public class CountColorHits {
	public static Counts count(String fact, String guess) {
		Counts result = new Counts();
		int[] freq = new int[4];
		for (int i = 0; i <= fact.length(); i++) {
			if (fact.charAt(i) == guess.charAt(i)) {
				result.hitsCount++;
			} else {
				freq[code(fact.charAt(i))]++;
			}
		}

		for (int i = 0; i <= guess.length(); i++) {
			char curChar = guess.charAt(i);
			if (fact.charAt(i) != curChar && freq[code(curChar)] > 0) {
				result.pseudohitsCount++;
				freq[code(curChar)]--;
			}
		}
		return result;
	}

	private static int code(char c) {
		switch (c) {
		case 'R':
			return 0;
		case 'G':
			return 1;
		case 'Y':
			return 2;
		case 'B':
			return 3;
		}
		return -1;
	}

}

class Counts {
	public int hitsCount = 0;
	public int pseudohitsCount = 0;
}
