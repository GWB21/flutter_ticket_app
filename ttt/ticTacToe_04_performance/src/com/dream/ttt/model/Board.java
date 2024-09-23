package com.dream.ttt.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {
	/* 판 크기 설정 */
	public static final int ROOT = 3;
	/* Singletone Pattern 적용. 어디서나 접근 가능 */
	private static Board theInstance = new Board();

	public static Board getInstance() {
		return theInstance;
	}

	// 2차원 구조
	private Cell[][] cells = new Cell[ROOT][ROOT];
	// 가로줄 3개, 세로줄 3개, 대각줄 2개
	private List<Line> lines = new ArrayList<>();
	// 빈칸 목록
	private List<Cell> emptyCells = new ArrayList<>();
	// 객체 재성성 방지로 성능을 고려함
	private Random random = new Random();

	private Board() {
		// 총 9개의 칸 생성과 동시에 같은 문장 구조임으로 3개의 가로줄 생성
		for (int row = 0; row < ROOT; row++) {
			Line aHorizontalLine = new Line();
			for (int col = 0; col < ROOT; col++) {
				Cell cell = new Cell(row, col);
				cells[row][col] = cell;
				aHorizontalLine.addCell(cell);
				emptyCells.add(cell);
			}
			lines.add(aHorizontalLine);
		}
		// 세로줄 생성
		for (int col = 0; col < ROOT; col++) {
			Line aVerticalLine = new Line();
			for (int row = 0; row < ROOT; row++) {
				aVerticalLine.addCell(cells[row][col]);
			}
			lines.add(aVerticalLine);
		}
		// 대각 줄 생성.
		Line diogonalLine = new Line();
		Line invertedDiogonalLine = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			diogonalLine.addCell(cells[idx][idx]);
			invertedDiogonalLine.addCell(cells[idx][(ROOT - 1) - idx]);
		}
		lines.add(diogonalLine);
		lines.add(invertedDiogonalLine);
	}

	public List<Line> getLines() {
		return lines;
	}

	public List<Cell> getCells() {
		List<Cell> ret = new ArrayList<>();
		// "-> {"람다식이 너무 한줄로 길어지면 보기 힘듦
		Arrays.asList(cells).forEach(oneDimArray -> {
			ret.addAll(Arrays.asList(oneDimArray));
		});
		return ret;
	}

	public Cell[][] getCellArray() {
		return cells;
	}

	public Position getCellPosition(Cell cell) {
		if (cell.getRow() == ROOT / 2 && cell.getCol() == ROOT / 2) {
			/* 중앙 판별 */
			return Position.Center;
		} else if (cell.getRow() == cell.getCol() || cell.getRow() + cell.getCol() == ROOT - 1) {
			/* 대각선에 위치했는지 판별 */
			return Position.Coner;
		} else {
			return Position.Other;
		}
	}

	/**
	 * 빈칸이 없다면 승부 판단 이후 재시작 또는 종료된 상황이어야 합니다.
	 * 
	 * @return
	 */
	public PlayStatus depositeStoneByRandom(StoneStatus stone) {
		assert (emptyCells.size() > 0);
		Cell cell = emptyCells.remove(random.nextInt(emptyCells.size()));
		cell.depositeStone(stone);
		
		return decideWin(stone, cell);
	}

	private PlayStatus decideWin(StoneStatus stone, Cell cell) {
		for (Line line : cell.getLines()) {
			if (line.filledWithSameStone(stone))
				return PlayStatus.Win;
		}
		if (emptyCells.size() == 0)
			return PlayStatus.WasDraw;
		return PlayStatus.Playing;
	}

	public PlayStatus depositeStoneByGreedyAlgorithm(StoneStatus stone) {
		assert (emptyCells.size() > 0);
		Cell bestCell = null;
		int bestScore = -1;
		for (Line line : lines) {
			line.evaluate(stone);
		}
		
		for (Cell cell : emptyCells) {
			if (cell.getScore() > bestScore) {
				bestScore = cell.getScore();
				bestCell = cell;
			}
		}
		emptyCells.remove(bestCell);
		bestCell.depositeStone(stone);
		
		return decideWin(stone, bestCell);
	}
}
