package oct02;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author yongz
 * 
 */
public class HelpCandy {

	public int candy(int[] ratings) {
		int[] amounts = new int[ratings.length];
		int curAmount = 0;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				curAmount++;
			} else {
				curAmount = 0;
			}
			amounts[i] = curAmount;
		}

		curAmount = 0;
		int result = ratings.length;
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				curAmount++;
			} else {
				curAmount = 0;
			}
			result += Math.max(curAmount, amounts[i]);
		}

		result += amounts[ratings.length - 1];
		return result;
	}

	public static void main(String[] x) {
		HelpCandy t = new HelpCandy();
		System.out.println(t.candy(new int[] { 4, 4, 4, 2, 4 }));
	}

}
