""" Test cases for https://leetcode.com/problems/maximum-subarray/. """

import unittest
from kadane_algorithm import max_sub_array

class MaxSubArrayTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(max_sub_array([-2,1,-3,4,-1,2,1,-5,4]), 6)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(max_sub_array([1]), 1)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(max_sub_array([5,4,-1,7,8]), 23)

if __name__ == '__main__':
    unittest.main()
