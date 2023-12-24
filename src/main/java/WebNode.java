public class WebNode {
    public WebNode parent;
    public WebNode leftChild;
    public WebNode rightChild;
    public Webpage webpage;
    public float nodeScore;
    public WebNode(){
        parent = null;
        leftChild = null;
        rightChild = null;
        nodeScore = 0;
    }
    WebNode(WebNode parent, WebNode leftChild, WebNode rightChild, float nodeScore){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.nodeScore = nodeScore;
    }
    //setters
    public void setParent(WebNode parent){
        this.parent = parent;
    }
    public void setLeftChild(WebNode leftChild){
        this.leftChild = leftChild;
    }
    public void setRightChild(WebNode rightChild){
        this.rightChild = rightChild;
    }
}
