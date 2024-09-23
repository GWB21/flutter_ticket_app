package com.dream.ttt.model;

import org.junit.jupiter.api.Test;

import com.dream.ttt.view.CLIDisplayer;

class TestDepositeStone {

	@Test
	void test() {
		Board board = Board.getInstance();
		StoneStatus turn = StoneStatus.Black;
		PlayStatus playStatus = PlayStatus.Playing;
		while (playStatus == PlayStatus.Playing) {
			if (turn == StoneStatus.Black)
				//playStatus = board.depositeStoneByRandom(turn);
				playStatus = board.depositeStoneByGreedyAlgorithm(turn);
			else
				playStatus = board.depositeStoneByGreedyAlgorithm(turn);
			CLIDisplayer.display(board);
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
