// Authors: Scott Paladino & Tim Turner
// The Movie class
//package proj1;

import java.util.*;

public class Movie
{
  private int sku;
  private int quantity;
  private double price;
  private String title = new String();

  // to initialize a movie
  Movie(int s, int q, double p, String t)
  {
    this.sku = s;
    this.quantity = q;
    this.price = p;
    this.title = t;
  }

  public String toString()
  {
    return (sku + " " + quantity + " " + price + " "  + title);
  }
}
