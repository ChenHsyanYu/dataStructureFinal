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
    public void insert(WebNode node){
        if(root == null){
            root = node;
        }
        else{
            WebNode current = root;
            while(current != null){
                if(node.nodeScore < current.nodeScore){
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
    public ArraytList<WebNode> ListTree(){
       ArrayList<WebNode> list = traverse(root);
    }
    private void traverse(WebNode root){
        ArrayList<WebNode> list = new ArrayList<WebNode>(); 
        if(root == null){
            return list;
        }
        else{
            current = root;
            if(current){
                traverse(current.rightChild);
                list.add(current);
                traverse(current.leftChild);
            }
            return list;
        }
    }
}
