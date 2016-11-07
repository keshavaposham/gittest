package com.dice;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieceTest8 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		String[] args = {"1","2","3","4","5"};
		DiceGame game = new DiceGame(args);
		game.calculateTotal();
	}

}
