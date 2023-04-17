package HW.HwSeminar4;

public class RedBlackTree {
    private Node root;

    public RedBlackTree() {
    }
    
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(int value){
        if(getRoot() != null){
            boolean result = addNode(getRoot(), value);
            setRoot(rebalnce(getRoot()));
            getRoot().setColor(Color.BLACK);
            return result;
        } else {
            root = new Node();
            root.setColor(Color.BLACK);
            root.setValue(value);
            return true;
        }
    }

    public boolean addNode(Node node, int value){
        if(node.getValue() == value){
            return false;
        } else {
            if (node.getValue() > value){
                if (node.getLeftChild() != null){
                    boolean result = addNode(node.getLeftChild(), value);
                    node.setLeftChild(rebalnce(node.getLeftChild()));
                    return result;
                } else {
                    node.setLeftChild(new Node());
                    node.getLeftChild().setColor(Color.RED);
                    node.getLeftChild().setValue(value);
                    return true;
                }
            } else {
                if (node.getRightChild() != null){
                    boolean result = addNode(node.getRightChild(), value);
                    node.setRightChild(rebalnce(node.getRightChild()));
                    return result;                
                } else {
                    node.setRightChild(new Node());
                    node.getRightChild().setColor(Color.RED) ;
                    node.getRightChild().setValue(value);
                    return true;
                }
            }
        }
    }

    private Node rebalnce(Node node){
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.getRightChild() != null && result.getRightChild().getColor() == Color.RED &&
                (result.getLeftChild() == null || result.getLeftChild().getColor() == Color.BLACK)){
                    needRebalance = true;
                    result = rightSwap(result);
                }
            if (result.getLeftChild() != null && result.getLeftChild().getColor() == Color.RED &&
            (result.getLeftChild().getLeftChild() == null || result.getLeftChild().getLeftChild().getColor() == Color.RED)){
                needRebalance = true;
                result = leftSwap(result);                
            }
            if (result.getLeftChild() != null && result.getLeftChild().getColor() == Color.RED &&
                (result.getRightChild() == null || result.getRightChild().getColor() == Color.BLACK)){
                    needRebalance = true;
                    colorSwap(result);
                }
        } while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node){
        Node rightChild = node.getRightChild();
        Node betweenChild = rightChild.getLeftChild();
        rightChild.setLeftChild(node);
        node.setRightChild(betweenChild);
        rightChild.setColor(node.getColor());
        node.setColor(Color.RED);             
        return rightChild;
    }

    private Node leftSwap(Node node){
        Node leftChild = node.getLeftChild();
        Node betweenChild = leftChild.getRightChild();
        leftChild.setRightChild(node);
        node.setLeftChild(betweenChild);
        leftChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return leftChild;
    }

    private void colorSwap(Node node){
        node.getRightChild().setColor(Color.BLACK);
        node.getLeftChild().setColor(Color.BLACK);
        node.setColor(Color.RED);
    }

}
