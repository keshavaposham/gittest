package com.dice;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieceTestFail2 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		String[] args = {"1","2","3","a","8"};
		DiceGame game = new DiceGame(args);
		game.calculateTotal();
	}

}
