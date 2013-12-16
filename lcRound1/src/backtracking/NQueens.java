package backtracking;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n <= 0) {
			return null;
		}
		int[] cols = new int[n];
		helper(n, cols, 0, result);
		return result;
	}

	private void helper(int n, int[] cols, int row, ArrayList<String[]> result) {
		if (row == n) {
			// get one solution. add it to result;
			String[] solution = new String[n];
			for (int i = 0; i < n; i++) {
				char[] tmp = new char[n];
				Arrays.fill(tmp, '.');
				tmp[cols[i]] = 'Q';
				solution[i] = new String(tmp);
			}
			result.add(solution);
		}
		for (int i = 0; i < n; i++) {
			if (isValidPos(row, i, cols)) {
				cols[row] = i;
				helper(n, cols, row + 1, result);
			}
		}
	}

	private boolean isValidPos(int row, int col, int[] cols) {
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) {
				return false;
			}
			int rowDistance = row - i;
			int colDistance = Math.abs(col - cols[i]);
			if (rowDistance == colDistance) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] a) {
		NQueens t = new NQueens();
		System.out.println(t.solveNQueens(4));
	}
}