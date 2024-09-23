package com.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private int row, col;
	private StoneStatus stoneStatus = StoneStatus.Empty;

	private List<Line> lines = new ArrayList<>();

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void addLine(Line line) {
		lines.add(line);
	}
	
	public StoneStatus getStone() {
		return stoneStatus;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public List<Line> getLines() {
		return lines;
	}
}
