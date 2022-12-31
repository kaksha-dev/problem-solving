""" Test cases for https://leetcode.com/problems/longest-consecutive-sequence/. """

import unittest
from lcs import longest_consecutive

class LCSTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            longest_consecutive(
                [100, 4, 200, 1, 3, 2]),
                4)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            longest_consecutive(
                [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]),
                9)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            longest_consecutive(
                [1, 2, 0, 1]),
                3)

if __name__ == '__main__':
    unittest.main()
