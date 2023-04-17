package HW.HwSeminar3;

public class Node2 {
    public static final String MyLinkedList2 = null;
    private int value;
    private Node2 nextNode;
    private Node2 previousNode;

    public Node2() {
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Node2 getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node2 nextNode) {
        this.nextNode = nextNode;
    }

    public Node2 getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node2 previousNode) {
        this.previousNode = previousNode;
    }


    @Override
    public String toString() {
        return String.format(" %d  ", value);
    }
}
