package oct12;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle
 * 
 * @author yongz
 * 
 */
public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		int[] path = new int[n];

		ArrayList<String[]> result = new ArrayList<String[]>();
		helper(0, path, result);
		return result;
	}

	private void helper(int curRow, int[] path, ArrayList<String[]> result) {
		if (curRow > path.length - 1) {
			return;
		}
		int n = path.length;
		for (int i = 0; i < n; i++) {
			if (isValid(i, curRow, path)) {
				path[curRow] = i;
				if (curRow == n - 1) {
					addOneResult(path, result);
				} else {
					helper(curRow + 1, path, result);
				}
			}
		}
	}

	private boolean isValid(int curPos, int curRow, int[] path) {
		for (int oneRow = 0; oneRow < curRow; oneRow++) {
			int onePos = path[oneRow];
			if (onePos == curPos) {
				return false;
			}
			if (Math.abs(curPos - onePos) == (curRow - oneRow)) {
				return false;
			}
		}
		return true;
	}

	private void addOneResult(int[] path, ArrayList<String[]> result) {
		int n = path.length;
		String[] solution = new String[n];
		for (int i = 0; i < n; i++) {
			char[] tmp = new char[n];
			Arrays.fill(tmp, '.');
			tmp[path[i]] = 'Q';
			solution[i] = String.valueOf(tmp);
		}
		result.add(solution);
	}

}