package com.dream.ttt.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	public static final int ROOT = 3;
	private static Board theInstance = new Board();

	public static Board getInstance() {
		return theInstance;
	}

	private Cell[][] cells = new Cell[ROOT][ROOT];
	private List<Line> lines = new ArrayList<>();

	private Board() {
		buildCellAndHorizontalLine();
		buildVerticalLine();
		buildDiogonalLines();
	}

	private void buildDiogonalLines() {
		Line diogonalLine = new Line();
		Line invertedDiogonalLine = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			diogonalLine.addCell(cells[idx][idx]);
			invertedDiogonalLine.addCell(cells[idx][(ROOT - 1) - idx]);
		}
		lines.add(diogonalLine);
		lines.add(invertedDiogonalLine);
	}

	private void buildVerticalLine() {
		for (int col = 0; col < ROOT; col++) {
			Line aVerticalLine = new Line();
			for (int row = 0; row < ROOT; row++) {
				aVerticalLine.addCell(cells[row][col]);
			}
			lines.add(aVerticalLine);
		}
	}

	private void buildCellAndHorizontalLine() {
		for (int row = 0; row < ROOT; row++) {
			Line aHorizontalLine = new Line();
			for (int col = 0; col < ROOT; col++) {
				cells[row][col] = new Cell(row, col);
				aHorizontalLine.addCell(cells[row][col]);
			}
			lines.add(aHorizontalLine);
		}
	}

	public List<Line> getLines() {
		return lines;
	}

	public List<Cell> getCells() {
		List<Cell> ret = new ArrayList<>();

		Arrays.asList(cells).forEach(oneDimArray -> {
			ret.addAll(Arrays.asList(oneDimArray));
		});
		return ret;
	}

	public Position getCellPosition(Cell cell) {
		if (cell.getRow() == ROOT / 2 && cell.getCol() == ROOT / 2) {
			
			return Position.Center;
		} else if (cell.getRow() == cell.getCol() || cell.getRow() + cell.getCol() == ROOT - 1) {
			
			return Position.Coner;
		} else {
			return Position.Other;
		}
	}
}
