package MyPackage;

import java.util.*;

public class Driver {
	
	  public static final int ADD_ITEM    = 1;
	  public static final int REM_ITEM    = 2;
	  public static final int GET_INFO    = 3;
	  public static final int SHOW_INV    = 4;
	  public static final int QUIT_PROG   = 5;
	  
	  public static void main(String[] args)
	  {
	    // will hold the store movie inventory
	    Inventory myStore = new Inventory();

	    Scanner userInput = new Scanner(System.in);  // for keyboard input
	    
	    int choice;  // holds the user's menu choice
	    
	    //myStore.readFile();

	    // the menu system
	    do
	    {
	      System.out.println();
	      System.out.println("Video Store Inventory Menu");
	      System.out.println("--------------------------");
	      System.out.println("1.  Add Movie");
	      System.out.println("2.  Remove Movie");
	      System.out.println("3.  Show Movie");
	      System.out.println("4.  Show Inventory");
	      System.out.println("5.  Quit");
	      System.out.println();
	      System.out.println("Enter your choice:  ");

	      // gets the menu choice from the user
	      choice = userInput.nextInt();

	      switch (choice)
	      {
	        case ADD_ITEM:
	          myStore.addMovie(userInput);
	          break;
	        case REM_ITEM:
	          myStore.removeMovie(userInput);
	          break;
	        case GET_INFO:
	          myStore.getInfo(userInput);
	          break;
	        case SHOW_INV:
	          myStore.displayInv();
	          break;
	        case QUIT_PROG:
	          break;
	        default:
	          System.out.println("Invalid choice, try again!");
	      }

	    }
	    while (choice != QUIT_PROG);
	    
	    myStore.writeFile();

	    // exit the program
	    System.out.println("Goodbye!");
	  }
}
