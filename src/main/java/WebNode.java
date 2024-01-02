public class WebNode {
    public WebNode parent;
    public WebNode leftChild;
    public WebNode rightChild;
    public Webpage webpage;
    
    public WebNode(Webpage page){
    	this.webpage = page;
    	System.out.println("標題"+" "+page.title);
        parent = null;
        leftChild = null;
        rightChild = null;
    }
    WebNode(WebNode parent, WebNode leftChild, WebNode rightChild){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
