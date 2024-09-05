import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void add(int n) {
        if (maxHeap.size() == 0) {
            maxHeap.add(n);
            return;
        }
        if (maxHeap.size() > minHeap.size()) {
            if (n < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(n);
            } else {
                minHeap.add(n);
            }
            return;
        }
        if (maxHeap.size() < minHeap.size()) {
            if (n > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(n);
            } else {
                maxHeap.add(n);
            }
            return;
        }
        if (n < maxHeap.peek()) {
            maxHeap.add(n);
        } else {
            minHeap.add(n);
        }

    }

    public float getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.size() == 0 ? 0 : (maxHeap.peek() + minHeap.peek()) / 2;
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        /*
         * There is stream of numbers coming continuously in random order. You have to store those numbers efficiently 
         * and at any point of time somebody might ask what is the median of whatever data you have stored as of now. 
         * Design data storage where insertion and calculation of median function is optimized. 
         */
        MedianInStream ms = new MedianInStream();
        System.out.println(ms.getMedian()==0);
        ms.add(4);
        System.out.println(ms.getMedian()==4);
        ms.add(2);
        System.out.println(ms.getMedian()==3);
        ms.add(5);
        System.out.println(ms.getMedian()==4);
        ms.add(1);
        System.out.println(ms.getMedian()==3);
        ms.add(3);
        System.out.println(ms.getMedian()==3);
    }

}
