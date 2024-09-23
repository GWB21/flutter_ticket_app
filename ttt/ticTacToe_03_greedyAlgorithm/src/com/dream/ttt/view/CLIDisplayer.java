package com.dream.ttt.view;

import com.dream.ttt.model.Board;
import com.dream.ttt.model.Cell;

public class CLIDisplayer {
	public static void display(Board board) {
		System.out.println(DisplayChar.buildTopLine(Board.ROOT));
		Cell[][] cells = board.getCellArray();
		for (int i = 0; i < Board.ROOT; i++) {
			Cell[] row = cells[i];
			System.out.println(DisplayChar.buildDataLine(row));
			if (i < Board.ROOT - 1)
				System.out.println(DisplayChar.buildMiddleLine(Board.ROOT));
			else
				System.out.println(DisplayChar.buildButtomLine(Board.ROOT));
		}
	}
}
