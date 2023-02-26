import java.util.Random;

public class TestHeap {
  public static void main(String args[]) {
    int size = Integer.parseInt(args[0]);
    Heap<Integer> h = new Heap(new IntComp());
    Random rnd = new Random(2021);
    for(int i = 0; i < size; i++){
      int r = rnd.nextInt(100);
      h.insert(r);
    }
    for(int i = 0; i < size; i++){
      System.out.println(h.removeMax());
    }
  }
}
