public class BuySellOne {
	public int maxProfit(int[] prices) {

		if (prices == null) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			int curProfit = prices[i] - min;
			if (curProfit > maxProfit) {
				maxProfit = curProfit;
			}
		}

		return maxProfit < 0 ? 0 : maxProfit;
	}
}
