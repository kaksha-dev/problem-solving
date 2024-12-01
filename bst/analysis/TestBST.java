import java.util.*;

public class TestBST {
    private static final List<String> dataPoints = Arrays.asList(("count,H_AVL,H_RBT,AVL_Key_Rotation," +
            "RBT_Key_Rotation,H_AVL_Seq,H_RBT_Seq,AVL_Key_Rotation_Seq,RBT_Key_Rotation_Seq," +
            "AVL_Total_Rotations,RBT_Total_Rotations,AVL_Total_Rotations_Seq,RBT_Total_Rotations_Seq," +
            "AVL_Max_Rotations,RBT_Max_Rotations,AVL_Max_Rotations_Seq,RBT_Max_Rotations_Seq,AVL_Time," +
            "RBT_Time,AVL_Time_Seq,RBT_Time_Seq").split(","));

    public static void main(String[] args) {

        Map<String, List<Integer>> map = new HashMap<>();
        dataPoints.forEach(e -> map.put(e, new ArrayList<>()));
        int sampleSize = 100;
        Random r = new Random();
        for (int i = 1; i < 50; i++) {
            BST<Integer, Integer> avlRandom = new AVLTree<>();
            BST<Integer, Integer> rbtRandom = new RBTTree<>();
            BST<Integer, Integer> avlSequential = new AVLTree<>();
            BST<Integer, Integer> rbtSequential = new RBTTree<>();
            for (int key = 1; key < sampleSize; key++) {
                int randomKey = r.nextInt();
                avlRandom.insert(randomKey, randomKey);
                rbtRandom.insert(randomKey, randomKey);
                avlSequential.insert(key, key);
                rbtSequential.insert(key, key);
            }
            sampleSize += 200;
            map.get("count").add(sampleSize);
            map.get("H_AVL").add(avlRandom.height());
            map.get("H_RBT").add(rbtRandom.height());
            map.get("AVL_Key_Rotation").add(avlRandom.rotations());
            map.get("RBT_Key_Rotation").add(rbtRandom.rotations());
            map.get("AVL_Total_Rotations").add(avlRandom.totalRotations());
            map.get("RBT_Total_Rotations").add(rbtRandom.totalRotations());
            map.get("AVL_Max_Rotations").add(avlRandom.maxRotations());
            map.get("RBT_Max_Rotations").add(rbtRandom.maxRotations());

            map.get("H_AVL_Seq").add(avlSequential.height());
            map.get("H_RBT_Seq").add(rbtSequential.height());
            map.get("AVL_Key_Rotation_Seq").add(avlSequential.rotations());
            map.get("RBT_Key_Rotation_Seq").add(rbtSequential.rotations());
            map.get("AVL_Total_Rotations_Seq").add(avlSequential.totalRotations());
            map.get("RBT_Total_Rotations_Seq").add(rbtSequential.totalRotations());
            map.get("AVL_Max_Rotations_Seq").add(avlSequential.maxRotations());
            map.get("RBT_Max_Rotations_Seq").add(rbtSequential.maxRotations());

            map.get("AVL_Time").add(avlRandom.totalTime());
            map.get("RBT_Time").add(rbtRandom.totalTime());
            map.get("AVL_Time_Seq").add(avlSequential.totalTime());
            map.get("RBT_Time_Seq").add(rbtSequential.totalTime());
        }
        printCsvHeader();
        printCsvData(map);
    }

    private static void printCsvData(Map<String, List<Integer>> map) {
        for (int i = 0; i < map.get("count").size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (String dataPoint : dataPoints) {
                sb.append(map.get(dataPoint).get(i)).append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    private static void printCsvHeader() {
        StringBuilder finalSb = new StringBuilder();
        dataPoints.forEach(e -> finalSb.append(e).append(","));
        System.out.println(finalSb.substring(0, finalSb.length() - 1));
    }
}
