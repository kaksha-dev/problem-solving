public interface BST<K extends Comparable<K>, V> {
    int height();

    int rotations();

    int totalRotations();

    int maxRotations();

    void insert(K k, V v);

    int totalTime();
}
