package oct01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @author yongz
 * 
 */
public class HelperMinPathInTriangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Map<String, Integer> map = new HashMap<String, Integer>();
		return helper(triangle, 0, 0, map);
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return result;
		}
		result.add(new ArrayList<Integer>(Arrays.asList(1)));
		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> curList = new ArrayList<Integer>();
			ArrayList<Integer> prev = result.get(i - 1);
			curList.add(1);
			for (int j = 0; j < prev.size() - 1; j++) {
				curList.add(prev.get(j) + prev.get(j + 1));
			}
			curList.add(1);
			result.add(curList);

		}

		return result;
	}

	private int helper(ArrayList<ArrayList<Integer>> triangle, int i, int j,
			Map<String, Integer> map) {
		if (i >= triangle.size()) {
			return 0;
		}
		String key = i + ":" + j;
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int cur = triangle.get(i).get(j);

		int result = Math.min(helper(triangle, i + 1, j, map),
				helper(triangle, i + 1, j + 1, map))
				+ cur;
		map.put(key, result);

		return result;
	}

	public int minimumTotalIterative(ArrayList<ArrayList<Integer>> triangle) {
		int size = triangle.size();

		int[] min = new int[size];
		for (int j = 0; j < size; j++) {
			min[j] = triangle.get(size - 1).get(j);
		}
		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j + 1]);
			}
		}

		return min[0];
	}
}