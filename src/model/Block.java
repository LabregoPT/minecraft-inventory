package model;

import ds.Hashable;

/**
 * Class meant to represent each of the usable blocks in the GUI of the game.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public class Block implements Hashable {
	
	//Constant values
	/**Max amount of blocks that can form a group.*/
	public static int MAX_QUANTITY = 64;
	
	//Attributes
	/**The numerical ID of this block.*/
	private int id;
	
	/**The url that points to the image representing this block.*/
	private String imgUrl;
	
	/**The quantity of this block.*/
	private int quantity;
	
	//Methods
	/**
	 * Creates a new block to use in the GUI with the given values as its attributes.
	 * @param i The unique numerical ID of this block.
	 * @param url The String that points to the image representing this block.
	 * @param q The quantity of this block.
	 */
	public Block(int i, String url, int q) {
		id = i;
		imgUrl = url;
		quantity = q;
	}
	
	/**
	 * Returns the unique numerical ID of this block.
	 * @return The unique numerical ID of this block.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the URL of the location of the image represented by this block.
	 * @return the URL of the location of the image represented by this block.
	 */
	public String getURL() {
		return imgUrl;
	}

	@Override
	public int getKey() {
		return getId();
	}

	/**
	 * Returns the quantity of blocks that there are.
	 * @return the quantity of blocks that there are.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Adds a given quantity to the amount of blocks that there already are.
	 * @param qtty The given amount to be added.
	 */
	public void addQuantity(int qtty) {
		quantity = qtty;
		if(quantity > MAX_QUANTITY) {
			quantity = MAX_QUANTITY;
		}
	}

}
