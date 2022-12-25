""" Test cases for https://leetcode.com/problems/majority-element-ii/. """

import unittest
from majority_element_nby3 import majority_element

class MajorityElementTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            majority_element([3,2,3]), [3])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            majority_element([1]), [1])

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            majority_element([1, 2]), [1, 2])

    def test_4(self):
        """ Testcase 4. """
        self.assertEqual(
            majority_element([1, 2, 3, 1, 3]), [1, 3])

    def test_5(self):
        """ Testcase 5. """
        self.assertEqual(
            majority_element([1, 1, 1, 2, 2, 2]), [1, 2])

if __name__ == '__main__':
    unittest.main()
