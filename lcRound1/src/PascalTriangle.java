import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (numRows <= 0) {
			return result;
		}
		ArrayList<Integer> firstLayer = new ArrayList<Integer>();
		firstLayer.add(1);
		result.add(firstLayer);
		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> curLayer = new ArrayList<Integer>();
			result.add(curLayer);
			curLayer.add(1);
			for (int j = 1; j <= i - 1; j++) {
				ArrayList<Integer> prevLayer = result.get(i - 1);
				curLayer.add(prevLayer.get(j - 1) + prevLayer.get(j));
			}
			curLayer.add(1);
		}

		return result;
	}
	
	public static void main(String[] args) {
		
		PascalTriangle t = new PascalTriangle();
		
		System.out.println(t.generate(3));
	}
}
