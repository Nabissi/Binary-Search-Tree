import java.util.*;
class ArticleData {
    int id; //variable declaration to hold article information
	String title;
	String author;
	ArrayList<String> keywords; //List for keywords
	
	
	ArticleData(int id, String title, String author, int keywordCount){ //constructor
		this.id=id; //set variables
		this.title=title;
		this.author=author;
		keywords = new ArrayList<String>(keywordCount); //dynamically create new arrayList for keywords
	} 

    void addKeyword(String keyword){ //adds keyword to arrayList
        keywords.add(keyword);
    }
}
