public class OrderedDictionary implements OrderedDictionaryADT{

    BinarySearchTree bst = new BinarySearchTree();
    private BinaryNode root;
    
    public OrderedDictionary() {
        root = new BinaryNode(); // creates a new empty OrderedDictioanry
    }
    
    public DataItem get (Key k) {
        BinaryNode getNode = bst.getcall(this.root, k);
        
        if(getNode.isLeaf())
            return null;
        
        return getNode.getContent();

    }
    public void put(DataItem d) throws DictionaryException{
        BinaryNode position = bst.getcall(root, d.getKey());
        
        if (!position.isLeaf()) throw new DictionaryException("Key already exists in the tree"); // if the position is currently a internal node then that means its duplicated and throws and expetion
        else {
            if (position.isLeaf()) { // if position is a leaf then you can enter data 
                position.setContent(d);
                position.setLeft(new BinaryNode(null,null,null,position)); // sets left leaf node (child)
                position.setRight(new BinaryNode(null,null,null,position));// sets right leaf node (child)
            }
        }
    }
    public void remove (Key k) throws DictionaryException{
        if(!bst.remove(root,k)) throw new DictionaryException ("key not in dictionary");
    }

    
    public DataItem successor(Key k) {
        BinaryNode succ = bst.successor(root,k);
        if(succ == null)
            return null;
        else
            return succ.getContent();
        
    }


    public DataItem predecessor(Key k) {
        BinaryNode pred = bst.predecessor(root,k);
        if(pred == null)
            return null;
        else
            return pred.getContent();
    }

    
    public DataItem smallest() {
        BinaryNode small = bst.smallest(root);
        if(small == null)
            return null;
        else
            return small.getContent();
        
    }


    public DataItem largest() {
        BinaryNode large = bst.largest(root);
        if(large == null)
            return null;
        else
            return large.getContent();
    }
    

}
