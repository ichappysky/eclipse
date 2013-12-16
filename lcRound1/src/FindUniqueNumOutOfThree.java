public class FindUniqueNumOutOfThree {

	public static void main(String[] a) {
		int[] inputs = new int[] { 3, 3, 2, 3 };
		System.out.println("result: " + getUnique(inputs));
		 System.out.println(2 ^ 3);
	}

	private static int getUnique(int[] arr) {

		int ones = 0, twos = 0;

		int common_bit_mask;

		// Let us take the example of {3, 3, 2, 3} to understand this
		for (int i = 0; i < arr.length; i++) {
			/*
			 * The expression "one & arr[i]" gives the bits that are there in
			 * both 'ones' and new element from arr[]. We add these bits to
			 * 'twos' using bitwise OR Note: twos may '1' bit that actually
			 * appears 3 times. e.g., 11 OR 11 = 11 but both appear 3 times
			 */
			twos = twos | (ones & arr[i]);

			/*
			 * XOR the new bits with previous 'ones' to get all bits appearing
			 * odd number of times
			 * 
			 * Value of 'ones' will be set as 3, 0, 2 and 3 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones = ones ^ arr[i];
			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 * 
			 * Value of 'common_bit_mask' will be set as 11, 11, 01 and 10 after
			 * 1st, 2nd, 3rd and 4th iterations respectively
			 */
			common_bit_mask = ~(ones & twos);

			/*
			 * Remove common bits (the bits that appear third time) from 'ones'
			 * 
			 * Value of 'ones' will be set as 3, 0, 0 and 2 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones &= common_bit_mask;

			/*
			 * Remove common bits (the bits that appear third time) from 'twos'
			 * 
			 * Value of 'twos' will be set as 0, 3, 1 and 0 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			twos &= common_bit_mask;

		}

		return ones;

	}
}
