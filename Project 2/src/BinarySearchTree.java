class BinarySearchTree {
    TreeNode root; //declare root

    public void addArticle(ArticleData article){ //method to add new article
        
        for(String key:article.keywords){ //for each keyword in the list
            ArticleNode newArticleNode = new ArticleNode(article.id, article.title, article.author, null); //create new article node
            boolean inserted = insertTreeNode(key, newArticleNode); //check if keyword is already in the tree
            //System.out.printf("%s %s\n", key, inserted);
            if(!inserted){ //if it is in the tree already
                //append article node to list
                appendArticleNode(key, newArticleNode);
            }
        }
    }

    public void appendArticleNode(String keyword, ArticleNode newArticleNode){ //method to add new article node
        TreeNode current = root; //declare root
        while(current != null) { //while not at null node
            if(keyword.compareTo(current.keyword) < 0){ //if less, go to left child
               //System.out.printf("Test Left %s %s %d\n", keyword, current.keyword, newArticleNode.id);
               current = current.leftChild;
            }
            else if(keyword.compareTo(current.keyword) > 0){ //if more, go to right child
               // System.out.printf("Test Right %s %s %d\n", keyword, current.keyword, newArticleNode.id);
                current = current.rightChild;
            }
            else { //if equal, append article node here
               // System.out.printf("Test Equal %s %s %d\n", keyword, current.keyword, newArticleNode.id);
               newArticleNode.next = current.head;
               current.head = newArticleNode;
               return;
            }
        }
    }

    public boolean insertTreeNode(String keyword, ArticleNode newArticleNode){ //method to search and insert BST node
        if (root == null){ //if root is null
            root = new TreeNode(keyword, newArticleNode); //create root
            return true;
        }
        else{ //if root is not null
            TreeNode parent = null; //set parent to null and current to root
            TreeNode current = root;
            while(current != null) { //while current is not null
                if(keyword.compareTo(current.keyword) < 0){// if less, set parent to current and go to left child 
                   //System.out.printf("Test Left %s %s %d\n", keyword, current.keyword, newArticleNode.id);
                   parent = current;
                   current = current.leftChild;
                }
                else if(keyword.compareTo(current.keyword) > 0){ //if more, set parent to current and go to right child
                   // System.out.printf("Test Right %s %s %d\n", keyword, current.keyword, newArticleNode.id);
                    parent = current;
                    current = current.rightChild;
                }
                else { //if equal it already exists in tree, return false 
                   // System.out.printf("Test Equal %s %s %d\n", keyword, current.keyword, newArticleNode.id);
                    return false;
                }
            }
             if(keyword.compareTo(parent.keyword) < 0){ //if keyword is less, insert left
                parent.leftChild = new TreeNode(keyword, newArticleNode);
            }
            else if(keyword.compareTo(parent.keyword) > 0){ //if keyword is more, insert right
                parent.rightChild = new TreeNode(keyword, newArticleNode);
            }
        }
        return true; //return true if inserted
    }

    public void print() { //call inOrderprint from root
        inOrderPrint(root);
    }

    private void inOrderPrint(TreeNode node){ //printing in alphabetical order
        if(node == null) return; //if reached a leaf, return (base case)
        inOrderPrint(node.leftChild); //recursion for left child first
        System.out.printf("\n%s\n", node.keyword);//print keyword
        ArticleNode article = node.head; //set article to head of list
        while (article != null) { // while not at end of list
            System.out.printf("\t %d | %s | %s-->\n", article.id, article.title, article.author); //print article info
            article = article.next; //iterate to next node
        }
        inOrderPrint(node.rightChild); //recursion for right child last
    }
}