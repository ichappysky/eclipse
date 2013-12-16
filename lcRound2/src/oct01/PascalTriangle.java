package oct01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * @author yongz
 *
 */
public class PascalTriangle {
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

}
