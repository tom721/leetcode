class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        min_price = sys.maxsize
        
        for p in prices:
            if p < min_price:
                min_price = p
            
            profit = p - min_price
            if profit > max_profit:
                max_profit = profit
        
        return max_profit
            
            