/**
 * class DoubleNode represents the nodes in a doubly linked list
 * @author Jason Chan
 */
public class DoubleNode<T> {
	/**
	 *next is a reference to the next node in the list 
	 */
	private DoubleNode<T> next;
	/**
	 *prev is a reference to the previous node in the list 
	 */
	private DoubleNode<T> prev;
	/**
	 *data is the data stored in this node 
	 */
	private T data;
	/**
	 * Creates an empty node, where all instance variables are null. 
	 */
	public DoubleNode() {
		next = null;
		data = null;
		prev=null;
	}
	/**
	 * creates a node storing given data and next and prev are both null
	 * @param newData is the data to be stored in the node
	 */
	public DoubleNode(T newData) {
		next = null;
		data = newData;
		prev = null;
	}
	public DoubleNode<T> getNext (){
		return next;
	}
	public DoubleNode<T> getPrev (){
		return prev;
	}
	public T getData () {
		return data;
	}
	public void setNext (DoubleNode<T> nextNode){
		next = nextNode;
	}
	public void setPrev (DoubleNode<T> prevNode){
		prev = prevNode;
	}
	public void setData (T newData) {
		data = newData;
	}
}
