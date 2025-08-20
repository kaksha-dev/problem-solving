import java.util.Comparator;

/**
* Comparator to compare values of two list nodes.
*/
class ListNodeComparator implements Comparator<ListNode> {
  @Override
  public int compare(ListNode node1, ListNode node2) {
    if (node1.val < node2.val) {
      return -1;
    } else if (node1.val == node2.val) {
      return 0;
    } else {
      return 1;
    }
  }
}

