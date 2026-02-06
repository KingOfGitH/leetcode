package easy;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }else {
                buy = prices[i];
            }
        }
        return maxProfit;
    }

    public int myMaxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                for (int j = i + 1; j  < prices.length; j++) {
                    maxProfit = Math.max(maxProfit, prices[j] - buy);
                }
            }
        }
        return maxProfit;
    }
}
