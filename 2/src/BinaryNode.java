public class BinaryNode {

    // You might not need to use all methods and instance variables provided by this class
     private DataItem content; 
     private BinaryNode left, right, parent;
     
     public BinaryNode() { //Creates an empty Node
         this.content = null;
         this.left = null;
         this.right = null;
         this.parent = null; 
                 
     }
     
     // Create a leaf node
     public BinaryNode(DataItem content) {
         this.content = content;
         this.left = null;
         this.right = null;
         this.parent = null;
     }
     
     // Create an internal node with the given children
     public BinaryNode(DataItem content, BinaryNode left, BinaryNode right, BinaryNode parent) {
         this.content = content;
         this.left = left;
         this.right = right;
         this.parent = parent;
         
     }
     
     public BinaryNode getLeft() {
         return this.left;
     }
     
     public BinaryNode getRight() {
         return this.right;
     }
     
    public BinaryNode getParent() {
         return this.parent;
     }
 
     public DataItem getContent() {
         return this.content;
     }
 
     
     public boolean isLeaf() {
         if ((this.left == null) && (this.right == null) && (this.content == null))
             return true;
         
         else
             return false;
         
     }
     
     public void setLeft(BinaryNode left) {
         this.left = left;
     }
     
     public void setRight(BinaryNode right) {
         this.right = right;
     }
     public void setParent(BinaryNode parent) {
         this.parent = parent;
     }
     public void setContent(DataItem content) {
         this.content = content;
     }
}
