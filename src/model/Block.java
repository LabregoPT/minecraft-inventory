package model;

/**
 * Class meant to represent each of the usable blocks in the GUI of the game.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public class Block {
	
	//Constant values
	/**Max amount of blocks that can form a group.*/
	public static int MAX_QUANTITY = 64;
	
	//Attributes
	/**The numerical ID of this block.*/
	private int id;
	
	/**The url that points to the image representing this block.*/
	private String imgUrl;
	
	//Methods
	/**
	 * Creates a new block to use in the GUI with the given values as its attributes.
	 * @param i The unique numerical ID of this block.
	 * @param url The String that points to the image representing this block.
	 */
	public Block(int i, String url) {
		id = i;
		imgUrl = url;
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

}
