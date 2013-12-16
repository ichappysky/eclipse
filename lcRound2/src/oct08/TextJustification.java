package oct08;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, words: ["This", "is", "an", "example", "of", "text",
 * "justification."] L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [ "This    is    an", "example  of text", "justification.  " ]
 * 
 * @author yongz
 * 
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return result;
		}

		int start = 0;
		int totalLen = 0;
		for (int i = 0; i < words.length; i++) {
			String curWord = words[i];
			if (totalLen == 0) {
				totalLen = curWord.length();
				continue;
			}

			if (totalLen + curWord.length() + 1 > L) {
				result.add(composeString(words, start, i - 1, L));
				totalLen = curWord.length();
				start = i;
			} else {
				totalLen += curWord.length() + 1;
			}
		}

		String lastLine = words[start];
		for (int i = start + 1; i < words.length; i++) {
			lastLine += " " + words[i];
		}

		result.add(paddingEnd(lastLine, L));
		return result;

	}

	private String composeString(String[] words, int start, int end, int L) {
		int count = end - start;
		if (count == 0) {
			return paddingEnd(words[start], L);
		}
		int len = 0;
		for (int i = start; i <= end; i++) {
			len += words[i].length();
		}
		int averageSpaces = (L - len) / count;
		char[] tmp = new char[averageSpaces];
		Arrays.fill(tmp, ' ');
		String spaces = String.valueOf(tmp);
		int extraSpaces = (L - len) % count;
		String result = words[start];
		for (int i = start + 1; i <= end; i++) {
			if (i <= start + extraSpaces) {
				result += " ";
			}
			result += spaces + words[i];
		}
		return result;
	}

	private String paddingEnd(String s, int L) {
		int count = L - s.length();
		if (count > 0) {
			char[] tmp = new char[count];
			Arrays.fill(tmp, ' ');
			s += String.valueOf(tmp);
		}

		return s;
	}
}