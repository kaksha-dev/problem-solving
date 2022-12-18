""" Test cases for https://leetcode.com/problems/best-time-to-buy-and-sell-stock/. """

import unittest
from stock_buy_sell import max_stock_profit

class MaxStockProfitTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(max_stock_profit([7,1,5,3,6,4]), 5)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(max_stock_profit([7,6,4,3,1]), 0)

if __name__ == '__main__':
    unittest.main()
