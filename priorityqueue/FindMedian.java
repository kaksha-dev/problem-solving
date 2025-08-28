import java.util.PriorityQueue;

/**
 * This class finds medians from a stream of integers. 
 * It uses two heaps: a max-heap for the lower half of the numbers and a
 * min-heap for the upper half. The median can be found in O(1) time after
 * each insertion. Each insertion takes O(log n) time.
 */
public class FindMedian {
  private PriorityQueue<Integer> lowerHalf; // Max-heap for the lower half
  private PriorityQueue<Integer> upperHalf; // Min-heap for the upper half
  private boolean isEven;

  /**
   * Initializes the FindMedian object.
   */
  public FindMedian() {
    lowerHalf = new PriorityQueue<>((a, b) -> b - a); // Max-heap
    upperHalf = new PriorityQueue<>(); // Min-heap
    isEven = true;
  }
  
  /**
   * Inserts a number into the data structure.
   *
   * @param num - the number to be inserted
   */
  public void addNum(int num) {
    if (isEven) {
      // Add to the lower half (max-heap)
      lowerHalf.offer(num);
      // Move the largest of the lower half to the upper half (min-heap)
      upperHalf.offer(lowerHalf.poll());
    } else {
      // Add to the upper half (min-heap)
      upperHalf.offer(num);
      // Move the smallest of the upper half to the lower half (max-heap)
      lowerHalf.offer(upperHalf.poll());
    }
    isEven = !isEven; // Toggle the parity
  }
  
  /**
   * Finds the median of the current data stream.
   *
   * @return the median of the current data stream
   */
  public double findMedian() {      
    if (isEven) {
      // If even, the median is the average of the two middle elements
      return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
    } else {
      // If odd, the median is the top of the max-heap
      return upperHalf.peek();
    }
  }

  /**
   * Main method for testing the FindMedian class.
   */
  public static void main(String[] args) {
    FindMedian findMedian = new FindMedian();
    findMedian.addNum(1);
    assert findMedian.findMedian() == 1.0 : "Median should be 1.0";
    findMedian.addNum(2);
    assert findMedian.findMedian() == 1.5 : "Median should be 1.5";
    findMedian.addNum(3);
    assert findMedian.findMedian() == 2.0 : "Median should be 2.0";
    findMedian.addNum(4);
    assert findMedian.findMedian() == 2.5 : "Median should be 2.5";
    findMedian.addNum(5);
    assert findMedian.findMedian() == 3.0 : "Median should be 3.0";
  }
}