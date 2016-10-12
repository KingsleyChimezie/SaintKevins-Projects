/**
*Kingsley Chimezie
*Software Development Level 5 C20054
*30/April/2014
*/

import java.util.*;
import java.io.*;
import BreezyGUI.*;

class Vehicle implements Serializable  //Beginning of class Vehicle
 {  
	static Vehicle[] VehicleList = new Vehicle [100];
	static int NumberVehicles = 0;
		
		String manufacturer;
		String model;
		String colour;
		String registration;
		int price;
		
   	//This method is the constructor for Vehicle
  	 public Vehicle (String manufacturer, String model, String colour, String registration, int price)
	  {
		this.manufacturer = manufacturer;
		this.model = model;
		this.colour = colour;
		this.registration = registration;
		this.price = price;	
	  } 
   
	
  	 //This method will add a new vehicle into the array of vehicles & keeps a tab of all the vehicles.
  	 public static void AddVehicle (String manufacturer, String model, String colour, String registration, int price)
	  {
   		VehicleList[NumberVehicles] = new Vehicle (manufacturer, model, colour, registration, price);
		NumberVehicles = NumberVehicles + 1;
	  }
	 

	//This method will print the GUI input values for manufacturer, model, colour, registration, price.
	public void print()
	{
		System.out.println();

			System.out.println( " | Make: " + this.manufacturer + " | Model: " + this.model + " | Colour: " + this.colour + " | Reg: " + this.registration + " | EUR: "+ this.price + " |");

		System.out.println();
	}


	 //This method will print the list of vehicles in the database within a certain amount.
	 public static void printlist(int price)
	  {
	    if (NumberVehicles > 0)
	      for (int i = 0; i < NumberVehicles; i = i + 1)
	        {
		 if ((price == 0) || (VehicleList[i].price <= price))
		  {
			VehicleList[i].print();
		  }
	        }

	  }
 

	//This method writes array of vehicles objects to a binary file	
	public static void writetofile() {
		String x = "KingsleyChimezieGarage.bin";
		try {
			ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(x));
			for (int i=0; i  < NumberVehicles; ++i){
				os.writeObject(VehicleList[i]);
				os.flush();
			}
			os.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}

	}


	//This method reads in vehicle objects from the binary file
	public static void readinfile() {
		String x = "KingsleyChimezieGarage.bin";
		try {
			ObjectInputStream is = new ObjectInputStream( new FileInputStream(x));
			while ((VehicleList[NumberVehicles] = (Vehicle) is.readObject()) != null) {
				NumberVehicles = NumberVehicles + 1;
			}
			is.close();	
		}
		catch (EOFException e) {
		}
		catch (FileNotFoundException e) {
			System.out.println();
			System.out.println("** Note: no input file found. **");
		}
		catch (Exception e) {
			System.out.println("... Exception occurred!");
			e.printStackTrace();
		} 
	}


}   //End of class Vehicle


//**********************************************************************************************************************


class KingsleyChimezieGarage
 {


	public static void main(String[] args)
	 {
		Vehicle.readinfile(); //read all inputs GUI inputs.
		
		//assigning variables.
		char cmd;
		String manufacturer, model, colour, registration; 
		int price;
		
		do
		 {
			asterisks();
			
				cmd = BreezyGUI.Console.readChar("For instructions, please enter '!': ");
			
			asterisks();
			 
			if (cmd == '!')
			 {
				System.out.println(); 
				 
					System.out.println("Select a letter to prompt your desired command:");
				 	
				System.out.println();
				 	
					System.out.println("	A - Add a new vehicle");
					System.out.println("	L - List all vehicles");
				 	System.out.println("	S - Search for a vehicle under a specific price");
				 	System.out.println("	E - Exit");
				 
				System.out.println();
			  }
			 
			 else if ((cmd == 'A') || (cmd == 'a'))  //calling the method to add a vehicles details.
			  {
				System.out.println();
				
				System.out.println("Enter the vehicles details");

				System.out.println(); 
				 
				 	manufacturer = BreezyGUI.Console.readLine("	Manufacturer:	");
				 	model = BreezyGUI.Console.readLine("	Model:		");
				 	colour = BreezyGUI.Console.readLine("	Colour:		");
				 	registration = BreezyGUI.Console.readLine("	Registration:	");
				 	price = BreezyGUI.Console.readInt("	Price:		");
				 	Vehicle.AddVehicle(manufacturer, model, colour, registration, price);
				 
				System.out.println(); 
			  }
			 

			 else if ((cmd == 'L') || (cmd == 'l')) //calling the method to list all the vehicles.
			  {
				System.out.println(); 
				 
				 	System.out.println("Vehicles in stock: ");
					Vehicle.printlist(0);

				System.out.println(); 
			  }

			 
			 else if ((cmd == 'S') || (cmd == 's')) //calling the method to list all vehicles that cost less than a specific price.
			  {
				System.out.println(); 
				 
					price = BreezyGUI.Console.readInt("Enter max price [EUR]: ");
					Vehicle.printlist(price);
				 
				System.out.println(); 
			  }
		 }
		
		while
			((cmd != 'E') & (cmd != 'e')); //Calling the method exit the program

			System.out.println(); 
			
				System.out.println("Thank you, goodbye!");
			
			System.out.println(); 
			asterisks();
			
			Vehicle.writetofile();	//Writes all GUI inputs to the file after exit
	 }
	
	//This method will create a horizontal line of 80 asterisks
 	public static void asterisks()
 	 {
 		int count; 
 		for(count = 1; count <=80; count++) //Counting through the loop for 80 underscores 
   		System.out.print("_"); //System prints out 80 underscores
   	
 		System.out.println(); //Returns a new line after printing the line of underscores
 	 }
 
 } //End of class KingsleyChimezieGarage