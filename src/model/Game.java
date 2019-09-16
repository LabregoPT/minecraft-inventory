package model;
import java.util.*;

import ds.EmptyException;

/**
 * Main class in the application. Will work as a bridge between the GUI and the Model
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public class Game {

	public static int USED_BLOCKS = 15;
	
	private List<Block> blockdb;
	
	private Inventory inv;
	
	public Game() {
		inv = new Inventory();
		createBlockDb();
	}
	
	private void createBlockDb() {
		for(int i = 0; i<USED_BLOCKS;i++) {
			Block c = new Block(i+1, "imgs/blocks/"+(i+1)+".png", 0);
			blockdb.add(c);
		}
	}

	public void addBlock(int index, int qtty) {
		Block c = new Block(blockdb.get(index).getId(), blockdb.get(index).getURL(), qtty);
		inv.addBlock(c);
	}
	
	public void changeInv() {
		try {
			inv.changeType();
		} catch (EmptyException e) {
			e.printStackTrace();
		}
	}
	
	public void nextHB() {
		try {
			inv.nextHotBar();
		} catch (EmptyException e) {
			e.printStackTrace();
		}
	}
	
	public List<Block> getBlockDB(){
		return blockdb;
	}
	
}
