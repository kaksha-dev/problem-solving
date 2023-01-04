""" Problem : Middle of the Linked List
Problem Id: Day 5, Problem 2

Onine Problem Link : https://leetcode.com/problems/two-sum/.
"""

class Solution:
    '''Find middle of the linked list.'''
    def middle_node(self, head):
        '''Returns the pointer to middle of the linked list'''
        slowptr = head
        fastptr = head

        while fastptr is not None:
            fastptr = fastptr.next
            if not fastptr:
                break
            fastptr = fastptr.next
            slowptr = slowptr.next
        return slowptr
