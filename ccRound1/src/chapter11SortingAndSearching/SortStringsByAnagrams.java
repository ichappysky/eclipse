package chapter11SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortStringsByAnagrams {
	public static List<String> sortStringsByAnagrams(List<String> strings) {
		List<String> result = new ArrayList<String>();

		if (strings == null || strings.isEmpty()) {
			return result;
		}

		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String s : strings) {
			String key = getKey(s);
			ArrayList<String> curList = map.get(key);
			if (curList == null) {
				curList = new ArrayList<String>();
			}
			curList.add(s);
			map.put(key, curList);
		}
		for (ArrayList<String> value : map.values()) {
			result.addAll(value);
		}

		return result;
	}

	private static String getKey(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		List<String> array = new ArrayList<String>(Arrays.asList("apple",
				"banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk",
				"eel", "lee"));

		;
		System.out.println(sortStringsByAnagrams(array));
	}
}
