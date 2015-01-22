package spaceShip;

import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = null;
		int maxShip = 0, shipChoice = 0;
		String choice;
		String filename = "log.txt";
		
		//initialized the FileWriter object
		FileWriter file = null;
		
		//try catch to open the file
		try {
			file = new FileWriter(filename, false);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.out.println("Nooooo!!!!!");
		}
		
		//number of ships with try catch and bad input retry loop
		boolean validInput = false;
		while (!validInput){
			input = new Scanner(System.in);
			System.out.print("How many ships are we creating (1-10): ");
			try{
				maxShip = input.nextInt();
				if (maxShip > 10 || maxShip < 0){
					System.out.println("Please choose a number between 1 and 10");
					input = null;
				}
				else if (maxShip == 0){
					System.out.println("No Ships chosen, good bye!");
					input.close();
					System.exit(0);
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
		
		//creates the Action object and the ship array
		Actions action = new Actions(maxShip);
		Object []shipArr = new Object[maxShip];
		
		//runs the fillUp method and the write text method afterwards
		action.fillUp(shipArr, input);
		action.writeText(shipArr, file);
		
		//try catch to flush the FileStream
		try{
			file.flush();
		}catch (IOException ex){
			System.out.println("Nope!");
		}
		
		//displays and asks the user if they want to change any of the ships
		boolean change = true;
		while (change){
			action.displayShips(shipArr);
			validInput = false;
			while (!validInput){
				input = new Scanner(System.in);
				System.out.println("\nWould you like to change any of the ships?\nYes or No: ");
				choice = input.nextLine().toLowerCase();
				
				if (choice.compareTo("yes") == 0){
					validInput = true;
					continue;
				}
				else if (choice.compareTo("no") == 0){
					System.out.println("Thank you for playing! Goodbye!");
					try{
						file.close();
					}catch (IOException ex){
						System.out.println("Nope!");
					}
					input.close();
					System.exit(0);
				}
				else{
					System.out.println("Invalid Input. Please answer 'yes' or 'no'");
				}
				
			}
			
			//asks which ship to return
			validInput = false;
			while (!validInput){
				input = new Scanner(System.in);
				System.out.println("\nWhich ship would you like to change?");
				choice = input.nextLine();
				
				//sends the inputted name into the changeShip method
				action.changeShip(shipArr, choice, filename, input, file);
				validInput = true;
				
				//try catch to close the file
				try{
					file.close();
				}catch (IOException ex){
					System.out.println("Nope!");
				}
			}
		}
	}
}
