public class PriorityQueue
{
  private Integer[] pq;
  private int n; 

  PriorityQueue(int capacity)
  {
    this.pq = new Integer[capacity+1];
  }

  public void insert(int x)
  {
    this.pq[++n] = x;
    swim(n);

  }

  public Integer delMax()
  {
    int maxElement = this.pq[1];
    exch(1, n--);
    sink(1);
    this.pq[n+1] = null; // loitering
    return maxElement; 
  }
  
  public boolean isEmpty()
  {
    return this.n == 0;
  }
  
  public Integer size()
  {
    return this.n;
  }

  private void swim(int k)
  {
     while(k > 1 && this.pq[k/2] < this.pq[k])
     {
       this.exch(k, k/2);
       k = k/2;
     }
  }
 
  private void sink(int k)
  {
    while(2*k <= n)
    {
       int j = 2*k;
       if(j < n && this.pq[j] < this.pq[j+1]) j++;
       if(this.pq[k] >= this.pq[j]) break;
       exch(k, j);
       k = j;
    }
  }  


  private void exch(int i, int j)
  {
    int temp = this.pq[i];
    this.pq[i] = this.pq[j];
    this.pq[j] = temp;
  }

  public static void main(String[] args)
  {
    PriorityQueue pq = new PriorityQueue(10);
    pq.insert(5);
    pq.insert(11);
    pq.insert(7);
 
    assert pq.delMax() == 11;
    assert pq.size() == 2;

    pq.insert(15);
    pq.insert(11);
    pq.insert(19);

    assert pq.delMax() == 19;

  }
}
