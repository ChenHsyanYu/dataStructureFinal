import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WebTree {
    public WebNode root;
    public WebTree(){
        root = null;
    }
    public void setRoot(WebNode root){
        this.root = root;
    }

    //insert node into the tree by using BST
    public void insert(WebNode node){
        if(root == null){
            root = node;
        }
        else{
            WebNode current = root;
            while(current != null){
                if(node.webpage.score < current.webpage.score){
                    if(current.leftChild == null){
                        current.leftChild = node;
                        node.parent = current;
                        break;
                    }
                    else{
                        current = current.leftChild;
                    }
                }
                else{
                    if(current.rightChild == null){
                        current.rightChild = node;
                        node.parent = current;
                        break;
                    }
                    else{
                        current = current.rightChild;
                    }
                }
            }
        }
    }

    //List the tree from highest score to lowest score
    public ArrayList<WebNode> ListTree(){
       ArrayList<WebNode> list = traverse(root);
       return list;
    }

    //traverse the tree from highest score to lowest score
    private ArrayList<WebNode> traverse(WebNode root){
        ArrayList<WebNode> list = new ArrayList<WebNode>(); 
        if(root == null){
            return list;
        }
        else{
            WebNode current = root;
            if(current != null){
                traverse(current.rightChild);
                list.add(current);
                traverse(current.leftChild);
            }
            return list;
        }
    }
}
