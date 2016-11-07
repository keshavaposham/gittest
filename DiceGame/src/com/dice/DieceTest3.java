package com.dice;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieceTest3 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		String[] args = {"1","2","2","2","4"};
		DiceGame game = new DiceGame(args);
		game.calculateTotal();
	}

}
