package tests;

import priorityqueue.generic.MaxPriorityQueue;

/**
 * Test class for MaxPriorityQueue with Car objects.
 */
public class TestMaxPriorityQueue {
  /**
   * A simple class Car created to test the generic
   * MaxPriorityQueue implementation. Car implements
   * Comparable interface to allow comparison based on size.
   */
  static class Car implements Comparable<Car> {
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

    /**
     * Compares this car with another car based on size.
     *
     * @param other - another car to compare with
     * @return negative integer if this car is smaller, positive integer if larger,
     *         zero if equal in size
     */
    @Override
    public int compareTo(Car other) {
      if (this.size < other.size) {
        return -1;
      } else if (this.size > other.size) {
        return 1;
      } else {
        return 0;
      } 
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      Car car = (Car) obj;
      return color == car.color && size == car.size;
    }
  }

  /**
   * Test the MaxPriorityQueue with Car objects.
   *
   * @param args - command line arguments (not used)
   */
  public static void main(String[] args) {
    Car car1 = new Car(1, 10);
    Car car2 = new Car(2, 20);
    Car car3 = new Car(3, 15);

    MaxPriorityQueue<Car> carQueue = new MaxPriorityQueue<>(10);
    carQueue.insert(car1);
    carQueue.insert(car2);
    carQueue.insert(car3);

    assert carQueue.delMax() == car2; // Car with size 20
    assert carQueue.delMax().equals(new Car(3, 15)); // Car with size 15
    assert carQueue.delMax() == car1; // Car with size 10
  }
}