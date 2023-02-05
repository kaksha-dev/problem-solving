""" Problem : Remove N-th node from the end of a Linked List.
Problem Id: Day 5, Problem 4
Onine Problem Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/.

"""

class ListNode:
    '''
    Linked List Structure.
    '''
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    '''Remove N-th node from the end of a Linked List. '''
    def removeNthFromEnd(self, head, n):
        '''Remove N-th node from the end of a Linked List in linear time. '''
        length = self.length_ll(head)
        if length == 1 and n == 1:
            return None

        x = 0
        curr = head
        prev = None
        while x < length-n:
            x += 1
            prev = curr
            curr = curr.next
        
        if x == 0:
            return head.next

        prev.next = curr.next
        curr = None

        return head

    def length_ll(self, head):
        '''Returns the number of nodes in the linked list.'''
        length = 0
        while head:
            length += 1
            head = head.next
        return length

