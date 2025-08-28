import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This program tries to determine the optimal drug dosage for a patient
 * using a priority queue.
 */
public class Main {
  /**
   * Represents a medicine with its name and frequency of dosage.
   */
  private static class Medicine {
    String name;
    int frequency;
    int priority;
    int originalFrequency;

    Medicine(String name, int originalFrequency, int frequency, int priority) {
      this.name = name;
      this.originalFrequency = originalFrequency;
      this.frequency = frequency;
      this.priority = priority;
    }
  }

  /**
   * Comparator for the Medicine class to prioritize by frequency.
   */
  private static class MedicineComparator implements java.util.Comparator<Medicine> {
    @Override
    public int compare(Medicine m1, Medicine m2) {
      // Lower frequency means higher priority
      if (m1.frequency != m2.frequency) {
        return Integer.compare(m1.frequency, m2.frequency);
      }
      // If frequencies are the same, use priority as a tiebreaker
      return Integer.compare(m1.priority, m2.priority);
    }
  }

  /**
   * Entry point of the program. Reads the input file and processes the data.
   *
   * @param args - not used
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());
    while (testCases-- > 0) {
      String[] medicineInfo = scanner.nextLine().split("\\s+");
      int n = Integer.parseInt(medicineInfo[0]); // number of medications
      int k = Integer.parseInt(medicineInfo[1]); // number of doses

      PriorityQueue<Medicine> doses =
          new PriorityQueue<>(new MedicineComparator());
      for (int i = 0; i < n; i++) {
        String[] medicine = scanner.nextLine().split("\\s+");
        String medicineName = medicine[0];
        int frequency = Integer.parseInt(medicine[1]);
        doses.offer(new Medicine(medicineName, frequency, frequency, i));
      }

      StringBuilder output = new StringBuilder();
      while (k-- > 0) {
        Medicine current = doses.poll();
        output.append(current.frequency + " " + current.name + "\n");
        // Update the frequency and reinsert into the queue
        current.frequency += current.originalFrequency;
        doses.offer(current);
      }
      System.out.print(output.toString());
    }
    scanner.close();
  }
}