package Lectures;

import HW.HwSeminar2.HwSeminar2;

// Урок 2. Структуры данных. Массивы. Алгоритмы массивов
public class Lectures2 {
    
    public static void main(String[] args) {
        int[] array = HwSeminar2.fillingArrayRandomNumbers(10, 12, 356); 
        System.out.println("Созданный массив");
        HwSeminar2.arrayPrintLine(array);
        
        System.out.println("Пузырьковая сортировка");
        bubbleSort(array);
        HwSeminar2.arrayPrintLine(array);

    }

    // СОРТИРОВКА ПУЗЫРЬКОМ 
    // (каждый элемент необходимо сравнить с соседним и, если правый элемент меньше левого, то их меняют местами)
    // Сложность алгоритма - O(n^2)
    public static void bubbleSort(int[] array){
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    needSort = true;
                }
            }
        } while (needSort);
    }

    // СОРТИРОВКА ВЫБОРОМ 
    // (поиск наименьшего (или наибольшего) значения правее от сравниваемого элемента. В
    // случае, если такой элемент найден – происходит перестановка с начальным
    // элементом.)
    // Сложность алгоритма - O(n^2)
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPosition]){
                    minPosition = j;
                }
            }
            if(minPosition != i){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition]= temp;
            }
        }
    }

    // СОРТИРОВКА ВСТАВКАМИ 
    // поиск наименьшего (или наибольшего) значения правее от сравниваемого элемента. В
    // случае, если такой элемент найден только после сравнения двух элементов мы не запоминаем индекс
    // наименьшего (наибольшего) из элементов, а сразу производим перестановку    
    // Сложность алгоритма - O(n^2)
    public static void insertionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length-1; j++) {
                if (array[j] > array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // АЛГОРИТМЫ ПОИСКА - перебор всего массива
    // Сложность алгоритма - O(n)
    public static int findIndex(int value, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    // БИНАРНЫЙ ПОИСК
    // Сортируем массив данных. Делим его пополам и находим середину.
    // Сложность алгоритма - O(log n)
    public static int binarySearch(int value, int[] array, int min, int max){
        int midpoint;
        if (max < min){
            return -1;
        } else{
            midpoint = (max - min) / 2 + min;
        }

        if(array[midpoint] < value){
            return binarySearch(value, array, midpoint, max);
        } else {
            if(array[midpoint] > value){
                return binarySearch(value, array, min, midpoint -1);
            } else {
                return midpoint;
            }
        }
    }

    // БЫСТРАЯ СОРТИРОВКА
    // разделить массив на 2 части таким образом, чтобы справа все числа были больше, чем слева, при этом их
    // порядок относительно друг друга не важен. Это позволит не сравнивать элементы
    // справа с элементами слева больше 1 раза, как раз для достижения их разделения
    // на 2 части. И далее этот же подход будет применяться для каждой из получившихся
    // частей, равно как предусматривает принцип «разделяй и властвуй»    
    // Сложность алгоритма - O(n log n)
    public static void quickSort(int[] array, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition ++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition --;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        
        if (leftPosition < endPosition){
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition){
            quickSort(array, startPosition, rightPosition);
        }
    }

    //  СОРТИРОВКА КУЧЕЙ (ПИРАМИДАЛЬНАЯ)
    // сравнение элементов происходит не между всеми элементами массива, а только в пределах построенной
    // пирамидальной структуры, т.е. родителя и его детей. Такая операция называется
    // «просеиванием», когда интересующий нас узел кучи сравнивается со своими
    // двумя детьми и меняется местами с тем, что больше родителя. Если оба ребенка
    // больше родителя – обмен происходит с наибольшим из детей.
    // Сложность алгоритма - O(n log n)
    public static void heapSort(int[] array){
        // построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // одним за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            int temp = array[0];
            array[0]= array[i];
            array[i] = temp;
            // вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; //инициализируем больший элемент как корень
        int leftChild = 2 * rootIndex + 1; 
        int rightChild = 2 * rootIndex + 2;
        // если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        // если правый дочерний элемент больше, чем самый бошльшой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        // если самый большой элемент не корень
        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // рекурсивно преолбразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }

     




}
