""" Test cases for https://leetcode.com/problems/majority-element/. """

import unittest
from majority_element_nby2 import majority_element

class MajorityElementTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            majority_element([3,2,3]), 3)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            majority_element([2,2,1,1,1,2,2]), 2)

if __name__ == '__main__':
    unittest.main()