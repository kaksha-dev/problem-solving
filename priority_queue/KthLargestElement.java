import java.util.PriorityQueue;

/**
 * This class finds the Kth largest element in an array. Main idea is that
 * if we use a min heap of size k, we are guaranteed that the queue contains
 * the k largest elements of the array. The root of the min heap will be the
 * kth largest element.
 * Constraints:
 *  - The array can contain duplicate elements.
 *  - Solution should not try to sort the entire array.
 */
public class KthLargestElement {
  /**
   * Finds the Kth largest element in the given array.
   *
   * @param nums the array of integers
   * @param k the position of the largest element to find (1-based index)
   * @return the Kth largest element in the array
   */
  public int findKthLargest(int[] nums, int k) {
    // Min Heap ensures that we keep the k largest elements in the heap.
    // with the smallest of these k elements at the root.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      minHeap.offer(num);
      
      // If the heap size exceeds k, remove the smallest element.
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    return minHeap.peek();
  }

  /**
   * Main method to test the KthLargestElement functionality.
   *
   * @param args - not used
   */
  public static void main(String[] args) {
    KthLargestElement finder = new KthLargestElement();

    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    assert finder.findKthLargest(nums, k) == 5 : "Test failed! Expected 5.";

    nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    k = 4;
    assert finder.findKthLargest(nums, k) == 4 : "Test failed! Expected 4.";
  }
}
