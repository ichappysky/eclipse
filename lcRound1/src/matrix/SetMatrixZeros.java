package matrix;

public class SetMatrixZeros {
	public void setZeroes(int[][] m) {
		if (m == null) {
			return;
		}

		boolean hasZerosInFirstCol = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 0) {
				hasZerosInFirstCol = true;
				break;
			}
		}
		boolean hasZerosInFirstRow = false;
		for (int j = 0; j < m[0].length; j++) {
			if (m[0][j] == 0) {
				hasZerosInFirstRow = true;
				break;
			}
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					m[0][j] = 0;
					m[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if (m[0][j] == 0 || m[i][0] == 0) {
					m[i][j] = 0;
				}
			}
		}

		if (hasZerosInFirstCol) {
			for (int i = 0; i < m.length; i++) {
				m[i][0] = 0;
			}
		}
		if (hasZerosInFirstRow) {
			for (int j = 0; j < m[0].length; j++) {
				m[0][j] = 0;
			}
		}
	}
}