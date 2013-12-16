import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}

		Map<Integer, Integer> numToIndexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (numToIndexMap.containsKey(target - numbers[i])) {
				return new int[] { numToIndexMap.get(target - numbers[i]),
						i + 1 };
			}
			numToIndexMap.put(numbers[i], i + 1);
		}

		return null;
	}
}