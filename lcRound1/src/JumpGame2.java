public class JumpGame2 {
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int steps = 0;
		int prevReach = 0;
		int maxReach = 0;
		for (int i = 0; i < A.length; ++i) {
			if (i > prevReach) {
				if (prevReach == maxReach) {
					return -1;
				}
				prevReach = maxReach;
				++steps;
			}
			maxReach = Math.max(maxReach, i + A[i]);
		}
		return steps;
	}

	public static void main(String[] a) {
		JumpGame2 t = new JumpGame2();
		System.out.print(t.jump(new int[] { 2, 3, 1, 1, 4, 1, 0, 0, 0, 0, 0, 0,
				0, 0 }));
	}
}