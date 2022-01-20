public class ArticleList { //linked list for articles
    int id;  // variable declaration to hold article information
    String title;
    String author;
    ArticleList next; //pointer to next node in linked list
    
    public ArticleList(int i, String t, String a, ArticleList article){ //constructor
        id = i; //set variables
        title = t;
        author = a;
        next = article; //set next article to point to                                                                                                                          mmnmm
    }
}
