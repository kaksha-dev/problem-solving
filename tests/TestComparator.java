package tests;

import priorityqueue.generic.MaxPriorityQueue;
import java.util.Comparator;

/**
 * Test class for Comparator with Car objects.
 */
public class TestComparator {
  /**
   * A simple class Car created to test the Comparator
   * implementation. Car does not implement Comparable
   * interface, so we will use a Comparator to compare
   * Car objects based on size and color.
   */
    static class Car {
        private int color;
        private int size;
    
        public Car(int color, int size) {
            this.color = color;
            this.size = size;
        }
    
        /**
         * Getter for color.
         *
         * @return color of the car
         */
        public int getColor() {
            return color;
        }
    
        /**
         * Getter for size.
         *
         * @return size of the car
         */
        public int getSize() {
            return size;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Car other = (Car) obj;
            return this.color == other.color && this.size == other.size;
        }
    
        @Override
        public String toString() {
            return "Car(color: " + color + ", size: " + size + ")";
        }
    }

    public static void main(String[] args) {
        // Comparator to compare Car objects based on size, then color
        Comparator<Car> carComparator = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (car1.getSize() != car2.getSize()) {
                    return Integer.compare(car1.getSize(), car2.getSize());
                } else {
                    return Integer.compare(car1.getColor(), car2.getColor());
                }
            }
        };

        MaxPriorityQueue<Car> pq = new MaxPriorityQueue<>(10, carComparator);

        Car car1 = new Car(1, 10);
        Car car2 = new Car(2, 20);
        Car car3 = new Car(3, 15);
        Car car4 = new Car(4, 20); // Same size as car2 but different color

        pq.insert(car1);
        pq.insert(car2);
        pq.insert(car3);
        pq.insert(car4);

        assert pq.delMax().equals(car4) : "Max should be car4 (size 20, color 4)";
        assert pq.delMax().equals(car2) : "Next max should be car2 (size 20, color 2)";
        assert pq.delMax().equals(car3) : "Next max should be car3 (size 15)";
        assert pq.delMax().equals(car1) : "Last max should be car1 (size 10)";

        System.out.println("All tests passed!");
    }
  }