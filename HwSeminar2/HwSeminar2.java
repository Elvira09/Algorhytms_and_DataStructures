package HwSeminar2;
import java.util.Random;

// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).


public class HwSeminar2 {
    public static void main(String[] args) {
        int[] array = fillingArrayRandomNumbers(10, 12, 356); 
        arrayPrintLine(array);
        System.out.println();
        heapSort(array);
        arrayPrintLine(array);

    }

    // построение кучи
    private static void heapify(int[] array, int size, int root){
        int largest = root;
        int leftChild = 2*root + 1;
        int rightChild = 2*root + 2;
        if(leftChild < size) {
            if(array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }
        if(rightChild < size) {
            if(array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }
        if(largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
            heapify(array, size, largest);
        }
    }

    // пирамидальная сортировка
    public static void heapSort(int[] array) {
        for(int i = array.length/2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length-1; i >= 0 ; i--) {
             int temp = array[0];
             array[0] = array[i];
             array[i] = temp;
             heapify(array, i, 0);
        }
    }

    // заполнение массива рандомно
    public static int [] fillingArrayRandomNumbers(int length, int min, int max){
        int[] array = new int [length]; 
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min) + min;
        }
        return array;
    }

    // вывод массива линейно
    public static void arrayPrintLine(int[] array){
        for (int i = 0; i < array.length; i++){            
            System.out.print(array[i] + " ");
        }
    }
    
}
