package tests;

import hash_tables.HashTable;

/**
 * Test class for HashTable with Foo objects as keys and String as values.
 * Foo class implements hashCode and equals methods to ensure proper
 * functionality in the hash table.
 */
class Foo {
  Integer x;
  Boolean y;
  String z;

  Foo(Integer x, Boolean y, String z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public int hashCode() {
    int hash = 17;
    hash = 31 * hash + (x == null ? 0 : x.hashCode());
    hash = 31 * hash + (y == null ? 0 : y.hashCode());
    hash = 31 * hash + (z == null ? 0 : z.hashCode());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Foo foo = (Foo) obj;
    return (x == null ? foo.x == null : x.equals(foo.x)) &&
           (y == null ? foo.y == null : y.equals(foo.y)) &&
           (z == null ? foo.z == null : z.equals(foo.z));
  }
}

/**
 * Test class for HashTable.
 */
public class TestHashTable {
  /**
   * Main method to run tests.
   *
   * @param args
   */
  public static void main(String[] args) {
    HashTable<Foo, String> hashTable = new HashTable<>();

    Foo foo1 = new Foo(1, true, "one");
    Foo foo2 = new Foo(2, false, "two");
    Foo foo3 = new Foo(3, true, "three");

    hashTable.put(foo1, "First");
    hashTable.put(foo2, "Second");
    hashTable.put(foo3, "Third");

    assert "First".equals(hashTable.get(foo1));
    assert "Second".equals(hashTable.get(foo2));
    assert "Third".equals(hashTable.get(foo3));
    assert hashTable.get(new Foo(4, false, "four")) == null;
    System.out.println("All tests passed.");
  }
}
