""" Problem : Stock Buy And Sell
Problem Id: Day 1, Problem 6
Onine Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

"""

def max_stock_profit(prices):
    """ Determines maximum profit for stocks

    Arguments:
    nums -- stock prices each day
    """
    min_buy_price = prices[0]
    max_profit = 0

    for i in range(1,  len(prices)):
        max_profit = max(max_profit, prices[i]-min_buy_price)
        min_buy_price = min(min_buy_price, prices[i])

    return max_profit
