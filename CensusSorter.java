import java.util.Comparator;

public class CensusSorter implements Comparator<City>
{
  public CensusSorter() {
    // empty contructor
  }

  public int compare(City o1, City o2)
  {
    //return o1.getCensus().compareTo(o2.getCensus());
    return Integer.compare(o2.getCensus(), o1.getCensus());
  }
}
