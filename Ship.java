package spaceShip;

public abstract class Ship {
	protected String name;
	protected int passengers;
	protected int capacity;
	protected int ammo;
	protected int bombs;
	
	//protected constructor which creates the ship based on the type chosen
	protected Ship(int a, int b, String c){
		name = c;
		if (a == 1){
			passengers = b;
			capacity = -1;
			ammo = -1;
			bombs = -1;
		}
		else if (a == 2){
			passengers = -1;
			capacity = b;
			ammo = -1;
			bombs = -1;
		}
		else if (a == 3){
			passengers = -1;
			capacity = -1;
			ammo = b;
			bombs = -1;
		}
		else if (a == 4){
			passengers = -1;
			capacity = -1;
			ammo = -1;
			bombs = b;
		}
	}
	
	//returns just the name
	public String getName(){
		return name;
	}
	
	//toString based on the ship type
	public String toString(){
		if (passengers != -1){
			return "Type: Passenger Ship\nName: " + name + "\nMax Passengers: " + passengers + "\n";
		}
		else if (capacity != -1){
			return "Type: Cargo Ship\nName: " + name + "\nMax Cargo Capacity: " + capacity + "\n";
		}
		else if (ammo != -1){
			return "Type: Gun Ship\nName: " + name + "\nMax Ammo: " + ammo + "\n";
		}
		else if (bombs != -1){
			return "Type: Bomb Ship\nName: " + name + "\nMax Bombs: " + bombs + "\n";
		}
		else
			return "Type: Unknown\nName: Unknown\nCapabilities: Unknown\n";
	}
}
