package oct17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author yongz
 * 
 */
public class HelpSubstringWithConcatenationOfAllWords {

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return result;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		int wordNum = L.length;
		int[] need = new int[wordNum];
		// duplicates are represented by first occurrence.
		for (int i = 0; i < wordNum; i++) {
			if (!map.containsKey(L[i])) {
				map.put(L[i], i);
			}
			need[map.get(L[i])]++;
		}
		int wordLen = L[0].length();
		// key: starting index of one word in S. value: the index of first
		// occurrence
		// of one word.
		Map<Integer, Integer> sIndexToLIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < S.length() - wordLen + 1; i++) {
			String sub = S.substring(i, i + wordLen);
			if (map.containsKey(sub)) {
				sIndexToLIndex.put(i, map.get(sub));
			}
		}

		for (int offset = 0; offset < wordLen; offset++) {
			int begin = offset;
			int foundCount = 0;
			int[] found = new int[wordNum];
			for (int i = offset; i < S.length() - wordLen + 1; i += wordLen) {
				if (!sIndexToLIndex.containsKey(i)) {
					begin = i + wordLen;
					found = new int[wordNum];
					foundCount = 0;
					continue;
				}

				int wordIndex = sIndexToLIndex.get(i);
				found[wordIndex]++;
				if (found[wordIndex] <= need[wordIndex]) {
					foundCount++;
				}
				if (foundCount == wordNum) {
					result.add(begin);
				}

				// move window
				if ((i - begin) / wordLen + 1 == wordNum) {
					int beginWordIndex = sIndexToLIndex.get(begin);
					if (found[beginWordIndex] <= need[beginWordIndex]) {
						foundCount--;
					}
					found[beginWordIndex]--;
					begin += wordLen;

				}

			}
		}

		return result;

	}

	public static void main(String[] a) {
		HelpSubstringWithConcatenationOfAllWords t = new HelpSubstringWithConcatenationOfAllWords();
		System.out.println(t.findSubstring("ababba", new String[] { "ab",
				"ba" }));
	}
}