public class BuySellThree {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] forward = new int[prices.length];
		int[] backward = new int[prices.length];

		int curMin = prices[0];
		forward[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < curMin) {
				curMin = prices[i];
			}
			forward[i] = Math.max(forward[i - 1], prices[i] - curMin);
		}

		int curMax = prices[prices.length - 1];
		backward[prices.length - 1] = 0;
		int maxProfit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > curMax) {
				curMax = prices[i];
			}
			backward[i] = Math.max(backward[i + 1], curMax - prices[i]);
			maxProfit = Math.max(maxProfit, forward[i] + backward[i]);
		}
		return maxProfit;
	}
}
