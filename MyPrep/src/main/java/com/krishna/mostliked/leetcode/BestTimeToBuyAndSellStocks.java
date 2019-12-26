package com.krishna.mostliked.leetcode;

//https://www.youtube.com/watch?v=mj7N8pLCJ6w

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

class BestTimeToBuyAndSellStocksSolution {

	public int maxProfit(int[] prices) {

		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}

		return max;
	}
}

public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
