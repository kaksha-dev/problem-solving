public class TestAvl {

    public static void main(String[] args) {
        BST<Integer, String> b = new BST<>();
        b.insert(8, "");
        b.insert(7, "");
        b.insert(6, "");
        b.insert(5, "");
        b.insert(4, "four");
        b.insert(3, "i m three");
        b.insert(2, "two");
        System.out.println(b.height()==7);

        AVLTree<Integer, String> avlTree = new AVLTree<>();
        avlTree.insert(8, "");
        avlTree.insert(7, "");
        avlTree.insert(6, "");
        avlTree.insert(5, "");
        avlTree.insert(4, "four");
        avlTree.insert(3, "i m three");
        avlTree.insert(2, "two");
        System.out.println(avlTree.height()==3);

    }
}
