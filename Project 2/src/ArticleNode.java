class ArticleNode { //node for linked list
    int id; //variable declaration for article information
    String title;
    String author;
    ArticleNode next; //pointer to next node in the list

    ArticleNode(int i, String t, String a, ArticleNode r){ //constructor
        id = i; //set values of variables
        title = t;
        author = a;
        next = r; //set next node in list
    }
}

