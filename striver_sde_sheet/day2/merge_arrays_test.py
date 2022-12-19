""" Test cases for https://leetcode.com/problems/merge-sorted-array/. """

import unittest
from merge_arrays import merge_arrays

class MergeArraysTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            merge_arrays(
                [1,2,3,0,0,0], 3, [2, 5, 6], 3),
                [1, 2, 2, 3, 5, 6])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            merge_arrays(
                [1], 1, [], 0),
                [1])

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            merge_arrays(
                [4,5,6,0,0,0], 3, [1, 2, 3], 3),
                [1, 2, 3, 4, 5, 6])

    def test_4(self):
        """ Testcase 4. """
        self.assertEqual(
            merge_arrays(
                [4, 5 ,6, 9, 0, 0, 0, 0], 4, [1, 2, 3, 7], 4),
                [1, 2, 3, 4, 5, 6, 7, 9])

if __name__ == '__main__':
    unittest.main()
