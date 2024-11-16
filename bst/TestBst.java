
public class TestBst {

    public static void main(String[] args) {
        BST<Integer, String> b = new BST<>();
        b.insert(5, "");
        b.insert(3, "i m three");
        b.insert(4, "four");
        b.insert(2, "two");
        b.insert(6, "");
        b.insert(7, "");
        b.insert(8, "");
        System.out.println(b.fca(3,5)==null);
        System.out.println(b.fca(3,4)==5);
        System.out.println(b.fca(2,4)==3);

        System.out.println(b.getMin()==2);
        System.out.println(b.search(3).equalsIgnoreCase("i m three"));
        System.out.println(b.search(2).equalsIgnoreCase("two"));
        b.del(3);
        System.out.println(b.search(3)==null);
        System.out.println(b.search(4).equalsIgnoreCase("four"));
        System.out.println(b.search(2).equalsIgnoreCase("two"));
        System.out.println(b.getMin()==2);
        b.delMin();
        System.out.println(b.search(2)==null);
    }
}
