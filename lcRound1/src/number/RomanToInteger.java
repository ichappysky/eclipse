package number;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		Map<String, Integer> stringToNumber = new HashMap<String, Integer>();
		stringToNumber.put("M", 1000);
		stringToNumber.put("CM", 900);
		stringToNumber.put("D", 500);
		stringToNumber.put("CD", 400);
		stringToNumber.put("C", 100);
		stringToNumber.put("XC", 90);
		stringToNumber.put("L", 50);
		stringToNumber.put("XL", 40);
		stringToNumber.put("X", 10);
		stringToNumber.put("IX", 9);
		stringToNumber.put("V", 5);
		stringToNumber.put("IV", 4);
		stringToNumber.put("I", 1);

		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1
					&& stringToNumber.containsKey(s.substring(i, i + 2))) {

				result += stringToNumber.get(s.substring(i, i + 2));
				i++;
			} else {
				result += stringToNumber.get(s.substring(i, i + 1));
			}

		}

		return result;
	}
}
