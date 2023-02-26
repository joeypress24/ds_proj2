import java.util.*;

public class TestBottomUp {
  public static void main(String args[]) throws InterruptedException{
    int size = 99999999;
    Random rnd = new Random(2021);
    List<Integer> l = new ArrayList<Integer>();
    for(int i = 0; i < size; i++){
      int r = rnd.nextInt(1000);
      l.add(r);
    }
    //System.out.println("HERE1");
    Thread.sleep(10);
    //System.out.println("HERE2");
    long startTime = System.nanoTime();
    Heap<Integer> h = new Heap(new IntComp(),l);
    long endTime = System.nanoTime();
    long bu = endTime-startTime;
    //	System.out.println(bu);
    startTime = System.nanoTime();
    h = new Heap(new IntComp(),100000000);
    //System.out.println("HERE3");
    System.gc();
    for(int i = 0; i < size; i++){
      h.insert(l.get(i));
    }
    // System.out.println("cap: ");
    // h.printCapacity();
    endTime = System.nanoTime();
    long td = endTime-startTime;
    //System.out.println(td);
    System.out.println(td > bu);
  }
}
