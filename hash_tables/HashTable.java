package hash_tables;

/**
 * A simple implementation of a hash table using separate chaining for
 * collision resolution. This implementation does not handle resizing
 * or load factor management.
 *
 * @param <Key>   the type of keys maintained by this hash table
 * @param <Value> the type of mapped values
 */
public class HashTable<Key, Value> {
  private int M = 32;
  private Node[] st = new Node[M];

  /**
   * Representation of a node in the linked list used for separate chaining.
   */
  static class Node {
    private Object key;
    private Object value;
    private Node next;

    Node(Object key, Object value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  /**
   * Hash function to compute the index for a given key.
   * 
   * @param key
   * @return index in the hash table array
   */
  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  /**
   * Retrieve the value associated with the given key.
   * 
   * @param key
   * @return value associated with the key, or null if not found
   */
  public Value get(Key key) {
    int i = hash(key);

    for (Node x=st[i]; x!=null; x=x.next) {
      if (x.key.equals(key)) {
        return ((Value) x.value);
      }
    }
    return null;
  }

  /**
   * Insert a key-value pair into the hash table. If the key already exists,
   * update its value.
   * 
   * @param key
   * @param value
   */
  public void put(Key key, Value value) {
    int i = hash(key);

    for (Node x=st[i]; x!=null; x=x.next) {
      if (x.key.equals(key)) {
        x.value = value;
      }
    }

    st[i] = new Node(key, value, st[i]);
  }
}
