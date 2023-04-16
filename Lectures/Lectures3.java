package Lectures;

// Урок 3. Структуры данных. Связный список
public class Lectures3 {
    public static void main(String[] args) {

    }

    public class LinkedList {

        // Базовая реализация связного списка
        private Node head; // голова
        private Node tail; // хвост

        class Node {
            private int value;
            private Node nextNode;
            private Node previousNode;
        }

        // Поиск элементов в связном списке по значению.
        // Сложность алгоритма - O(n)
        public Node findNodeValue(int value) {
            Node node = head;
            while (node.nextNode != null) {
                node = node.nextNode;
                if (node.value == value) {
                    return node;
                }
            }
            return null;
        }

        // Поиск элементов в связном списке по индексу.
        // Сложность алгоритма - O(n)
        public Node findNodeIndex(int index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
                if (node == null) {
                    return null;
                }
            }
            return node;
        }

        // Добавление элементов
        // Сложность алгоритма - O(1)
        public void addLast(int value) {
            Node node = new Node();
            node.value = value;
            tail.nextNode = node;
            node.previousNode = tail;
            tail = node;
        }

        // Разворот связного списка
        // Сложность алгоритма - O(1)
        public void revert() {
            Node node = head;
            // меняем местами указатели на head и tail
            Node temp = head;
            head = tail;
            tail = temp;
            // перебираем список, переворачивая указатели
            while (node.nextNode != null) {
                temp = node.nextNode;
                node.nextNode = node.previousNode;
                node.previousNode = temp;
                node = node.previousNode;
            }
        }

        // Сортировка связного списка
        // Сложность алгоритма - O(n^2)
        public void sort() {
            Node node = head;
            while (node.nextNode != null) {
                Node minPositionNode = node;
                Node innerNode = node.nextNode;
                while (innerNode != null) {
                    if (innerNode.value < minPositionNode.value) {
                        minPositionNode = innerNode;
                    }
                    innerNode = innerNode.nextNode;
                }
                if (minPositionNode != node) {
                    swap(node, minPositionNode);
                    // обновляем ссылки на head и tail если необходимо
                    if (minPositionNode.previousNode == null) {
                        head = minPositionNode;
                    }
                    if (node.nextNode == null) {
                        tail = node;
                    }
                    // сдвигаем
                    node = minPositionNode.nextNode;
                } else {
                    node = node.nextNode;
                }
            }
        }

        private void swap(Node node1, Node node2) {
            // меняем объекты местами, меняя ссылки на соседние элементы
            Node temp = node1.previousNode;
            node1.previousNode = node2.previousNode;
            node2.previousNode = temp;
            temp = node1.nextNode;
            node1.nextNode = node2.nextNode;
            node2.nextNode = temp;
            // корректируем ссылки соседних элементов на корректные после обмена
            if (node2.previousNode != null) {
                node2.previousNode.nextNode = node2;
            }
            if (node2.nextNode != null) {
                node2.nextNode.previousNode = node2;
            }
            if (node1.previousNode != null) {
                node1.previousNode.nextNode = node1;
            }
            if (node1.nextNode != null) {
                node1.nextNode.previousNode = node1;
            }
        }

        // Стек
        // Сложность алгоритма - O(1)
        public void pushHeap(int value) {
            Node node = new Node();
            node.value = value;
            node.nextNode = head;
            head = tail;
        }

        public int pullHead() {
            if (head == null) {
                throw new IllegalArgumentException("Stack is empty");
            }
            int result = head.value;
            head = head.nextNode;
            return result;
        }

        // ОЧередь
        // Сложность алгоритма - O(1)
        public void pushQueue(int value) {
            Node node = new Node();
            node.value = value;
            node.nextNode = head;
            head.previousNode = node;
            head = tail;
        }

        public int pullQueue() {
            if (tail == null) {
                throw new IllegalArgumentException("Queue is empty");
            }
            int result = tail.value;
            tail = tail.previousNode;
            tail.nextNode = null;
            return result;
        }
    }
}
