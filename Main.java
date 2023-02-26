import java.util.ArrayList;

public class Main {

  public static void main(String[] args)
  {
    if(args.length != 2)
    {
      System.out.println("not enough args");
      System.exit(0);
    }
    String check = args[0];
    if(!check.equals("-c") && !check.equals("-n") && !check.equals("-19"))
    {
      throw new IllegalArgumentException();
    }

    ArrayList<City> L = null;
    try{
      L = City.Reader(args[1]); // fill the arraylist with cities
    }
    catch(Exception e)
    {
      System.out.println("file not found");
      System.exit(0);
    }

    // create the heap and fill it
    Heap<City> h = null;
    if(args[0].equals("-c")) // use 2010 census data
    {
    //  System.out.println("init. with -c comparator");
      CensusSorter c = new CensusSorter();
      h = new Heap<City>(c, L);
    }
    else if(args[0].equals("-n")) // use city name
    {
    //  System.out.println("init. with -n comparator");
      NameSorter c = new NameSorter();
      h = new Heap<City>(c, L);
    }
    else if(args[0].equals("-19"))
    {
    //  System.out.println("init. with -19 comparator");
      NineteenSorter c = new NineteenSorter();
      h = new Heap<City>(c, L);
    }
    // at this point h is a heapified heap

    ArrayList<City> c = h.sort();
    for(City x: c){
        System.out.println(x.getName()+" "+x.getCensus() +" "+x.getNineteen());
    }
  }
}
