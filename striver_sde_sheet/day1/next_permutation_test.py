""" Test cases for https://leetcode.com/problems/next-permutation/. """

import unittest
from next_permutation import next_permutation

class NextPermutationTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(next_permutation([1, 2, 3]), [1, 3, 2])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(next_permutation([3, 2, 1]), [1, 2, 3])

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(next_permutation([1, 1, 5]), [1, 5, 1])

    def test_4(self):
        """ Testcase 4. """
        self.assertEqual(next_permutation([1, 3, 2]), [2, 1, 3])

if __name__ == '__main__':
    unittest.main()
