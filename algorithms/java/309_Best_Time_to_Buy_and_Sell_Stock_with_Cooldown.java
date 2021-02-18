class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[] profit = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            int max = profit[i + 1];
            for (int j = i + 1; j < length; j++) {
                int tmp = 0;
                if (j < length - 2) {
                    tmp = prices[j] - prices[i] + profit[j + 2];
                } else {
                    tmp = prices[j] - prices[i];
                }
                max = max > tmp ? max : tmp;
            }
            profit[i] = max;
        }
        return profit[0];
    }
}