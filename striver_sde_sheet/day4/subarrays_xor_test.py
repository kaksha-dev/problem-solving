""" Test cases for https://www.interviewbit.com/problems/subarray-with-given-xor/. """

import unittest
from subarrays_xor import subarrays_given_xor

class SubArraysXorTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            subarrays_given_xor(
                [4, 2, 2, 6, 4], 6),
                4)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            subarrays_given_xor(
                [5, 6, 7, 8, 9], 5),
                2)

if __name__ == '__main__':
    unittest.main()
