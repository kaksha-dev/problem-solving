""" Test cases for https://leetcode.com/problems/unique-paths/. """

import unittest
from grid_unique_paths import unique_paths

class UniquePathsTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            unique_paths(3, 7), 28)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            unique_paths(3, 2), 3)

if __name__ == '__main__':
    unittest.main()
