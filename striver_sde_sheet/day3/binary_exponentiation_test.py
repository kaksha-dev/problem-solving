""" Test cases for https://leetcode.com/problems/powx-n/. """

import unittest
from binary_exponentiation import myPow

class SearchMatrixTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            myPow(
                2.00000, 10),
                1024.00000)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            myPow(
                2.10000, 3),
                9.26100)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            myPow(
                2.00000, -2),
                0.25000)

if __name__ == '__main__':
    unittest.main()
