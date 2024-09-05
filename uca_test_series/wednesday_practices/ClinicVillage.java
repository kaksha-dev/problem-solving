import java.util.PriorityQueue;
import java.util.Scanner;

public class ClinicVillage {
    public static float solve(int n, int m, int[] population) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            maxHeap.add(new Node(population[i], i));
        }
        m -= n;
        while (m > 0) {
            Node currentHighest = maxHeap.poll();
            System.out.println("Going to open a clinic in village "+currentHighest.getVillageId() + " having load " +currentHighest.getLoad());
            currentHighest.openAClinic();
            System.out.println("updated load = " + currentHighest.getLoad());
            System.out.println("---------------");
            maxHeap.add(currentHighest);
            m--;
        }
        return maxHeap.poll().getLoad();

    }

    public static void main(String[] args) {
        /*
         *  There are n cities given along with respective population. You have to open m clinics in 
         *  those cities such that maximum load on clinics are minimized. 
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] population = new int[n];
        for (int i = 0; i < n; i++) {
            population[i] = sc.nextInt();
        }
        sc.close();
        float maxLoad = ClinicVillage.solve(n, m, population);
        System.out.println("max load after opening all the clinics = " + maxLoad);
    }

    private static class Node implements Comparable<Node> {
        private final int population;
        private int clinicCount;
        private final int villageId;

        public Node(int population, int villageId) {
            this.population = population;
            this.clinicCount = 1;
            this.villageId = villageId;
        }

        public void openAClinic() {
            this.clinicCount++;
        }

        public int getVillageId(){
            return this.villageId;
        }

        public float getLoad() {
            return this.population / this.clinicCount;
        }

        @Override
        public int compareTo(Node o) {
            // this is make it max heap
            return (int) (o.getLoad() - this.getLoad());
        }

    }

}