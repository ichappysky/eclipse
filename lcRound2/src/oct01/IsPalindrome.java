package oct01;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author yongz
 * 
 */
public class IsPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;

		// another approach can be while(h<t) h++, t--
		for (int head = 0, tail = s.length() - 1; head <= tail; head++, tail--) {
			char headChar = s.charAt(head);
			char tailChar = s.charAt(tail);
			while (head <= tail && !isValidChar(headChar)) {
				head++;
				if (head > tail) {
					return true;
				}
				headChar = s.charAt(head);
			}
			while (head <= tail && !isValidChar(tailChar)) {
				tail--;
				tailChar = s.charAt(tail);
			}
			if (!equalIgnoreCase(headChar, tailChar)) {
				return false;
			}

		}
		return true;

	}

	public boolean isValidChar(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
				|| (c >= '0' && c <= '9');
	}

	public boolean equalIgnoreCase(char a, char b) {
		return a == b || a == (b + 32) || a == (b - 32);
	}
}