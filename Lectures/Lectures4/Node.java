package Lectures.Lectures4;

import java.util.List;

public class Node {
    int value;
    List <Node> children;
    
    public Node() {
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public List<Node> getChildren() {
        return children;
    }
    public void setChildren(List<Node> children) {
        this.children = children;
    }


}
