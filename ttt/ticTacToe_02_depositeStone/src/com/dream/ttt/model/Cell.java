package com.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	//Board 상의 위치 기억
	private int row, col;
	//해당 칸에 놓인 돌. 처음에는 없습니다.
	private StoneStatus stoneStatus = StoneStatus.Empty;

	//칸이 담긴 줄. 중앙이면 4개 줄, 모서리면 3개 줄, 외곽이면 2개 줄에 담김 
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

	public void depositeStone(StoneStatus stone) {
		assert(stone != StoneStatus.Empty);
		stoneStatus = stone;
	}
}
