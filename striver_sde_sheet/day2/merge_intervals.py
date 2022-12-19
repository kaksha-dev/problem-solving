""" Problem : Merge Overlapping Subintervals
Problem Id: Day 2, Problem 2
Onine Problem Link : https://leetcode.com/problems/merge-intervals.

Solution Approach:
    1. Sort input intervals.
    2. Check for consecutive intervals ans merge them if they overlap.

Interesting alternative solution at:
    https://leetcode.com/problems/merge-intervals/solutions/.
"""

def merge_overlapping_intervals(intervals):
    """ Given an array of intervals where intervals[i] = [starti, endi],
    merge all overlapping intervals.

    Arguments:
    matrix -- input matrix to rotate
    """
    intervals.sort()
    output = [intervals[0]]

    for  interval in intervals:
        if overlap(output[-1], interval):
            output[-1][1] = max(output[-1][1], interval[1])
        else:
            output.append(interval)
    return output


def overlap(interval1, interval2):
    """ Returns true if interval1 and interval2 overlap.

    Arguments:
    interval1 -- First interval
    interval2 -- Second Interval

    Assumption:
    interval1 and interval2 are sorted according in ascending order.
    """
    if interval2[0] <= interval1[1]:
        return True
    return False