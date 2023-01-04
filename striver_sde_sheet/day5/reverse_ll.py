""" Problem : Reverse Linked List
Problem Id: Day 5, Problem 1
Onine Problem Link : https://leetcode.com/problems/two-sum/.

"""

class Solution:
    '''Reverse a linked list.'''
    def reverse_list(self, head):
        '''Recursively iterate linked list'''
        return self.reverse_linked_list(head)

    def reverse_linked_list(self, head):
        '''Recursively iterate linked list'''
        if head is None:
            return None
        if head.next is None:
            return head

        prev = head
        head = head.next
        new_head = self.reverse_linked_list(head)
        head.next = prev
        prev.next = None

        return new_head
