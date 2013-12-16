package chapter18hard;

import common.AssortedMethods;

public class MinDistanceBetweenWords {
	public static int getDistance(String[] strings, String word1, String word2) {
		if (strings == null || strings.length == 0 || word1 == null
				|| word2 == null) {
			return 0;
		}
		int lastWord1 = -1;
		int lastWord2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strings.length; i++) {
			if (word1.equals(strings[i])) {
				lastWord1 = i;
				if (lastWord2 >= 0) {
					min = Math.min(min, lastWord1 - lastWord2);
				}
			} else if (word2.equals(strings[i])) {
				lastWord2 = i;
				if (lastWord1 >= 0) {
					min = Math.min(min, lastWord2 - lastWord1);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		System.out.println(AssortedMethods.stringArrayToString(wordlist));

		String[][] pairs = { { "Lara", "the" }, { "river", "life" },
				{ "path", "their" }, { "life", "a" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			int distance = getDistance(wordlist, word1, word2);
			boolean confirm = searchConfirm(wordlist, word1, word2, distance);
			System.out.println("Distance between <" + word1 + "> and <" + word2
					+ ">: " + distance + " (" + confirm + ")");
		}
	}

	// Method to confirm other result
	public static boolean searchConfirm(String[] words, String word1,
			String word2, int distance) {
		boolean found_at_distance = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 1; j < distance; j++) {
					String loc2a = wordAtLocation(words, i - j);
					String loc2b = wordAtLocation(words, i + j);
					if (word2.equals(loc2a) || word2.equals(loc2b)) {
						return false;
					}
				}

				String loc2a = wordAtLocation(words, i - distance);
				String loc2b = wordAtLocation(words, i + distance);
				if (word2.equals(loc2a) || word2.equals(loc2b)) {
					found_at_distance = true;
				}
			}
		}
		return found_at_distance;
	}

	public static String wordAtLocation(String[] words, int loc) {
		if (loc < 0 || loc >= words.length) {
			return null;
		}
		return words[loc];
	}

	public static int shortest(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int lastPosWord1 = -1;
		int lastPosWord2 = -1;
		for (int i = 0; i < words.length; i++) {
			String currentWord = words[i];
			if (currentWord.equals(word1)) {
				lastPosWord1 = i;
				// Comment following 3 lines if word order matters
				int distance = lastPosWord1 - lastPosWord2;
				if (lastPosWord2 >= 0 && min > distance) {
					min = distance;
				}
			} else if (currentWord.equals(word2)) {
				lastPosWord2 = i;
				int distance = lastPosWord2 - lastPosWord1;
				if (lastPosWord1 >= 0 && min > distance) {
					min = distance;
				}
			}
		}
		return min;
	}
}
