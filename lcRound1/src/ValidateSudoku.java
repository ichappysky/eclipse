import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValidateSudoku {
	public boolean isValidSudoku(char[][] board) {
		List<HashSet<Character>> rowSets = new ArrayList<HashSet<Character>>();
		List<HashSet<Character>> colSets = new ArrayList<HashSet<Character>>();
		List<HashSet<Character>> blockSets = new ArrayList<HashSet<Character>>();
		for (int i = 0; i < 9; i++) {
			rowSets.add(new HashSet<Character>());
			colSets.add(new HashSet<Character>());
			blockSets.add(new HashSet<Character>());

		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char cur = board[i][j];
				if (cur == '.') {
					continue;
				}
				if (!rowSets.get(i).add(cur)) {
					return false;
				}
				if (!colSets.get(j).add(cur)) {
					return false;
				}
				int blockIndex = i - i % 3 + j / 3;
				if (!blockSets.get(blockIndex).add(cur)) {
					return false;
				}

			}
		}
		return true;
	}

}