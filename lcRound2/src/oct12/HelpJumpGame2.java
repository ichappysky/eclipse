package oct12;

public class HelpJumpGame2 {
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int steps = 0;
		int curReach = 0;
		int maxReach = 0;
		for (int i = 0; i < A.length; ++i) {
			if (i > curReach) {
				if (curReach == maxReach) {
					return -1;
				}
				curReach = maxReach;
				++steps;
			}
			maxReach = Math.max(maxReach, i + A[i]);
		}
		return steps;
	}

	public static void main(String[] a) {
		HelpJumpGame2 t = new HelpJumpGame2();
		System.out.print(t.jump(new int[] { 1, 2 }));
	}
}