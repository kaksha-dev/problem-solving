import java.io.*;

public class BinarySearchTree
{
  class Node
  {
    String key;
    Integer value;
    Node left;
    Node right;
    
    Node(String key, Integer value)
    {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  Node root;

  BinarySearchTree()
  {
    this.root = null;
  }

  public Integer get(String key)
  {
    return get(root, key);
  }

  private Integer get(Node x, String key)
  {
    if(x == null) return null;

    int c = key.compareTo(x.key);
    if(c == 0) return x.value;
    else if(c < 0) return get(x.left, key);
    else return get(x.right, key);
  }


  public void put(String key, Integer value)
  {
    root = put(root, key, value);
  }
  
  private Node put(Node x, String key, Integer value)
  {
    if(x == null) return new Node(key, value);

    int c = key.compareTo(x.key);
    if(c == 0) x.value = value;
    else if(c < 0) x.left = put(x.left, key, value);
    else x.right = put(x.right, key, value);

    return x;
  }

  public static void main(String[] args) throws IOException
  {
    /*BinarySearchTree bst = new BinarySearchTree();
    
    bst.put(5, 3);
    bst.put(3, 5);
    bst.put(1, 6);
    bst.put(7, 3);
    bst.put(9, 1);

    assert bst.get(7) == 3;
    assert bst.get(11) == null;
    assert bst.get(1) == 6;*/

    // Download file from https://introcs.cs.princeton.edu/java/data/leipzig/leipzig1m.txt
    FileReader fileReader = new FileReader("leipzig1m.txt");
    BufferedReader br = new BufferedReader(fileReader);
    Integer maxCount = 0;
    String hFreqWord = "";
    BinarySearchTree bst = new BinarySearchTree();
    

    while(br.ready())
    {
       String line = br.readLine();
       String[] words = line.split(" ");
 
       for(String word: words)
       {
         if(word.length() < 10) continue;

         Integer count = bst.get(word);
         if(count != null)
         {
           bst.put(word, count+1);
           if(count+1 > maxCount)
           {
             maxCount = count+1;
             hFreqWord = word;
           }
         }
         else {
           bst.put(word, 1);
         }
       } 
    }
    System.out.println(hFreqWord + " " + maxCount);
  }
}
