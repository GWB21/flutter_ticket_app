package com.dream.ttt.model;

public enum StoneStatus {
	Empty(' '), White('X'), Black('O');
	
	private char shape;
	
	private StoneStatus(char shape) {
		this.shape = shape;
	}
	
	public char getShape() {
		return shape;
	}
	
	public static StoneStatus switchTurn(StoneStatus curStatus) {
		if (curStatus == StoneStatus.White)
			return StoneStatus.Black;
		return StoneStatus.White;
			
	}
}
