""" Problem : Merge Two Sorted Lists
Problem Id: Day 5, Problem 3
Onine Problem Link : https://leetcode.com/problems/merge-two-sorted-lists.

"""

class ListNode:
    '''
    Linked List Structure.
    '''
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    '''Merge two sorted linked lists. '''
    def reverse_list(self, list1, list2):
        '''Merges two sorted linked lists in O(N) time. '''
        head = ListNode()        
        x = head

        while list1 and list2:
            if list1.val <= list2.val:
                x.next = list1
                list1 = list1.next
            else:
                x.next = list2
                list2 = list2.next
            x = x.next
        
        if not list1:
            x.next = list2
        else:
            x.next = list1

        return head.next
