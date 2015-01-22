package spaceShip;

import java.util.*;

public class StarDate {
	private int year;
	private int month;
	private int date;
	private int count;
	
	//blank constructor
	public StarDate(){
		
	}
	
	//constructor with filled in fields
	public StarDate(int a, int b, int c){
		date = a;
		month = b;
		year = c;
	}
	
	//method to fill in all of the fields
	public void fillDate(Scanner input, String shipName){
		boolean validInput = false;
		count = 0;
		while (!validInput){
			input = new Scanner(System.in);
			try{
				//uses a counter to determine what has been filled in already, in case of mistype
				//the catch will continue it on through the loop, but the count determines what if to go to first
				//if you put in the date properly and then mess up the month, it doesn't ask the date again
				if (count == 0){
					System.out.print("What is the Star Date which the " + shipName + " was created?\nDate: ");
					date = input.nextInt();
					count++;
					input = null;
					input = new Scanner(System.in);
				}
				if (count == 1){
					System.out.print("Month: ");
					month = input.nextInt();
					count++;
					input = null;
					input = new Scanner(System.in);
				}
				if (count == 2){
					System.out.print("Year: ");
					year = input.nextInt();
					input = null;
					validInput = true;
				}
			}catch (InputMismatchException ex){
				System.out.println("Invalid entry");
			}
		}
	}
	
	//setters for date, month, and year
	public void setDate (int a){
		date = a;
	}
	
	public void setMonth (int a){
		month = a;
	}
	
	public void setYear (int a){
		year = a;
	}
	
	//getters for date, month, and year
	public int getDate (){
		return date;
	}
	
	public int getMonth (){
		return month;
	}
	
	public int getYear (){
		return year;
	}
	
	//toString with 3 options
	public String toString(int a){
		//returns in XX/XX/XX format
		if (a == 1){
			return "StarDate: " + date + "/" + month + "/" + year;
		}
		//returns in XX:XX:XX format
		else if (a == 2){
			return date + ":" + month + ":" + year;
		}
		//returns unknown if no number specified
		else{
			return "StarDate unknown";
		}
	}
}
