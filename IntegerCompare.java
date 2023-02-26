import java.util.Comparator;

public class IntegerCompare implements Comparator<Integer>
{
  public IntegerCompare() {
    // empty contructor
  }

  public int compare(Integer o1, Integer o2)
  {
    return o1.compareTo(o2);
  }
}
