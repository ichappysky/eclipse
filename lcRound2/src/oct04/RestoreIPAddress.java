package oct04;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author yongz
 * 
 */
public class RestoreIPAddress {
	public ArrayList<String> restoreIpAddresses(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0) {
			return new ArrayList<String>();
		}
		return helper(s, 0, 1);
	}

	private ArrayList<String> helper(String s, int startIndex, int segIndex) {
		ArrayList<String> result = new ArrayList<String>();
		if (startIndex >= s.length()) {
			return result;
		}
		if (segIndex == 4) {
			String cur = s.substring(startIndex);
			if (isValid(cur)) {
				result.add(cur);
			}
			return result;
		}
		for (int i = startIndex + 1; i < Math.min(s.length(), startIndex + 4); i++) {
			String cur = s.substring(startIndex, i);
			if (isValid(cur)) {
				ArrayList<String> restSegs = helper(s, i, segIndex + 1);
				for (String rest : restSegs) {
					result.add(cur + "." + rest);
				}
			}
		}
		return result;
	}

	private boolean isValid(String s) {
		if (s.length() < 1 || s.length() > 3) {
			return false;
		}
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		if (s.length() == 3 && (s.charAt(0) != '1' && s.charAt(0) != '2')) {
			return false;
		}
		return Integer.valueOf(s) < 256;
	}

	public static void main(String[] x) {
		RestoreIPAddress t = new RestoreIPAddress();
		// t.restoreIpAddresses("010010");
		System.out.println(t.isValid("100"));
	}

}