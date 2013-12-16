package oct03;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author yongz
 * 
 */
public class HelpSingleNumber2 {
	public int singleNumber(int[] arr) {
		int ones = 0;
		int twos = 0;
		for (int num : arr) {
			twos = twos | (ones & num); 
			ones = ones ^ num; // 1 or 3 times '1' would result 1
			int mask = ~(ones & twos);
			ones &= mask;
			twos &= mask;

		}

		return ones;
	}
}
