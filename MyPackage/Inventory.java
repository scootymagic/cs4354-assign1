package MyPackage;

import java.io.*;
import java.util.*;

public class Inventory implements Serializable {
	
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
	  
	  public void removeMovie(Scanner ui)
	  {
		  boolean itemFoundFlag = false;  // used for sentinel controlled loop
		  int removeSKU;               // holds the SKU that the user wants to delete
		  int itemIndex = 0;
		  
		 System.out.println("Enter SKU of item to remove: ");
		 removeSKU = ui.nextInt();
		 
		 while (itemIndex < inventory.size() && itemFoundFlag == false)
		  {
		    if (inventory.get(itemIndex).getSKU() == removeSKU)
		    {
		      // we found a match, so set the sentinel.  The itemIndex now holds
		      // the position of the found item
		      itemFoundFlag = true;
		    }
		    else
		    {
		      // keep looking!
		      itemIndex++;
		    }
		  }
		 
		 if (itemFoundFlag)
		  {
		    // delete the item from the inventory by replacing it with the last element
		    inventory.remove(itemIndex);
		    
		    
		    System.out.println("Removed item with sku:  " + removeSKU);     
		  }
		  else
		  {
		    // let the user know the item was not found
		    System.out.println("No item found with this SKU.");
		  }
	  }
	  
	  public void getInfo(Scanner ui)
	  {
		  boolean itemFoundFlag = false;  // used for sentinel controlled loop
		  int showSKU;               // holds the SKU that the user wants to delete
		  int itemIndex = 0;
		  
		 System.out.println("Enter SKU of item to display: ");
		 showSKU = ui.nextInt();
		 
		 while (itemIndex < inventory.size() && itemFoundFlag == false)
		  {
		    if (inventory.get(itemIndex).getSKU() == showSKU)
		    {
		      // we found a match, so set the sentinel.  The itemIndex now holds
		      // the position of the found item
		      itemFoundFlag = true;
		    }
		    else
		    {
		      // keep looking!
		      itemIndex++;
		    }
		  }
		 
		 if (itemFoundFlag)
		  {
		    //call function to display the movie
		    inventory.get(itemIndex).printMovie();
		         
		  }
		  else
		  {
		    // let the user know the item was not found
		    System.out.println("No item found with this SKU.");
		  }
	  }
	  
	  public void writeFile(){
		  
		  try{
		    	FileOutputStream fos = new FileOutputStream("InventoryFile");
		    	ObjectOutputStream oos = new ObjectOutputStream(fos);
		    	

		    	oos.writeObject(inventory);
		    	
		    	fos.close();
		    }
		  catch (IOException e){
			  System.out.println("Problem with file output");
		  }
		 
	  }
	  
	  public void readFile(){
		  
		  try{
			  FileInputStream fis = new FileInputStream("InventoryFile");
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  
			  ArrayList<Movie> inventory = (ArrayList<Movie>)ois.readObject();
			  fis.close();
		  }
		  catch(IOException e)
		  {
			  System.out.println("Problem with file input");
		  }
		  catch(ClassNotFoundException e)
		  {
			  System.out.println("Class not found on input from file");
		  }
	  }
}
