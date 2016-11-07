package com.dice;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieceTest6 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		String[] args = {"1","1","2","3","3"};
		DiceGame game = new DiceGame(args);
		game.calculateTotal();
	}

}
