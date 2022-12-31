""" Test cases for https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1. """

import unittest
from longest_subarray import length_longest_subarray

class LongestSubarrayTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            length_longest_subarray(
                [15, -2, 2, -8, 1, 7, 10, 23]),
                5)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            length_longest_subarray(
                [9, -3, 3, -1, 6, -5]),
                5)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            length_longest_subarray(
                [6, -2, 2, -8, 1, 7, 4, -10]),
                8)


if __name__ == '__main__':
    unittest.main()
