package HW.HwSeminar4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. 
И реализовать в нем метод добавления новых элементов с балансировкой.

Красно-черное дерево имеет следующие критерии:
• Каждая нода имеет цвет (красный или черный)
• Корень дерева всегда черный
• Новая нода всегда красная
• Красные ноды могут быть только левым ребенком
• У краной ноды все дети черного цвета

Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево 
необходимо произвести балансировку, благодаря которой все критерии выше станут валидными. 
Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
}
