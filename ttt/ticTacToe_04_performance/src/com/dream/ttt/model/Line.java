package com.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Cell> cells = new ArrayList<>();

	private int score = -1;
	
	public void addCell(Cell cell) {
		cells.add(cell);
		cell.addLine(this);
	}

	public List<Cell> getCells() {
		return cells;
	}

	public int getScore() {
		return score;
	}

	public boolean filledWithSameStone(StoneStatus stone) {
		for (Cell cell : cells) {
			if (cell.getStone() != stone) {
				return false;
			}
		}
		return true;
	}

	public void evaluate(StoneStatus turn) {
		if (score == 0)
			//한번 뒤섞인 줄이 되었으면 상태 지속. 연산 절감으로 성능 향상
			return;
		int[] countPerStone = new int[StoneStatus.values().length];
		for (Cell cell : cells) {
			countPerStone[cell.getStone().ordinal()]++;
		}
		
		if (countPerStone[StoneStatus.Empty.ordinal()] == Board.ROOT)
			//빈줄
			score = 1;
		else if (countPerStone[StoneStatus.Black.ordinal()] > 0 && countPerStone[StoneStatus.White.ordinal()] > 0)
			//뒤섞인 줄
			score = 0;
		else if (countPerStone[turn.ordinal()] > 0)
			//막 놓인 돌로 몇 개 채워져 있다면
			score = countPerStone[turn.ordinal()] * 3;
		else
			//다른 돌로 몇개 채워진 줄이라면
			score = countPerStone[StoneStatus.switchTurn(turn).ordinal()] * 2;
	}
}
