package com.dream.ttt.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDepositeStone {

	@Test
	void test() {
		Board board = Board.getInstance();
		StoneStatus turn = StoneStatus.Black;
		PlayStatus playStatus = PlayStatus.Playing;
		while (playStatus == PlayStatus.Playing) {
			playStatus = board.depositeStoneByRandom(turn);
			if (playStatus == PlayStatus.Win) {
				System.out.println(turn + " win");
				return;
			}
			turn = StoneStatus.switchTurn(turn);
		}
		System.out.println(playStatus);
		assert(playStatus == PlayStatus.WasDraw);
	}
}
