import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		if (n <= 1) {
			resultList.add(0);
			if (n == 1)
				resultList.add(1);
			return resultList;
		}
		
		ArrayList<Integer> prevList = grayCode(n - 1);
		int highest_bit = 1 << (n - 1);
		for (int i = prevList.size() - 1; i >= 0; i--) {
			resultList.add(prevList.get(i) + highest_bit);
		}
		prevList.addAll(resultList);
		return prevList;
	}
	
	public static void main(String[] args) {
		GrayCode t = new GrayCode();
		
		System.out.println(t.grayCode(3));
	}
}
