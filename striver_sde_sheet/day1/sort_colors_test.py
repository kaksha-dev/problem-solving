""" Test cases for https://leetcode.com/problems/sort-colors/. """

import unittest
from sort_colors import sort_colors, sort_colors_easy

class SortColorsTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(sort_colors([2,0,2,1,1,0]), [0,0,1,1,2,2])
        self.assertEqual(sort_colors_easy([2,0,2,1,1,0]), [0,0,1,1,2,2])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(sort_colors([0]), [0])
        self.assertEqual(sort_colors_easy([2,0,2,1,1,0]), [0,0,1,1,2,2])
   
    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(sort_colors([1]), [1])
        self.assertEqual(sort_colors_easy([2,0,2,1,1,0]), [0,0,1,1,2,2])

    def test_4(self):
        """ Testcase 4. """
        self.assertEqual(sort_colors([2]), [2])
        self.assertEqual(sort_colors_easy([2,0,2,1,1,0]), [0,0,1,1,2,2])

    def test_5(self):
        """ Testcase 5. """
        self.assertEqual(sort_colors([2,0,1]), [0, 1, 2])
        self.assertEqual(sort_colors_easy([2,0,2,1,1,0]), [0,0,1,1,2,2])

    def test_6(self):
        """ Testcase 6. """
        self.assertEqual(sort_colors([1, 0, 1, 0, 2, 1, 0, 2]), [0, 0, 0, 1, 1, 1, 2, 2])
        self.assertEqual(sort_colors_easy([2,0,2,1,1,0]), [0,0,1,1,2,2])

if __name__ == '__main__':
    unittest.main()
