/**
 * CellData class creates a celldata with an id and a value
 * @author jason
 *
 * @param <T> generic type assigned when created
 */
public class CellData<T>{
	private T id;
	private int value;
	/**
	 * creates a new CellData item with an id and value
	 * @param theId
	 * @param theValue
	 */
	public CellData(T theId,int theValue) {
		id = theId;
		value = theValue;
	}
	/**
	 * returns the value of the item
	 * @return value being held by the element
	 */
	public int getValue() {
		return value;
	}
	public T getId() {
		return id;
	}
	/**
	 * sets the value of the CellData element
	 * @param newValue holds the new value replacing the current value
	 */
	public void setValue(int newValue) {
		value = newValue;
	}
	public void setId(T newId) {
		id = newId;
	}

}
