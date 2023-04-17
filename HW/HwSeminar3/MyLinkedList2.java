package HW.HwSeminar3;

public class MyLinkedList2 {
    private Node2 head; 
    private Node2 tail; 

    
    public MyLinkedList2() {
    }

    public Node2 getHead() {
        return head;
    }
    public void setHead(Node2 head) {
        this.head = head;
    }

    public Node2 getTail() {
        return tail;
    }
    public void setTail(Node2 tail) {
        this.tail = tail;
    }

    // добавление элемента
    public void add(int value) {
        Node2 node = new Node2();
        node.setValue(value); 
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.setNextNode(node); 
            node.setPreviousNode(tail); 
            tail = node;
        }
    }


    // разворот двусвязного списка
    public void revert2(){
        Node2 currentNode = head;
        while (currentNode != null){
            Node2 next = currentNode.getNextNode();
            Node2 previous = currentNode.getPreviousNode();
            currentNode.setNextNode(previous);
            currentNode.setPreviousNode(next);
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }
    // вывод на консоль
    public void show (){
        Node2 currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode);
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    


}
