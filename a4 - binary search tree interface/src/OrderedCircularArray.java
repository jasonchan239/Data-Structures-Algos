/**
 * OrderedCircularArray creates an ordered circular array that holds T type of data
 * @author jason
 *
 * @param <T> data assigned when an ordered circular array is created
 */
public class OrderedCircularArray<T> implements SortedListADT<T>{
	private CellData[] list;
	private int front; // stores the position of the first data item in the list; this is the data
	//item with the smallest value. In the constructor of this class this variable must be initialized to 1
	private int rear; // This is the index of the last data item in the ordered list; this is the data item with
	//the largest value. In the constructor for this class this variable must be initialized to 0
	private int count;
	// circular array list stores object CellData
	/**
	 * creates a new Ordered Circular Array with 5 spaces
	 */

	public OrderedCircularArray() {
		front = 1;
		rear= 0;
		count = 0;	
		list = new CellData[5];
		list = (CellData<T>[])list;
	}
	/**
	 * inserts an item with T id and a value
	 */
	public void insert(T id, int value){
		CellData<T> insert = new CellData(id,value);
		int copied = 0;	
		if(count==list.length) {
			CellData<T>[] list2 = (CellData<T>[])new CellData[list.length*2];
			copied = 0;
			int i =front;
			int j = front;
			while(copied<count) {
				list2[i]=list[j];
				i=(i+1)%list2.length;
				j = (j + 1) % list.length;
				copied++;
			}
			//rear=(count-1)%list.length;
			rear=((front+count)-1)%list2.length;
			list=list2;
		}
		if(count==0) {
			list[front]=insert;
			rear=front;
		}else {
			int i2 = -1;
			int iteratorPos;
			for (int i = 0; i <count; i++) {
				iteratorPos=(front + i) % list.length;
				int temp = list[iteratorPos].getValue();
				if(list[iteratorPos].getValue()>value) {
					i2=iteratorPos;
					break;
				}
			}
			rear=(rear+1)%list.length;
			if(i2==-1) {
				list[rear]=insert;
			}else {
				int visitor = rear;
				int copyIndex = 0;
				while(!((copyIndex)==i2)){
					copyIndex = ((visitor-1)+list.length) % list.length;
					list[visitor]=list[copyIndex];
					visitor = copyIndex;
				}
				list[i2]=insert;
			}
		}
		count++;
	}
	/**
	 * returns the value of the given id
	 * @return value of the id in the list
	 * @exception InvalidDataItemException is thrown if id is not in list
	 */
	public int getValue(T id)throws InvalidDataItemException {
		int i = front;
		int i2=0;
		boolean inList = false;
		if(front==rear) {
			if(list[i].getId().equals(id)) {
				inList=true;
				i2=i;
			}else {
				throw new InvalidDataItemException("getValue() id is not in list!");
			}
		}else{
			while(i!=rear && inList==false){
				if(list[i].getId().equals(id)) {
					inList=true;
					i2=i;
				}
				i++;
				if(i>=list.length) {
					i=0;	
				}
			}
		}
		if(inList==false) {
			throw new InvalidDataItemException("getValue() id is not in list!");
		}
		return (list[i2].getValue());
	}
	/**
	 * removes the item in the array with given id
	 * @exception InvalidDataItemException is thrown if id is not found
	 */
	public void remove(T id) throws InvalidDataItemException {
		//int i;
		int i2 = 0;
		boolean inList=false;
		if(count==0) {
			throw new InvalidDataItemException("empty");
		}
		int iteratorPos;
		for (int i = 0; i < list.length-1; i++) {
			iteratorPos=(front + i) % list.length;
			if(id.equals(list[iteratorPos].getId())) {
				i2=(front + i) % list.length;
				inList=true;
				break;
			}
		}
		if(inList==true) {
			int visitor = i2;
			while(!(visitor==rear)){
				int copyIndex = (visitor + 1) % list.length;
				list[visitor]=list[copyIndex];
				visitor = copyIndex;
			}
			list[rear]=null;
			if(rear==0) {
				rear=list.length-1;
			}else {
				rear=rear-1;
			}

			count--;
		}else {
			throw new InvalidDataItemException("not in list");
		}
	}
	/**
	 * method changes the value if it is found in the array, with given id and the new value
	 */
	public void changeValue(T id, int newValue) throws InvalidDataItemException{
		int i = front;
		if(count==0) {
			throw new InvalidDataItemException("empty");
		}
		boolean inList = false;
		if(front==rear) {
			if(list[i].getId().equals(id)) {
				inList=true;
			}else {
				throw new InvalidDataItemException("changeValue() id is not in list!");
			}
		}else {
			i=front;
			while(i!=rear && inList==false){
				if(list[i].getId().equals(id)) {
					inList=true;
				}
				i++;
				if(i>=list.length) {
					i=0;	
				}
			}
		}
		if(inList==false) {
			throw new InvalidDataItemException("changeValue() id is not in list!");
		}else {
			remove(id);//
			insert(id,newValue);
		}

	}
	/**
	 * returns the smallest item in the list and increases front value if needed and removes the item
	 */
	public T getSmallest() throws EmptyListException{
		if(count==0) {
			throw new EmptyListException("getSmallest() invoked on empty list!");
		}
		CellData<T> smallest = list[front];
		//		int i = front;
		//		boolean move;
		//		while(i!=rear) {
		//			if(smallest.getValue()>list[i].getValue()) {
		//				smallest = list[i];
		//			}
		//			i++;
		//			if(i>=list.length) {
		//				i=0;
		//			}
		//		}
		//remove the smallest value
		//		if((smallest==list[front])&&count>0) {
		//			front=(front+1)%list.length;
		//			remove(smallest.getId());
		//		}else{
		//		if(count==0) {
		//			throw new EmptyListException("empty list!, unable to getSmallest()");
		//		}
		list[front]=null;
		count--;	
		if(count>0) {
			front = (front+1)%list.length;
		}

		//		remove(smallest.getId());
		//	}
		return smallest.getId();
	}

	public boolean isEmpty()throws InvalidDataItemException {
		if(count==0) {
			return true;
		}else {
			return false;
		}
	}
	public int size() {
		return count;
	}
	public int getFront() {
		return front;
	}
	public int getRear() {
		return rear;
	}

}