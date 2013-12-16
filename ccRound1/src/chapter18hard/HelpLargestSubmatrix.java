package chapter18hard;

import common.AssortedMethods;

public class HelpLargestSubmatrix {
	public static int getLargest(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return max;
		}
		int[] sum = new int[matrix[0].length];
		for (int rowStart = 0; rowStart < matrix.length; rowStart++) {

			for (int j = 0; j < matrix[0].length; j++) {
				sum[j] = 0;
			}
			for (int rowEnd = rowStart; rowEnd < matrix.length; rowEnd++) {
				for (int j = 0; j < matrix[0].length; j++) {
					sum[j] += matrix[rowEnd][j];
				}
				max = Math.max(max, getSubmax(sum));
			}
		}
		return max;

	}

	public static int getSubmax(int[] sum) {
		int max = Integer.MIN_VALUE;
		int curMax = 0;
		for (int i = 0; i < sum.length; i++) {
			curMax += sum[i];
			max = Math.max(max, curMax);
			if (curMax < 0) {
				curMax = 0;
			}
		}
		return max;
	}

	// ==========================
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(5, 7, -100, 100);
		int sum = maxSubMatrix(matrix);
		AssortedMethods.printMatrix(matrix);
		System.out.println("expected: " + sum);
		System.out.println("result: " + getLargest(matrix));
	}

	public static void clearArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}

	public static int maxSubMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		int[] partialSum = new int[colCount];
		int maxSum = 0; // Max sum is an empty matrix

		for (int rowStart = 0; rowStart < rowCount; rowStart++) {
			clearArray(partialSum);

			for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
				for (int i = 0; i < colCount; i++) {
					partialSum[i] += matrix[rowEnd][i];
				}

				int tempMaxSum = maxSubArray(partialSum, colCount);

				// if you want to track the coordinates, add code here to do
				// that
				maxSum = Math.max(maxSum, tempMaxSum);
			}
		}
		return maxSum;
	}

	public static int maxSubArray(int array[], int N) {
		int maxSum = 0;
		int runningSum = 0;

		for (int i = 0; i < N; i++) {
			runningSum += array[i];
			maxSum = Math.max(maxSum, runningSum);

			/*
			 * If running_sum is < 0 no point in trying to continue the series.
			 * Reset.
			 */
			if (runningSum < 0) {
				runningSum = 0;
			}
		}

		return maxSum;
	}

}
