package oct01;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author yongz
 * 
 */
public class HelpBuyAndSell3 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] forward = new int[prices.length];
		int[] backward = new int[prices.length];

		forward[0] = 0;
		int curMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			forward[i] = Math.max(forward[i - 1], prices[i] - curMin);
			curMin = Math.min(curMin, prices[i]);
		}

		int maxP = 0;
		backward[prices.length - 1] = 0;
		int curMax = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			backward[i] = Math.max(backward[i + 1], curMax - prices[i]);
			curMax = Math.max(curMax, prices[i]);
			maxP = Math.max(maxP, forward[i] + backward[i]);
		}
		return maxP;

	}
}