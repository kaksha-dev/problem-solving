""" Test cases for https://leetcode.com/problems/4sum/. """

import unittest
from four_sum import four_sum, four_sum_optimized

class FourSumTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            four_sum(
                [1, 0, -1, 0, -2, 2], 0),
                [[-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2]])
            
        self.assertEqual(
            four_sum_optimized(
                [1, 0, -1, 0, -2, 2], 0),
                [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            four_sum(
                [2, 2, 2, 2, 2], 8),
                [[2, 2, 2, 2]])
        
        self.assertEqual(
            four_sum_optimized(
                [2, 2, 2, 2, 2], 8),
                [[2, 2, 2, 2]])


if __name__ == '__main__':
    unittest.main()
