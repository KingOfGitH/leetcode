package middle;

public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                maxProfit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return maxProfit;
    }
}
