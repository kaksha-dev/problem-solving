""" Test cases for https://www.codingninjas.com/codestudio/problems/615. """

import unittest
from reverse_pairs import reverse_pairs

class RotateMatrixTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            reverse_pairs(
                [1, 2, 3, 4, 5]),
                0)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            reverse_pairs(
                [1, 3, 2, 3, 1]),
                2)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            reverse_pairs(
                [2, 4,3, 5, 1]),
                3)

    def test_4(self):
        """ Testcase 3. """
        self.assertEqual(
            reverse_pairs(
                [-5, -5]),
                1)

if __name__ == '__main__':
    unittest.main()
