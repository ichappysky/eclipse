package oct01;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.For example,
 * given k = 3, Return [1,3,3,1].
 * 
 * @author yongz
 * 
 */
public class PascalTriangle2 {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}
		result.add(1);

		for (int i = 1; i < rowIndex + 1; i++) {
			int prev = 1;
			for (int j = 1; j < i; j++) {
				int total = prev + result.get(j);
				prev = result.get(j);
				result.set(j, total);
			}
			result.add(1);
		}

		return result;
	}

	public static void main(String[] x) {
		PascalTriangle2 t = new PascalTriangle2();
		System.out.println(t.getRow(5));
	}
}
