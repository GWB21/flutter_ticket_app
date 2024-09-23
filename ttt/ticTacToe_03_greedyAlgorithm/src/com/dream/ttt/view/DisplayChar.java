package com.dream.ttt.view;

import com.dream.ttt.model.Cell;

public enum DisplayChar {
	TopLeft('┌'), Top('┬'), TopRight('┐'), MiddleLeft('├'), Middle('┼'), MiddleRight('┤'), BottomLeft('└'), Bottom('┴'),
	BottomRight('┘'), Cap('\u2508'), Bar('\u2502');

	private char caption;

	private DisplayChar(char caption) {
		this.caption = caption;
	}

    /**
     * dataCount = 3 의 예시
     *         TopLeft Cap Top Cap Top Cap TopRight
     */
    public static String buildTopLine(int dataCount) {
    	StringBuilder sb = new StringBuilder(TopLeft.caption);
        for (int i = 1; i <= dataCount; i++){
        	sb.append(Cap.caption);
            if (i == dataCount){
            	sb.append(TopRight.caption);
            } else {
            	sb.append(Top.caption);
            }
        }
        return sb.toString();
    }

    public static String buildMiddleLine(int dataCount) {
    	StringBuilder sb = new StringBuilder(MiddleLeft.caption);
        for (int i = 1; i <= dataCount; i++){
        	sb.append(Cap.caption);
            if (i == dataCount){
            	sb.append(MiddleRight.caption);
            } else {
            	sb.append(Middle.caption);
            }
        }
        return sb.toString();
    }

    public static String buildButtomLine(int dataCount) {
    	StringBuilder sb = new StringBuilder(BottomLeft.caption);
        for (int i = 1; i <= dataCount; i++){
        	sb.append(Cap.caption);
            if (i == dataCount){
            	sb.append(BottomRight.caption);
            } else {
            	sb.append(Bottom.caption);
            }
        }
        return sb.toString();
    }

    public static String buildDataLine(Cell[] datum) {
    	StringBuilder sb = new StringBuilder(Bar.caption);
        for (Cell cell : datum){
        	sb.append(cell.getStone().getShape());
           	sb.append(Bar.caption);
        }
        return sb.toString();
    }
}
