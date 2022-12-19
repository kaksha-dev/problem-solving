""" Test cases for https://leetcode.com/problems/find-the-duplicate-number/. """

import unittest
from find_duplicate import find_duplicate

class FindDuplicateTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            find_duplicate(
                [1,3,4,2,2]),
                2)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            find_duplicate(
                [3,1,3,4,2]),
                3)

if __name__ == '__main__':
    unittest.main()
