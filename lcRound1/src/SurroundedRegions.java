public class SurroundedRegions {
	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length==0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		// start from 4 edges
		for (int i = 0; i < m; i++) {
			Dfs(i, 0, board);
			Dfs(i, n - 1, board);
		}

		for (int i = 0; i < n; i++) {
			Dfs(0, i, board);
			Dfs(m - 1, i, board);
		}

		// flip O to X and F back to O
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'F') {
					board[i][j] = 'O';
				}
			}
		}

	}

	private void Dfs(int i, int j, char[][] board) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
			return;
		}
		board[i][j] = 'F';

		Dfs(i + 1, j, board);
		Dfs(i - 1, j, board);
		Dfs(i, j + 1, board);
		Dfs(i, j - 1, board);
	}
	
//	public  static void main (String[] args) {
//		char[][] b = new char[1][1];
//		b[0][0] = 'O';
//		
//		SurroundedRegions t = new SurroundedRegions();
//		t.solve(b);
//	}
}
