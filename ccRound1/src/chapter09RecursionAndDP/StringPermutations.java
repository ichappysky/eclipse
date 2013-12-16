package chapter09RecursionAndDP;

import java.util.ArrayList;

public class StringPermutations {
	private static ArrayList<String> getPerms(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null) {
			return result;
		}
		if (s.isEmpty()) {
			result.add("");
			return result;
		}
		return helper(s, s.length() - 1);
	}

	private static ArrayList<String> helper(String s, int index) {
		ArrayList<String> result = new ArrayList<String>();
		if (index == 0) {
			result.add(String.valueOf(s.charAt(index)));
			return result;
		}

		char cur = s.charAt(index);
		for (String sub : helper(s, index - 1)) {
			for (int i = 0; i <= sub.length(); i++) {
				result.add(insert(sub, cur, i));
			}
		}
		return result;
	}

	private static String insert(String s, char c, int index) {
		return s.substring(0, index) + c + s.substring(index, s.length());
	}

	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
		
		String s = "abcd";
		System.out.println(s.substring(3, 5));
	}

}
