/**
 * This class represents the board game where the snake moves around eating apples
 * @author jason
 *
 */
public class BoardGameLinked {
	int boardLength;
	int boardWidth;
	//SnakeLinked theSnake;********************
	DoubleList<String>[] board;
	private int snakeX;
	private int snakeY;
	SnakeLinked theSnake;
	//empty, apple, scissors, rock ***********************
	/**
	 * This class represents the board game where the snake moves around eating apples
	 * @param boardFile holds the file that will be read to create the board 
	 */
	public BoardGameLinked(String boardFile) { //
		MyFileReader in = new MyFileReader(boardFile);
		int coord1;
		int coord2;
		String strtemp1;
		// skip first 2 lines
		in.readInt(); 
		in.readInt();

		boardLength = in.readInt();
		boardWidth = in.readInt();
		//board dimensions
		//snake position
		snakeX = in.readInt();
		snakeY = in.readInt();
		theSnake = new SnakeLinked(snakeX,snakeY);
		//create board
		board = new DoubleList[boardWidth];
		for (int i=0;i<boardWidth;i++) {
			board[i] = new DoubleList<String>();
			for (int j=0;j<boardLength;j++) {
				board[i].addData(j, "empty");
			}
		}
		while (in.endOfFile() == false){  
			coord1 = in.readInt();
			coord2 = in.readInt();
			board[coord1].setData(coord2, in.readString());
		}
	}
	/**
	 * returns the string stored in the node
	 * @param row holds the row
	 * @param col holds the column
	 * @return the object at the specified location
	 * @throws InvalidPositionException if the method is given an invalid position, it will throw an exception
	 */
	public String getObject(int row, int col) throws InvalidPositionException{
		if((row <0 || col <0) ||(row >= boardWidth || col >= boardLength)){
			throw new InvalidPositionException("(row <0 || col <0) ||(row >= boardWidth || col >= boardLength)");
		}
		//String returnObj = board[row].getData(col);
		return board[row].getData(col);
	}
	/**
	 * sets the object at the specified location
	 * @param row 
	 * @param col
	 * @param newObject holds the new object in which will be placed at the location
	 * @throws InvalidPositionException
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException{
		if((row <0 || col <0) ||(row >= boardWidth || col >= boardLength)){
			throw new InvalidPositionException("(row <0 || col <0) ||(row >= boardWidth || col >= boardLength)");
		}
		board[row].setData(col, newObject);
	}
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}
	public int getLength() {
		return boardLength;
	}
	public int getWidth() {
		return boardWidth;
	}
}
