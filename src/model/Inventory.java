package model;

/**
 * This class is meant to represent the inventory used in the game. It'll change its modeled structure depending on the desitions of the user.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public class Inventory {

	//Constant values
	/**To be used when the inventory is working in the classic distribution.*/
	public static int CLASSIC = 0;
	
	/**To be used when the inventory is working in the by hotbars distribution.*/
	public static int HOTBARS = 1;
	
	//Relations
	//TODO: Add relations with data structures. 
	
	//Attributes
	/**The type this inventory is at the moment.*/
	private int type;
	
	//Methods
	
	/**
	 * Constructor method. Initializes an instance of this class and specifies the local variables to their default values.
	 */
	public Inventory() {
		type = CLASSIC;
	}
	
	public void addBlock(Block obj) {
		if(type == CLASSIC) {
			//TODO Add type adding logic.
		}else {
			//TODO Add type adding logic.			
		}
	}
	
	public void changeType() {
		if(type == CLASSIC) {
			type = HOTBARS;
			//TODO add type changing logic.
		}else {
			type = CLASSIC;
			//TODO add type changing logic.
		}
	}
	
	public int getInventoryType() {
		return type;
	}
	
	public HashTable<Integer, Block> getInventoryHT(){
		//TODO Implement data structure.
	}
	
	public Queue<Block> getInventoryQ(){
		//TODO Implement data structure.
	}
	
}
