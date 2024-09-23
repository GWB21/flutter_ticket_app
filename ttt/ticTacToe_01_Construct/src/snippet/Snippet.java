package snippet;

public class Snippet {
	public static void main(String[] args) {
		board.getCells().forEach(cell -> {
					int lineSize = cell.getLines().size();
					if (lineSize == 2) {
						assert (cell.getRow() == 0 && cell.getCol() == 1
								|| cell.getRow() == 1 && (cell.getCol() == 0 || cell.getCol() == 2)
								|| cell.getRow() == 2 && cell.getCol() == 1);
						*/
						assert (board.getCellPosition(cell) == Position.Other);
					} else if (lineSize == 3) {
						assert (board.getCellPosition(cell) == Position.Coner);
					} else if (lineSize == 4) {
						assert (board.getCellPosition(cell) == Position.Center);
					}
	}
}

