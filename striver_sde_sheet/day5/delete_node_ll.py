""" Problem : Delete Node in a Linked List.
Problem Id: Day 5, Problem 6
Onine Problem Link : https://leetcode.com/problems/delete-node-in-a-linked-list/.
Solution Description:
 https://leetcode.com/problems/delete-node-in-a-linked-list/solutions/2506192/delete-node-in-a-linked-list/

"""

class ListNode:
    '''
    Linked List Structure.
    '''
    def __init__(self, val=0):
        self.val = val
        self.next = None

class Solution:
    '''Delete Node in a Linked List. '''
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        # Since we know input node is not last node, so nextNode will not be null
        nextNode = node.next
        # Step 2
        node.val = nextNode.val
        # Step 3
        node.next = nextNode.next
        nextNode.next = None
        del(nextNode)
    





