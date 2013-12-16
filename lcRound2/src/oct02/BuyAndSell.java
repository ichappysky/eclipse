package oct02;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author yongz
 * 
 */
public class BuyAndSell {
	public int maxProfit(int[] prices) {
		int curMin = Integer.MAX_VALUE;
		int maxP = 0;
		for (int p : prices) {
			curMin = Math.min(curMin, p);
			maxP = Math.max(p - curMin, maxP);
		}
		return maxP;

	}

}
