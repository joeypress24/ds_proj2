import java.util.*;
import java.util.Comparator;
import java.util.Collections;

public class Heap<T> {

// private variables
  private ArrayList<T> h;
  private Comparator c;
  private int capacity;

// debugging method
  public int getCap()
  {
    return this.capacity;
  }

  // public constructors
  public Heap(java.util.Comparator c)
  { // constructor for empty heap, array size is 1
    this.capacity = 0;
    this.c = c;
    h = new ArrayList<T>();
    h.add(0, null);
  }

  public Heap(java.util.Comparator c, int i) {
    this.c = c;
    this.capacity = i;
    h = new ArrayList<T>();
    h.add(0, null);
  }

  public Heap(java.util.Comparator c, List<T> L) {
    this.c = c;

    h = new ArrayList<T>();
    for(T temp : L) // f or each
    {
      h.add(temp);
      //copy data
    }
    this.capacity = L.size();
    h.add(0, null);
    heapify();
  }

  private void heapify()
  {
    // maybe add a null element at 0
    for(int i = this.capacity; i > 0; i--)
    {
      bubbleDown(i);
    }
  }

  private void bubbleDown(int index)
  {

    if(2*index > this.capacity) // no children, return
      return;
    else if(2*index == capacity) // only have left child, don't check right child
    {
      if(c.compare(h.get(index), h.get(2*index)) < 0) // compare with left child
      {
        Collections.swap(h, index, index*2);
        bubbleDown(2*index);
        // swap them (write fxn)
      }
    }
    else // two children, check both and swap larger, then call bubbledown on that location
    { // if I uncommend these lines it sorts the heap correctly but breaks other things :/
      
      // if(c.compare(h.get(index), h.get(2*index)) == 0 || c.compare(h.get(index), h.get(2*index+1)) == 0) // if either child is same as parent
      // {
      //   if(c.compare(h.get(index), h.get(2*index)) == 0) // if left child is the same as parent
      //   {
      //     Collections.swap(h, index, index*2);
      //     bubbleDown(index*2);
      //   }
      //   else if(c.compare(h.get(index), h.get(2*index+1)) == 0) // if right child is same as parent
      //   {
      //     Collections.swap(h, index, index*2+1);
      //     bubbleDown(index*2+1);
      //   }
      // }

      if(c.compare(h.get(index), h.get(2*index)) < 0 || c.compare(h.get(index), h.get(index*2+1)) < 0) // if either child is larger than parent
      {
        if(c.compare(h.get(index*2), h.get(index*2+1)) > 0) // check the children against eachother
        {
          Collections.swap(h, index, index*2);
          bubbleDown(index*2);
        }
        else // if left is not smaller, the right must be
        {
          Collections.swap(h, index, index*2+1);
          bubbleDown(index*2+1);
        }
      }
      else if(c.compare(h.get(index*2), h.get(index)) < 0 && c.compare(h.get(index*2+1), h.get(index)) > 0)
        return; // this means that it's a good node

    }
  }


// Destroys the heap, but returns an ArrayList of the elements sorted in the order described in the Comparator.
  public ArrayList sort()
  {
    // while heap has stuff in it, removeMax(), swap with last, reduce capacity, bubbledown from root
    //ArrayList avoid making another arraylist for now
    ArrayList<T> n = new ArrayList<T>();

    while(h.size() != 1) // if not work try comparing capacity
    {
      T tempCity = removeMax();
      n.add(tempCity);
    }
    h = n;
    return n;
  }

/** // previous heapify attempt
  public void insert(T element) {

    this.capacity++; // increase the capacity, accounting for new element

    // put element in next free space, bubbleUp
    int i = 0;
    for(T temp : h)
    {
      i++;
      if(temp == null && i!=1)
      {
          break;
      }
    }

    h.add(i, element);

    //System.out.println("before insert: " + h);
    //heapify();
    bubbleUp(i);

  } */

  public void insert(T element) {

    // this.capacity++; // increase the capacity, accounting for new element


    h.add(this.h.size(), element); // add to the back of the list
    if(h.size() > this.capacity)
    {
      this.capacity++; // increase the capacity, accounting for new element
    }

    //heapify();
    bubbleUp(this.h.size()-1);

  }

  public void bubbleUp(int index)
  {
    int parent = (index)/2; // first parent is half of current index
    while(parent >= 1)
    {
      if(c.compare(h.get(parent), h.get(index)) < 0)
      {
        Collections.swap(h, parent, index);
        index = parent;
        parent = (parent)/2; // move to the next parent
      }
      else
      {
        break;
      }

    }
  }

  public T peekMax()
  {
    return (T)h.get(1);
  }

  public T removeMax()
  {
    // swap index capacity and index 1
    // reduce capacity by 1
    // bubble down from index 1
    Collections.swap(h, 1, capacity);
    T temp = h.get(capacity);
    h.remove(capacity); // remove the element & sub capacity
    capacity--;
  //  System.out.println("after first swap in removemax: " + h);
    bubbleDown(1);
    return temp;
  }

  public String toString()
  {
    return h.toString();
  }

// debugging main
/**
  public static void main(String[] args)
  {
    ArrayList<Integer> L = new ArrayList<Integer>();
    L.add(3);
    L.add(5);
    L.add(6);
    L.add(15);
    L.add(2);
    L.add(5);
    L.add(40);
    L.add(22);

    IntegerCompare c = new IntegerCompare();
    Heap temp = new Heap(c, L);
    System.out.println("after heapify(): " + temp);

    temp.insert(60);
    temp.insert(64);
    temp.insert(20);

    System.out.println("after insert: " + temp);

    System.out.println("peak max: " + temp.peekMax());

    System.out.println("after peek: " + temp);

    temp.removeMax();
    temp.removeMax();
    temp.removeMax();
    System.out.println("after removeMax: " + temp);

    temp.sort();
    System.out.println("after sort: " + temp);

  }
  */
}
