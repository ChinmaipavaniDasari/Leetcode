class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < buy_price){
                buy_price = prices[i];
            }
            int currProfit = prices[i] - buy_price;
            profit = Math.max(profit,currProfit);

        }
        return profit;

    }
}