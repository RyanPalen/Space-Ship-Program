package spaceShip;

import java.io.*;      //text document stream
import java.util.*;    //Scanner

public class Actions {
	private int maxShip, shipChoice, capacity;
	private boolean validInput;
	private String[] shipName;
	private String shipNameStr;
	
	//constructor requiring max ship count and creates a blank String Array for the ship names
	public Actions (int a){
		maxShip = a;
		shipName = new String[maxShip];
	}
	
	//A simple method to get the ship class, requires the entire array and the numeric value of the array entry
	public int getShipClass(Object[] ships, int i){
		//calls the getClass function in the object class, returning 1-4
		if (ships[i].getClass() == ColonyShip.class){
			return 1;
		}
		else if (ships[i].getClass() == CargoShip.class){
			return 2;
		}
		else if (ships[i].getClass() == GunShip.class){
			return 3;
		}
		else if (ships[i].getClass() == BomberShip.class){
			return 4;
		}
		else{
			return 0;
		}
	}
	
	//a method to set a single entry's ship stats
	public void setShipStat(Object[] shipArr, Scanner input, int i){
		validInput = false;
		while (!validInput){
			//each loop, I create a new iteration of the input object and I set to null at each branch
			//done to resolve an issue with characters stuck in the cache
			input = new Scanner (System.in);
			System.out.print("\nShip number " + (i+1) + " is what type?\n1: Colony Ship\n2: Cargo Ship\n3: Gun Ship\n4: Bomb Ship\n\nChoice: ");
			//ship type with try/catch requiring an int
			try{
				shipChoice = input.nextInt();
				if (shipChoice < 1 || shipChoice > 4){
					System.out.println("Please input a number 1-4");
					input = null;
				}
				else{
					validInput = true;
					input = null;
				}
			}catch (InputMismatchException ex){
				input = null;
				System.out.println("Sorry, that is an invalid input. Please try again");
			}
		}
		
		//puts the ship choice through a switch statement 
		switch(shipChoice){
		case 1:
			validInput = false;
			
			//gets the ship name, checking to make sure the name hasn't already been used in the Object array
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nYou have chosen a Colony Ship. What is this vessel's name?\nName: ");
				shipName[i] = input.nextLine();
				validInput = true;
				for (int j = 0; j < i; j++){
					if (shipName[i].compareTo(shipName[j]) == 0){
						System.out.println("Please enter a unique name");
						validInput = false;
						continue;
					}
				}
			}
			input = null;
			validInput = false;
			
			//checks how many people the ship can hold
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nSo, how many people can " + shipName[i] +" transport?\nPersonel Capacity: ");
				
				//try catch for the int input
				try
				{
					capacity = input.nextInt();
					validInput = true;
				}catch (InputMismatchException ex){
					System.out.println("\nSorry, that is an invalid input. Please try again");
					input = null;
				}
			}
			
			//creates the ship with the capacity, name, and a scanner object
			shipArr[i] = new ColonyShip(capacity, shipName[i], input);
			
			//runs the setDate of the ColonyShip using casting
			((ColonyShip) shipArr[i]).setDate(input);
			break;
		
		//Same as case 1
		case 2:
			validInput = false;
			
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nYou have chosen a Cargo Ship. What is this vessel's name?\nName: ");
				shipName[i] = input.nextLine();
				validInput = true;
				for (int j = 0; j < i; j++){
					if (shipName[i].compareTo(shipName[j]) == 0){
						System.out.println("Please enter a unique name");
						validInput = false;
						continue;
					}
				}
			}
			input = null;
			validInput = false;
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nSo, how much cargo can " + shipName[i] +" hold?\nCargo Capacity (in tons): ");
				try
				{
					capacity = input.nextInt();
					validInput = true;
				}catch (InputMismatchException ex){
					System.out.println("\nSorry, that is an invalid input. Please try again");
					input = null;
				}
			}
			shipArr[i] = new CargoShip(capacity, shipName[i], input);
			((CargoShip) shipArr[i]).setDate(input);
			break;
			
		//Same as case 1
		case 3:
			validInput = false;
			
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nYou have chosen a Gun Ship. What is this vessel's name?\nName: ");
				shipName[i] = input.nextLine();
				validInput = true;
				for (int j = 0; j < i; j++){
					if (shipName[i].compareTo(shipName[j]) == 0){
						System.out.println("Please enter a unique name");
						validInput = false;
						continue;
					}
				}
			}
			input = null;
			validInput = false;
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nSo, how much ammunition can " + shipName[i] +" hold?\nAmmo Capacity: ");
				try
				{
					capacity = input.nextInt();
					validInput = true;
				}catch (InputMismatchException ex){
					System.out.println("\nSorry, that is an invalid input. Please try again");
					input = null;
				}
			}
			shipArr[i] = new GunShip(capacity, shipName[i], input);
			((GunShip) shipArr[i]).setDate(input);
			break;
		
		//Same as case 1
		case 4:
			validInput = false;
			
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nYou have chosen a Bomber Ship. What is this vessel's name?\nName: ");
				shipName[i] = input.nextLine();
				validInput = true;
				for (int j = 0; j < i; j++){
					if (shipName[i].compareTo(shipName[j]) == 0){
						System.out.println("Please enter a unique name");
						validInput = false;
						continue;
					}
				}
			}
			input = null;
			validInput = false;
			while (!validInput){
				input = new Scanner(System.in);
				System.out.print("\nSo, how many bombs can " + shipName[i] +" hold?\nBomb Capacity: ");
				try
				{
					capacity = input.nextInt();
					validInput = true;
				}catch (InputMismatchException ex){
					System.out.println("\nSorry, that is an invalid input. Please try again");
					input = null;
				}
			}
			shipArr[i] = new BomberShip(capacity, shipName[i], input);
			((BomberShip) shipArr[i]).setDate(input);
			break;
		default:
			System.out.print("This was an invalid selection...");
			break;
		}	
	}
	
	//fillUp method just calls the setShipStat for each iteration in the for loop
	//made setShipStat its own method because I needed the same function for the change ship
	public void fillUp(Object[] shipArr, Scanner input){
		for (int i = 0; i < maxShip; i++){
			this.setShipStat(shipArr, input, i);
		}
	}
	
	//our display
	public void displayShips(Object[] ships){
		System.out.println("\nList of Ships:\n");
		
		//prints out all of the ColonyShip classes first
		for (int i = 0; i < maxShip; i++){
			if (ships[i].getClass() == ColonyShip.class){
				
				//cast to get the Colony Ship object entry's toString method
				System.out.println(((ColonyShip) ships[i]).toString());
				System.out.println("----------------------------------");
			}
		}
		
		//same as above for CargoShip
		for (int i = 0; i < maxShip; i++){
			if (ships[i].getClass() == CargoShip.class){
				System.out.println(((CargoShip) ships[i]).toString());
				System.out.println("----------------------------------");
			}
		}
		
		//same as above for GunShip
		for (int i = 0; i < maxShip; i++){
			if (ships[i].getClass() == GunShip.class){
				System.out.println(((GunShip) ships[i]).toString());
				System.out.println("----------------------------------");
			}
		}
		
		//same as above for BomberShip
		for (int i = 0; i < maxShip; i++){
			if (ships[i].getClass() == BomberShip.class){
				System.out.println(((BomberShip) ships[i]).toString());
				System.out.println("----------------------------------");
			}
		}
	}
	
	//method to change a ship in the Object array
	//carries over the Ship array, the ship name typed in the main loop, the filename, the scanner object, and the FileWriter object
	public void changeShip(Object[] ships, String shipNameComp, String filename, Scanner input, FileWriter file){
		
		//used a for loop to compare the entry names with the string from the main loop
		for (int i = 0; i < maxShip; i++){
			if (this.getShipClass(ships, i) == 1){
				
				//string compare to check the name
				shipNameStr = ((ColonyShip) ships[i]).toString(1);  //the toString(1) designates the name of the toString only
				
				//if they are the same, try catch to open the file, and print out the new information to the txt document
				if (shipNameComp.compareTo(shipNameStr) == 0){
					try{
						file.close();
						file = new FileWriter(filename, true);
						file.write(((ColonyShip) ships[i]).getName() + " was changed to:\n");
						
						//deletes the entry in the Object array
						ships[i] = null;
						
						//runs the setShipStat method to input all of the required ship stats (name, type, capacity)
						//and create the new entry of the appropriate ship as well as fill in the Star Date of creation
						this.setShipStat(ships, input, i);
						
						//writes the appropriate toString based on the new return from getShipClass after the change of the ship stats
						switch(this.getShipClass(ships, i)){
							case 1:
								file.write(((ColonyShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								
								//flush to write it to the txt document
								file.flush();
								break;
							case 2:
								file.write(((CargoShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 3:
								file.write(((GunShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 4:
								file.write(((BomberShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
						}
						file.flush();
					}catch (IOException ex){
						System.out.println("Nope!");
					}
				}
			}
			
			//same as above for the CargoShip
			else if (ships[i].getClass() == CargoShip.class){
				shipNameStr = ((CargoShip) ships[i]).toString(1);
				if (shipNameComp.compareTo(shipNameStr) == 0){
					try{
						file.close();
						file = new FileWriter(filename, true);
						file.write(((CargoShip) ships[i]).getName() + " was changed to:\n");
						ships[i] = null;
						this.setShipStat(ships, input, i);
						switch(this.getShipClass(ships, i)){
							case 1:
								file.write(((ColonyShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 2:
								file.write(((CargoShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 3:
								file.write(((GunShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 4:
								file.write(((BomberShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
						}
						file.flush();
					}catch (IOException ex){
						System.out.println("Nope!");
					}
				}
			}
			//same as above for the GunShip
			else if (ships[i].getClass() == GunShip.class){
				shipNameStr = ((GunShip) ships[i]).toString(1);
				if (shipNameComp.compareTo(shipNameStr) == 0){
					try{
						file.close();
						file = new FileWriter(filename, true);
						file.write(((GunShip) ships[i]).getName() + " was changed to:\n");
						ships[i] = null;
						this.setShipStat(ships, input, i);
						switch(this.getShipClass(ships, i)){
							case 1:
								file.write(((ColonyShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 2:
								file.write(((CargoShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 3:
								file.write(((GunShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 4:
								file.write(((BomberShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
						}
					file.flush();
					}catch (IOException ex){
						System.out.println("Nope!");
					}
				}
			}
			//same as above for the BomberShip
			else if (ships[i].getClass() == BomberShip.class){
				shipNameStr = ((BomberShip) ships[i]).toString(1);
				if (shipNameComp.compareTo(shipNameStr) == 0){
					try{
						file.close();
						file = new FileWriter(filename, true);
						file.write(((BomberShip) ships[i]).getName() + " was changed to:\n");
						ships[i] = null;
						this.setShipStat(ships, input, i);
						switch(this.getShipClass(ships, i)){
							case 1:
								file.write(((ColonyShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 2:
								file.write(((CargoShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 3:
								file.write(((GunShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
							case 4:
								file.write(((BomberShip) ships[i]).toString());
								file.write("\n----------------------------------\n");
								file.flush();
								break;
						}
						file.flush();
					}catch (IOException ex){
						System.out.println("Nope!");
					}
				}
			}
		}
	}
	
	//writes the entire list in the correct order to the txt file
	public void writeText(Object[] ships, FileWriter file){
		try{
			
			//looks for all of the ColonyShip and writes them to the txt file
			file.write("\nList of Ships:\n\n");
			for (int i = 0; i < maxShip; i++){
				if (ships[i].getClass() == ColonyShip.class){
					file.write(((ColonyShip) ships[i]).toString());
					file.write("\n----------------------------------\n");
				}
			}
			//same as above for the Cargoship
			for (int i = 0; i < maxShip; i++){
				if (ships[i].getClass() == CargoShip.class){
					file.write(((CargoShip) ships[i]).toString());
					file.write("\n----------------------------------\n");
				}
			}
			//same as above for the GunShip
			for (int i = 0; i < maxShip; i++){
				if (ships[i].getClass() == GunShip.class){
					file.write(((GunShip) ships[i]).toString());
					file.write("\n----------------------------------\n");
				}
			}
			//same as above for the BomberShip
			for (int i = 0; i < maxShip; i++){
				if (ships[i].getClass() == BomberShip.class){
					file.write(((BomberShip) ships[i]).toString());
					file.write("\n----------------------------------\n");
				}
			}
		}catch(IOException ex){
			System.out.println("File does not exist or can't be created.");
		}
	}
}
