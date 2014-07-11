// Authors: Scott Paladino & Tim Turner

// The inventory Class
//package proj1;


import java.util.*;

public class Inventory
{
  public static final int MAX_ITEMS   = 9999;
  
  // an inventory holds movies
  private ArrayList<Movie> inventory = new ArrayList<Movie>(10);

  public void addMovie(Scanner ui)
  {
    int movieSKU;
    int howMany;
    double howMuch;
    String movieTitle;

    System.out.println("enter the sku: ");
    movieSKU = ui.nextInt();

    System.out.println("Enter the quantity: ");
    howMany = ui.nextInt();

    System.out.println("Enter the price: ");
    howMuch = ui.nextDouble();
    ui.nextLine();

    System.out.println("Enter the title: ");
    movieTitle = ui.nextLine();

    Movie m = new Movie(movieSKU, howMany, howMuch, movieTitle);

    inventory.add(m);
  }

  public void displayInv()
  {
    for (int i = 0; i < inventory.size(); i++)
    {
      System.out.println(inventory.get(i).toString());
    }
  }
}
