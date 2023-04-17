package HW.HwSeminar3;

// Необходимо реализовать метод разворота связного списка (двухсвязного).
public class Main {
    public static void main(String[] args) {
        MyLinkedList2 list =  new MyLinkedList2();
        list.add(67);
        list.add(3);
        list.add(99);
        list.add(5);
        list.add(32);
        list.add(11);

        list.show();

        list.revert2();

        list.show();
    }
    
        
}
    
    


    

