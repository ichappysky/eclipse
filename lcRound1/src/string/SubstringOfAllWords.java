package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubstringOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return result;
		}
		int strLen = S.length();
		int wordNum = L.length;
		int wordLen = L[0].length();
		Map<String, Integer> wordIndexes = new HashMap<String, Integer>();

		int[] needCount = new int[wordNum];
		for (int i = 0; i < wordNum; ++i) {
			// only save the first index of the duplicates
			if (!wordIndexes.containsKey(L[i])) {
				wordIndexes.put(L[i], i);
			}
			needCount[wordIndexes.get(L[i])]++;
		}

		// go through string, 
		// store the index of matched word 
		int[] matchingIndex = new int[strLen];
		Arrays.fill(matchingIndex, -1);
		for (int i = 0; i < strLen - wordLen + 1; ++i) {
			String key = S.substring(i, i + wordLen);
			matchingIndex[i] = wordIndexes.containsKey(key) ? wordIndexes
					.get(key) : -1;
		}

		for (int offset = 0; offset < wordLen; ++offset) {
			int[] found = new int[wordNum];
			int count = 0, begin = offset;
			for (int i = offset; i < strLen - wordLen + 1; i += wordLen) {
				if (matchingIndex[i] < 0) {
					// recount
					begin = i + wordLen;
					count = 0;
					Arrays.fill(found, 0);
					continue;
				}
				int index = matchingIndex[i];
				found[index]++;
				if (found[index] <= needCount[index]) {
					count++;
				}

				if (count == wordNum) {
					result.add(begin);
				}

				// move current window
				if ((i - begin) / wordLen + 1 == wordNum) {
					index = matchingIndex[begin];
					if (found[index] <= needCount[index]) {
						count--;
					}
					found[index]--;
					begin += wordLen;
				}

			}
		}
		return result;
	}

	public static void main(String[] a) {
		SubstringOfAllWords t = new SubstringOfAllWords();
		System.out.println(t.findSubstring("barfoothefoobarman", new String[] {
				"foo", "bar" }));
	}
}