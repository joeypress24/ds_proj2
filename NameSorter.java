import java.util.Comparator;

public class NameSorter implements Comparator<City>
{
  public NameSorter() {
    // empty contructor
  }

  public int compare(City o1, City o2)
  {
    return o2.getName().compareTo(o1.getName());
  }
}
