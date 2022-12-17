""" Test cases for https://leetcode.com/problems/set-matrix-zeroes. """

import unittest
from set_matrix_zeroes import set_zeroes

class MatrixZeroesTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(set_zeroes(
            [[1, 1, 1], [1, 0, 1], [1, 1, 1]]),
            [[1, 0, 1], [0, 0, 0], [1, 0, 1]])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(set_zeroes(
            [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]),
            [[0, 0, 0, 0], [0, 4, 5, 0],[0, 3, 1, 0]])

if __name__ == '__main__':
    unittest.main()
