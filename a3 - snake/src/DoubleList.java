/**
 * This class represents a doubly linked list of nodes of the class DoubleNode
 * @author jason
 * @param <T>
 */
public class DoubleList<T> {
	/**
	 * holds the head/first node in the doubly linked list.
	 */
	private DoubleNode<T> head;
	/**
	 * holds the last node in the doubly linked list
	 */
	private DoubleNode<T> rear;
	/**
	 * holds the number of items inside the doubly linked list
	 */
	private int numDataItems;
	/**
	 * creates a new empty list of 0 nodes
	 */
	public DoubleList(){
		rear = null;
		head = null;
		numDataItems = 0;
	}
	/**
	 * This method must add a new node to the list storing newData at the specified index location
	 * @param index holds the location in which the data will be placed
	 * @param newData holds the data
	 * @throws InvalidPositionException
	 */
	public void addData(int index,T newData) throws InvalidPositionException {
		if(index<0 || index >numDataItems) {
			throw new InvalidPositionException("addData index<0 || index >numDataItems");
		}
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		if(head == null) {
			newNode.setNext(head);	
			head = newNode;
			rear=newNode;
		}else if(index==0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head=newNode;
		}else if(index==numDataItems) {
			newNode.setPrev(rear);
			rear.setNext(newNode);
			rear = newNode;
		}else{
			DoubleNode<T> temp = head;
			for (int i = 1; i < index; i++) {
				temp = temp.getNext();
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			newNode.setPrev(temp);
			newNode.setData(newData);
		}
		numDataItems = numDataItems +1; 		
	}
	/**
	 * will return the node that is being called at the index position 
	 * @param index
	 * @return returns the node that is being called
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException{
		if((index < 0) || index >= numDataItems) {
			throw new InvalidPositionException("getNode index < 0 || index >= numDataItems");
		}

		if(index == (numDataItems-1)) {
			return rear;
		}else {
			DoubleNode temp = head;
			for(int i = 0; i < index; i++) {
				if(temp.getNext() == null) {
					throw new IndexOutOfBoundsException();
				}
				temp = temp.getNext();
			}
			return temp;
		}
	}
	/**
	 * removes the data from the node at the specified location
	 * @param index
	 * @throws InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException{
		if(index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("removeData index < 0 || index >= numDataItems");
		}
		DoubleNode temp = head;
		if(index ==0) {
			head = temp.getNext();
			return;
		}
		for (int i=0; temp!=null && i<index-1; i++) {
			temp = temp.getNext();
		}
		DoubleNode next = temp.getNext().getNext();
		temp.setNext(next);

	}
	/**
	 * returns the data at the specified location of the node of the given index
	 * @param index
	 * @return returns the data of the node
	 * @throws InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException{
		if(index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("getData index < 0 || index >= numDataItems");
		}
		DoubleNode temp=head;
		for(int i=0; i<index;i++) {
			temp = temp.getNext();
		}
		return (T) temp.getData();
	}

	public void setData(int index, T newData) throws InvalidPositionException{
		if(index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("setData index < 0 || index >= numDataItems");
		}
		getNode(index).setData(newData);
	}
}