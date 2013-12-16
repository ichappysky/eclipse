package oct03;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author yongz
 * 
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int result = 0;
		for (int a : A) {
			result ^= a;
		}
		return result;
	}
}
