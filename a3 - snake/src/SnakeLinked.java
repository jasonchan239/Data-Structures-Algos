/**
 * Stores the information of the snake as it moves around the board.
 * @author jason
 *
 */
public class SnakeLinked {
	private int snakeLength;
	/**
	 * the positions of the tiles of the game board occupied by the snake will be stored in this doubly linked list. 
	 * Doubly linked list of type Position
	 */
	private DoubleList<Position> snakeBody;
	/**
	 * this is the constructor for the class; the parameters are the coordinates of the head of the snake
	 * @param row 
	 * @param col
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position start = new Position(row, col);
		snakeBody.addData(0, start);
	}
	/**
	 * returns the length of the doubly linked list of the snake
	 * @return the int value of the length
	 */
	public int getLength() {
		return snakeLength;
	}
	/**
	 * returns the position in which the method is called for by the index
	 * @param index
	 * @return returns the data at the index position of the snake
	 */
	public Position getPosition(int index) {
		if((index <0 || (index >= snakeLength))) {
			return null;
		}else {
			return snakeBody.getData(index);
		}
	}
	/**
	 * returns true or false if the position given is inside the snakeBody list.
	 * @param pos position specified that will be checked if it is inside the list
	 * @return
	 */
	public boolean snakePosition(Position pos) {
		//DoubleList<Position> temp = new DoubleList<Position>();
		for(int i = 0;i<snakeLength;i++){
			if(pos.equals(snakeBody.getData(i))) {
				return true;
			}
		}
		return false;
	}
	/**
	 * updates the head position of the snake
	 * @param direction holds the direction the snake will be moved
	 * @return the new position data for the snake to move
	 */
	public Position newHeadPosition(String direction) {
		Position newHead = null;
		int intSnakerow = snakeBody.getData(0).getRow();
		int intSnakecol = snakeBody.getData(0).getCol();
		if(direction.equals("right")) {
			newHead = new Position(intSnakerow, intSnakecol+1);
			return newHead;
		}else if(direction.equals("left")){
			newHead = new Position(intSnakerow, intSnakecol-1);
			return newHead;
		}else if(direction.equals("up")){
			newHead = new Position(intSnakerow-1, intSnakecol);
			return newHead;
		}else if(direction.equals("down")){
			newHead = new Position(intSnakerow+1, intSnakecol);
		}return newHead;
	}
	public void moveSnakeLinked(String direction) {
		for(int i =snakeLength-1; i>0; i--) {
			snakeBody.setData(i, snakeBody.getData(i-1));
		}
		snakeBody.setData(0, newHeadPosition(direction));
	}
	/**
	 * shrinks the snake when it hits scissors. removes the last node and decreases snakelength by 1
	 */
	public void shrink() {
		snakeBody.setData(snakeLength-1, null);
		snakeLength = snakeLength - 1;
	}
	/**
	 * grow method increases the size of the snake and invokes a new head position method in the specified direction
	 * @param direction the direction that the snake will grow in
	 */
	public void grow(String direction) {	
		snakeBody.addData(snakeLength, null);
		for(int i =snakeLength; i>0; i--) {
			snakeBody.setData(i, snakeBody.getData(i-1));
		}
		snakeBody.setData(0, newHeadPosition(direction));
		snakeLength++;
	}
}
