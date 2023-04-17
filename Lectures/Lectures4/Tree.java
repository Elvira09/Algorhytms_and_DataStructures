package Lectures.Lectures4;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;

// ОБХОД ДЕРЕВА В ГЛУБИНУ
    // поиск ноды
    private Node findDepth(Node node, int value){
        if (node.getValue() == value){
            return node;
        } else {
            for (Node child : node.getChildren()) {
                Node result = findDepth(child, value);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
    }
    public boolean existDepth(int value){
        if (root != null){
            Node node = findDepth(root, value);
            if (node != null){
                return true;
            }
        }
        return false;
    }
    

// ОБХОД ДЕРЕВА В ШИРИНУ
    private Node findWidth(int value){
        List<Node> line = new ArrayList<>();
        line.add(root);
        while(line.size() > 0){
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.getValue() == value){
                    return node;
                }
                nextLine.addAll(node.getChildren());
            }
            line = nextLine;
        }
        return null;
    }

// КРАСНО-ЧЕРНОЕ ДЕРЕВО


}
