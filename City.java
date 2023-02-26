//import java.io.File;
import java.io.*; // includes java.io.File
import java.util.Scanner;
import java.io.IOException;
import java.util.*;

public class City {

  private String name;
  private String state;
  private int census;
  private int nineteen;
  public City(String name, String state, int census, int nineteen) {
    this.name = name;
    this.state = state;
    this.census = census;
    this.nineteen = nineteen;
  }

  public int getCensus() {
    return this.census;
  }

  public int getNineteen() {
    return this.nineteen;
  }

  public String getState() {
    return this.state;
  }

  public String getName() {
    return this.name;
  }

  public static ArrayList<City> Reader(String fname) throws FileNotFoundException
  {
    ArrayList<City> L = new ArrayList<City>();
    // read in data and save the data we need

    //System.out.println("Needed data: " + neededData);
    try{
      File f = new File(fname);
      Scanner scan = new Scanner(f);
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        // split the line by ","
        String[] split = line.split(",", 15);
        // check for the X field
        City c;
        if(split[2].equals("(X)"))
        {
          c = new City(split[0], split[1], Integer.parseInt("0"), Integer.parseInt(split[13]));
        //  split[2] = "0";
        }
        else
          c = new City(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[13]));

        L.add(c);

      }
      scan.close();
    }
    catch(Exception e){
      System.out.println("an error occurred while reading file");
    //  System.out.println("count: " + count);
      System.out.println(e);
    }

    return L;
  }


  public String toString()
  {
    return this.name + this.state;
  }
}
