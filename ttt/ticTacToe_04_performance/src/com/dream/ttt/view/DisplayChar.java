package com.dream.ttt.view;

import com.dream.ttt.model.Cell;

public enum DisplayChar {
	TopLeft('┌'), Top('┬'), TopRight('┐'), MiddleLeft('├'), Middle('┼'), MiddleRight('┤'), BottomLeft('└'), Bottom('┴'),
	BottomRight('┘'), Cap('\u2508'), Bar('\u2502');

	private char caption;

	/* 불변 정보 기억. 연산 횟수 절감 */
	private static String topLine = null;
	private static String middleLine = null;
	private static String bottomLine = null;

	private DisplayChar(char caption) {
		this.caption = caption;
	}

	/**
	 * dataCount = 3 의 예시 TopLeft Cap Top Cap Top Cap TopRight
	 */
	public static String buildTopLine(int dataCount) {
		if (topLine == null) {
			StringBuilder sb = new StringBuilder(TopLeft.caption);
			for (int i = 1; i <= dataCount; i++) {
				sb.append(Cap.caption);
				if (i == dataCount) {
					sb.append(TopRight.caption);
				} else {
					sb.append(Top.caption);
				}
			}
			topLine = sb.toString();
		}
		return topLine;
	}

	public static String buildMiddleLine(int dataCount) {
		if (middleLine == null) {
			StringBuilder sb = new StringBuilder(MiddleLeft.caption);
			for (int i = 1; i <= dataCount; i++) {
				sb.append(Cap.caption);
				if (i == dataCount) {
					sb.append(MiddleRight.caption);
				} else {
					sb.append(Middle.caption);
				}
			}
			middleLine = sb.toString();
		}
		return middleLine;
	}

	public static String buildButtomLine(int dataCount) {
		if (bottomLine == null) {
			StringBuilder sb = new StringBuilder(BottomLeft.caption);
			for (int i = 1; i <= dataCount; i++) {
				sb.append(Cap.caption);
				if (i == dataCount) {
					sb.append(BottomRight.caption);
				} else {
					sb.append(Bottom.caption);
				}
			}
			bottomLine = sb.toString();
		}
		return bottomLine;
	}

	public static String buildDataLine(Cell[] datum) {
		StringBuilder sb = new StringBuilder(Bar.caption);
		for (Cell cell : datum) {
			sb.append(cell.getStone().getShape());
			sb.append(Bar.caption);
		}
		return sb.toString();
	}
}
