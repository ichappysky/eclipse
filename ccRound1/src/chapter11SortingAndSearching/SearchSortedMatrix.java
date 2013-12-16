package chapter11SortingAndSearching;

import common.AssortedMethods;

public class SearchSortedMatrix {
	public static boolean search(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			}
			if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}

		AssortedMethods.printMatrix(matrix);

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int v = 10 * i + j;
				if ((v % 10 > 4 && search(matrix, v))
						|| (v % 10 <= 4 && !search(matrix, v))) {
					System.out.println("eerrrr");
				}
			}
		}

	}
}
