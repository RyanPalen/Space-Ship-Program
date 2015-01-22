package spaceShip;

import java.util.*;

public class CargoShip extends Ship {
	
	protected StarDate dateBuilt;  //the date object

	//constructor to fill the superclass and create date object
	public CargoShip (int a, String b, Scanner input){
		super (2, a, b);
		dateBuilt = new StarDate();
	}

	//runs the fillDate function in the StarDate object
	public void setDate(Scanner input){
		dateBuilt.fillDate(input, name);
	}

	//basic toString returning the toStrings from the super class and the StarDate object
	public String toString(){
		return super.toString() + "Built on " + dateBuilt.toString(1);
	}
	
	//specific toString for just the name, just the date in XX/XX/XX format, or just the date in XX:XX:XX format
	public String toString(int a){
		if (a == 1){
			return name;
		}
		else if (a == 2){
			return dateBuilt.toString(1);
		}
		else{
			return dateBuilt.toString(2);
		}
	}
}
