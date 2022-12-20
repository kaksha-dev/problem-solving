""" Test cases for https://www.interviewbit.com/problems/repeat-and-missing-number-array. """

import unittest
from missing_repeating import missing_repeating

class FindDuplicateTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            missing_repeating(
                [1, 3, 5, 4, 4], 5),
                (2, 4))

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            missing_repeating(
                [4, 5, 2, 9, 8, 1, 1, 7, 10, 3], 10),
                (6, 1))

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            missing_repeating(
                [7, 5, 3, 2, 1, 6, 6], 7),
                (4, 6))

if __name__ == '__main__':
    unittest.main()
