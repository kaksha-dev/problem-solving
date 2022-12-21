""" Test cases for https://www.codingninjas.com/codestudio/problems/615. """

import unittest
from count_inversions import count_inversions

class RotateMatrixTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            count_inversions(
                [1, 2, 3, 4, 5]),
                0)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            count_inversions(
                [5, 4, 3, 2, 1]),
                10)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            count_inversions(
                [5, 3, 2, 1, 4]),
                7)

if __name__ == '__main__':
    unittest.main()
