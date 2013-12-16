package sept30;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded
 * region . 
 * 
 * For example,
** X X X X
** X O O X
X X O X
X O X X
After running your function, the board should be: 
X X X X
X X X X
X X X X
X O X X

 * 
 * @author yongz
 * 
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}
		for (int j = 0; j < board[0].length; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'o') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
				|| board[row][col] != 'O') {
			return;
		}
		board[row][col] = 'Z';

		dfs(board, row + 1, col);
		dfs(board, row - 1, col);
		dfs(board, row, col + 1);
		dfs(board, row, col - 1);
	}

	// public static void main(String[] args) {
	// char[][] b = new char[1][1];
	// b[0][0] = 'O';
	//
	// SurroundedRegions t = new SurroundedRegions();
	// t.solve(b);
	// }
}
