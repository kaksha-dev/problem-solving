public class BPlusTreeTest {
    public static void main(String[] args) {
        BPlusTree<Integer, String> t = new BPlusTree<>();
        t.insert(10, "10");
        t.insert(20, "20");
        t.insert(40, "40");
        t.insert(50, "50");
        t.insert(60, "60");
        t.insert(70, "70");
        t.insert(80, "80");
        t.insert(90, "90");
        t.insert(30, "30");
        t.insert(35, "35");
        t.insert(15, "15");
        t.insert(5, "5");
        assert t.size() == 12;
        assert t.height() == 2;
        for (int i = 10; i < 100; i += 10) {
            System.out.println("validating " + i);
            assert t.search(i).equalsIgnoreCase(String.valueOf(i));
        }
        assert t.search(35).equalsIgnoreCase("35");
        assert t.search(5).equalsIgnoreCase("5");
        assert t.search(19) == null;
        t.insert(15, "New15");
        assert t.search(15).equalsIgnoreCase("New15");
    }
}
