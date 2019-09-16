package model;

import ds.*;

/**
 * This class is meant to represent the inventory used in the game. It'll change its modeled structure depending on the decisions of the user.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public class Inventory {

	//Constant values
	/**To be used when the inventory is working in the classic distribution.*/
	public static int CLASSIC = 0;
	
	/**To be used when the inventory is working in the by hotbars distribution.*/
	public static int HOTBARS = 1;
	
	/**The max number of slots that a normal inventory can have.*/
	public static int MAX_SLOTS = 36;
	
	//Relations

	/**The inventory represented by a HashTable, may be null depending on situation.*/
	private HashTable<Block> htInv;
	
	/**The inventory represented by a Queue, may be null depending on situation.*/
	private IQueue<Block> qInv;
	
	//Attributes
	/**The type this inventory is at the moment.*/
	private int type;
	
	//Methods
	
	/**
	 * Constructor method. Initialises an instance of this class and specifies the local variables to their default values.
	 */
	public Inventory() {
		type = CLASSIC;
		htInv = new HashTable<Block>(MAX_SLOTS);
	}
	
	
	/**
	 * Adds a new block to the inventory.
	 * @param obj The block to be added to the inventory.
	 */
	public void addBlock(Block obj) {
		if(type == CLASSIC) {
			if(htInv.isEmpty()) {
				htInv.add(obj);
			}else {
				Block s = htInv.search(obj.getKey());
				s.addQuantity(obj.getQuantity());
			}
		}else {
			addQInv(obj);
		}
	}
	
	public void addQInv(Block obj) {
		if(qInv.isEmpty()) {
			qInv.enqueue(obj);
		}else {
			try {
				while(qInv.front().getId() != obj.getId()) {
					Block e = qInv.dequeue();
					qInv.enqueue(e);
				}
			}catch(EmptyException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void changeType() throws EmptyException {
		if(type == CLASSIC) {
			type = HOTBARS;
			qInv = new Queue<Block>();
			for(Block b : htInv.getArr()) {
				addQInv(b);
			}
			htInv = null;
		}else {
			type = CLASSIC;
			htInv = new HashTable<Block>(MAX_SLOTS);
			while(!qInv.isEmpty()) {
				htInv.add(qInv.dequeue());
			}
		}
	}
	
	public void nextHotBar() throws EmptyException{
		Block b = qInv.dequeue();
		qInv.enqueue(b);
	}
	
	public int getInventoryType() {
		return type;
	}
	
	public HashTable<Block> getInventoryHT(){
		return htInv;
	}

	public IQueue<Block> getInventoryQ(){
		return qInv;
	}
	
}
