package com.dream.ttt.model;

import org.junit.jupiter.api.Test;

class TestBoardConstruct {
	@Test
	void testBoardConstruct() {
		Board board = Board.getInstance();
		// 8개의 줄이 있어야 함
		assert (board.getLines().size() == Board.ROOT * 2 + 2);
		// 각 줄에는 3개의 칸이 있어야 함
		board.getLines().forEach(line -> {
			assert (line.getCells().size() == Board.ROOT);
		});
		board.getCells().forEach(cell -> {
			int lineSize = cell.getLines().size();
			if (lineSize == 2) {
				/*
				// 외곽
				assert (cell.getRow() == 0 && cell.getCol() == 1
						|| cell.getRow() == 1 && (cell.getCol() == 0 || cell.getCol() == 2)
						|| cell.getRow() == 2 && cell.getCol() == 1);
				*/
				assert (board.getCellPosition(cell) == Position.Other);
			} else if (lineSize == 3) {
				assert (board.getCellPosition(cell) == Position.Coner);
			} else if (lineSize == 4) {
				assert (board.getCellPosition(cell) == Position.Center);
			}
		});
	}

}
