package chapter09RecursionAndDP;

import java.util.ArrayList;

public class EightQueens {
	public static void placeQueens(int row, Integer[] columns,
			ArrayList<Integer[]> results) {
		for (int i = 0; i < 8; i++) {
			columns[row] = i;
			if (isValid(row, columns)) {
				if (row == 7) {
					results.add(columns.clone());
				} else {
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	private static boolean isValid(int row, Integer[] columns) {
		for (int i = 0; i < row; i++) {
			if (columns[i] == columns[row]) {
				return false;
			}
			if ((row - i) == Math.abs(columns[row] - columns[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		clear(columns);
		placeQueens(0, columns, results);
		printBoards(results);
		System.out.println(results.size());
	}

	public static void clear(Integer[] columns) {
		for (int i = 0; i < GRID_SIZE; i++) {
			columns[i] = -1;
		}
	}

	public static void printBoard(Integer[] columns) {
		drawLine();
		for (int i = 0; i < GRID_SIZE; i++) {
			System.out.print("|");
			for (int j = 0; j < GRID_SIZE; j++) {
				if (columns[i] == j) {
					System.out.print("Q|");
				} else {
					System.out.print(" |");
				}
			}
			System.out.print("\n");
			drawLine();
		}
		System.out.println("");
	}

	public static void printBoards(ArrayList<Integer[]> boards) {
		for (int i = 0; i < boards.size(); i++) {
			Integer[] board = boards.get(i);
			printBoard(board);
		}
	}

	private static void drawLine() {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < GRID_SIZE * 2 + 1; i++)
			line.append('-');
		System.out.println(line.toString());
	}

	public static int GRID_SIZE = 8;
}
