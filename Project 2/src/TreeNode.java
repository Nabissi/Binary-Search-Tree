class TreeNode { //node for BST
    TreeNode leftChild; //variable declaration for child pointers
    String keyword; //element
    TreeNode rightChild;
    ArticleNode head; //head of article linked list
    
    public TreeNode(String key, ArticleNode rec){ //constructor
        leftChild = null; //set left and right child to null
        keyword = key; //set element
        rightChild = null;
        head = rec; //set record as new head
    }
}   