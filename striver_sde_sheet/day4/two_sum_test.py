""" Test cases for https://leetcode.com/problems/two-sum/. """

import unittest
from two_sum import two_sum

class TwoSumTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            two_sum(
                [2, 7, 11, 15], 9),
                [0, 1])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            two_sum(
                [3, 2, 4], 6),
                [1, 2])

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            two_sum(
                [3, 3], 6),
                [0, 1])


if __name__ == '__main__':
    unittest.main()
