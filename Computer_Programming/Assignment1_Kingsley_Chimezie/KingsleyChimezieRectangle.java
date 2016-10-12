/**
*Kingsley Chimezie
*Software Development Level 5 C20054
*12/March/2014
*/

import BreezyGUI.*;
public class KingsleyChimezieRectangle
  {
	public static void main(String[] args)
	  {
		int l, w, p, a;   //Declaring local variables: l = length, w = width, p = perimeter, a = area

/*********************************************************************************************************************************************************/	
		asterisks();   //invoking method for asterisks line
		System.out.println();   //Inserts a blank line
			
			l = Console.readInt("Enter the length of a rectangle:	");   //Displays GUI for entering the length of a rectangle
			w = Console.readInt("Enter the Width of a rectangle:		");   //Displays GUI for entering the width of a rectangle
    		
			p = Perimeter(l, w);   //Invoking method for perimeter
			a = Area(l, w);   //Invoking method for area
		
		System.out.println();   //Inserts a blank line
/*********************************************************************************************************************************************************/		
		asterisks();   //Invoking method for asterisks line
		System.out.println();   //Inserts a blank line
			
			System.out.println("The perimeter of the rectangle is:	" + p);   //Displays answer for perimeter
		
		System.out.println();   //Inserts a blank line
/*********************************************************************************************************************************************************/		
		asterisks();   //Invoking method for asterisks line
		System.out.println();   //Inserts a blank line
			
			System.out.println("The area of the rectangle is:		" + a);   //Displays answer for Area
    		
		System.out.println();   //Inserts a blank line
		asterisks();   //invoking method for asterisks line
/*********************************************************************************************************************************************************/
	  }
	
	public static int Perimeter(int l, int w)   //method for calculating perimeter
	  {
    		int P;
		P = l + l + w + w; 
		return(P);
    	  }
    	
	public static int Area(int l, int w)   //method for calculating Area
	  {
		int a;
		a =  l * w;
		return(a);
	  }	
    
	public static void asterisks()   //method for asterisks
   	  {
    		int count; 
    		for(count = 1; count <=75; count++)   //Counting through the loop for 75 asterisks 
    			System.out.print("*");   //System prints out 75 asterisks
    	
    		System.out.println();   //Returns a new line after all asterisks
	  }
 }