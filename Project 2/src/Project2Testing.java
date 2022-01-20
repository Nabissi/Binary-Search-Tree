import java.util.ArrayList;
import java.io.*;

class Project2Testing { 
    BufferedReader fileReader; //declaring file reader
    BinarySearchTree bst; //declaring BST
    public static void main(String [] args) {
        Project2Testing Test = new Project2Testing("src/datafile.txt"); //create new Project2Testing object from datafile
        // System.out.println("I will stay focused!"); //Gotta stay focused!!!!!!!!!!!!!! yessir
        Test.bst.print(); //print BST in order
    }

    public Project2Testing(String filename) {//constructor
        try{ //try block to execute
            bst = new BinarySearchTree(); //create BST
            fileReader = new BufferedReader(new FileReader(filename)); //instantiate fileReader

            ArticleData article; //declare article object
            while((article = readNextRecord())!= null){ //while not at end of file
                bst.addArticle(article); //read in next article
            }
        }
        catch(IOException e){ //catch block for exceptions
            e.printStackTrace();
        }
    }

    public ArticleData readNextRecord(){ //method to read in record
        if(fileReader == null) { //if no opened file
            System.out.println("Error: You must open the file first."); //print error
            return null;
        }
        else{
            ArticleData article; //declare article object
            try{
                String data = fileReader.readLine(); //read first line
                if(data == null){ //if data read incorrectly
                    return null; //return null
                }
                int titleId = Integer.parseInt(data); //turn first line into int and set titleID
                String title = fileReader.readLine(); //read in title from next line
                String author = fileReader.readLine(); //read in author from next line
                int numKeys = Integer.parseInt(fileReader.readLine()); //turn next line into integer for numKeys
                article = new ArticleData(titleId, title, author, numKeys); //dynamically create new article from read information
                
                String keyword; //declare keyword
                for (int i = 0; i < numKeys; i++){ //for number of keywords
                    keyword = fileReader.readLine(); //read keyword
                    article.addKeyword(keyword); //add keyword to list
                }
                //we can add testing for space later; for now read blank line
                fileReader.readLine(); //read blank line for garbage collection
            }
            catch(NumberFormatException e){ //catch block for exceptions
                System.out.println("Error: Number expected!");
                return null;
            }
            catch(Exception e) { //catch block for exceptions
                System.out.println("Fatal Error");
                return null;
            }
            return article; //return article object
        }
    }
}