package oct13;

public class HelpWildcardMatching {

	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		int i = 0;
		int j = 0;
		int star = -1;
		int lastMatchedPosInS = 0;
		while (i < sLen) {
			// consecutive stars
			while (j < pLen && p.charAt(j) == '*') { 
				star = j++;
				lastMatchedPosInS = i;
			}

			if (j == pLen || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?')) {
				// no star to wild match
				if (star < 0) {
					return false;
				} else {
					// move j back and try next i
					j = star + 1;
					i = ++lastMatchedPosInS;
				}
			} else {
				i++;
				j++;
			}
		}
		while (j < pLen && p.charAt(j) == '*') {
			j++;
		}

		return j == pLen;
	}

}
