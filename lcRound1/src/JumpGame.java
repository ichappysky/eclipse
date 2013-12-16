public class JumpGame {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		int maxReach = A[0];
		if (maxReach>=A.length-1){
			return true;
		}
		for (int i=1; i<=maxReach; i++) {
			int curReach = i+A[i];
			maxReach = Math.max(maxReach, curReach);
			if (maxReach>=A.length-1) {
				return true;
			}
		}
		return false;

	}
}