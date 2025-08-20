import java.util.PriorityQueue;

/**
* Given an array of k linked-lists lists, each linked-list is sorted in ascending order.
* Merge all the linked-lists into one sorted linked-list and return it.
*/
public class MergeLists {
  /**
  * Given a list of sorted linked lists, merge them
  * into a single sorted linked list.
  *
  * @param lists - Array of references to head nodes of input linked lists.
  * @returns ListNode - Reference to head node of merged Linked List.  
  */
  public ListNode mergeLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
    ListNode head = new ListNode();
    ListNode current = head;

    for (ListNode list : lists) {
      if (list == null) {
        continue;
      }
      
      // Add reference of head node to priority queue.
      pq.offer(list);
    }
   
    while (!pq.isEmpty()) {
      // Pop the node with smallest value and link it to the output.
      ListNode node = pq.poll();
      current.next = node;
      current = current.next;

      // Traverse through the linked of popped node.
      if (node.next != null) {
        pq.offer(node.next);
      }
    }

    return head.next;
  }
  
  /**
   * Main method for testing the MergeKLists class.
   */
  public static void main(String[] args) {
    ListNode[] lists = new ListNode[3];
    lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
    lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
    lists[2] = new ListNode(2, new ListNode(6));
    MergeLists merge = new MergeLists();
    ListNode merged = merge.mergeLists(lists);
    
    while (merged != null) {
      System.out.print(merged.val + " -> ");
      merged = merged.next;
    }
    System.out.println("null");
  }
}
