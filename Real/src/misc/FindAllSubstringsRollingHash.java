package misc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a string P and a string S, find out all the occurrences of P within S
 * 
 * @author yongz
 * 
 */
public class FindAllSubstringsRollingHash {

	public List<Integer> rolling(String s, String p) {
		final List<Integer> result = new ArrayList<Integer>();
		int pLen = p.length();
		int aPowerN = 1;
		int rollingHash = 0;
		int a = 10;
		int MOD = BigInteger.probablePrime(31, new Random()).intValue();
		// get hash of P
		int hashP = 0;
		for (int i = 0; i < pLen; i++) {
			hashP = (hashP * a + p.charAt(i)) % MOD;
			rollingHash = (rollingHash * a + s.charAt(i)) % MOD;
			aPowerN = (aPowerN * a) % MOD;
		}
		if (rollingHash == hashP) {
			result.add(0);
		}
		for (int i = 1; i < s.length() - pLen + 1; i++) {
			rollingHash = (rollingHash * a + s.charAt(i + pLen - 1) - aPowerN
					* s.charAt(i - 1))
					% MOD;
			if (rollingHash == hashP) {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] x) {

		FindAllSubstringsRollingHash t = new FindAllSubstringsRollingHash();
		System.out.println(t.rolling("abaabcdabcdab", "ab"));

	}
}
