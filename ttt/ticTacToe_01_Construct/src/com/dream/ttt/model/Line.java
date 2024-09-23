package com.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Cell> cells = new ArrayList<>();

	public void addCell(Cell cell) {
		cells.add(cell);
		cell.addLine(this);
	}

	public List<Cell> getCells() {
		return cells;
	}

}
