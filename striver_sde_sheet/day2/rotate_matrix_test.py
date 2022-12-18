""" Test cases for https://leetcode.com/problems/rotate-image/. """

import unittest
from rotate_matrix import rotate_matrix

class RotateMatrixTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            rotate_matrix(
                [[1,2,3],[4,5,6],[7,8,9]]),
                [[7,4,1],[8,5,2],[9,6,3]])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            rotate_matrix(
                [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]),
                [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]])

if __name__ == '__main__':
    unittest.main()
