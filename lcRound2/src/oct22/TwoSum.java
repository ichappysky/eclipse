package oct22;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int otherHalf = target - numbers[i];
			if (map.containsKey(otherHalf)) {
				return new int[] { map.get(otherHalf), i + 1 };
			}
			map.put(numbers[i], i + 1);
		}
		return null;

	}
}
