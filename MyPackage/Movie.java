package MyPackage;

import java.io.*;
import java.text.*;

public class Movie implements Serializable{
	  private int sku;
	  private int quantity;
	  private double price;
	  private String title = new String();
	  
	  DecimalFormat dfSKU = new DecimalFormat("#0000");
	  DecimalFormat dfPrice = new DecimalFormat("$#00.00");
	  

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
	    return (dfSKU.format(sku) + " " + quantity + " " + dfPrice.format(price) + " "  + title);
	  }
	  
	  public int getSKU()
	  {
		  return sku;
	  }
	  
	  public void printMovie()
	  {
		 System.out.println("SKU: "+ dfSKU.format(sku));
		 System.out.println("Quantity: "+ quantity);
		 System.out.println("Price: "+ dfPrice.format(price));
		 System.out.println("Title: "+ title);
	  }
}
