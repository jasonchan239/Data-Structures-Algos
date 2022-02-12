/**
 * Position class determines the location of things based on the row and column
 * Same as assignment 1!
 * @author Jason Chan
 */
public class Position {

	//private int intRow;
	//private int intCol;
	/**
	 *PositionRow keeps the row 
	 */
	private int positionRow;
	/**
	 *PositionCol keeps the column
	 */
	private int positionColumn;

	public Position(int intRow,int intCol) {
		positionRow = (intRow);
		positionColumn = (intCol);
	}
	public int getRow() {
		return positionRow;
	}

	public int getCol() {
		return positionColumn;
	}

	public void setRow(int newRow) {
		positionRow = newRow;
	}

	public void setCol(int newCol) {
		positionColumn = newCol;

	}
	/**
	 *equals method checks if the parameter coordinate is equal
	 *checks row and column
	 * @param otherPosition
	 */
	public boolean equals(Position otherPosition){
		if(((otherPosition.getRow()==positionRow) && (otherPosition.getCol() == positionColumn))){
			return true;
		}else{
			return false;
		}	
	}

}
