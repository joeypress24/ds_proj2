import java.util.Comparator;

public class NineteenSorter implements Comparator<City>
{
  public NineteenSorter() {
    // empty contructor
  }

  public int compare(City o1, City o2)
  {
    //return o1.getNineteen().compareTo(o2.getNineteen());
    return Integer.compare(o2.getNineteen(), o1.getNineteen());
  }
}
