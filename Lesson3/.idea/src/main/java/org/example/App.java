import java.util.ArrayList;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args ) {
        // 1. Меняем местами элементы массива
        System.out.println("1. Меняем местами элементы массива ");
        String[] words = {"one", "two", "three"};
        ArrayUtils.swapElements(words, 0, 2);
        System.out.println("После замены: " + Arrays.toString(words));

        // 2. Преобразуем массив в ArrayList
        System.out.println("\n2. Преобразуем массив в ArrayList");
        Integer[] numbers = {1, 2, 3, 4};
        ArrayList<Integer> numberList = ArrayUtils.toArrayList(numbers);
        System.out.println("ArrayList: " + numberList);

        // 3. Работа с фруктами и коробками
        System.out.println("\n3. Работа с фруктами и коробками");
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки Apple: " + appleBox.getWeight());
        System.out.println("Вес оранжевой коробки: " + orangeBox.getWeight());

        System.out.println("Веса равны? " + appleBox.compare(orangeBox));

        // Пересыпаем яблоки
        System.out.println("\n Пересыпаем Apple");
        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.transferFruitsTo(anotherAppleBox);
        System.out.print("Первый ящик яблок после переноса: ");
        appleBox.printContents();
        System.out.print("Второй ящик яблок после переноса: ");
        anotherAppleBox.printContents();

        System.out.println("\n Пересыпаем Orange");
        Box<Orange> anotherOrangeBox = new Box<>();
        orangeBox.transferFruitsTo(anotherOrangeBox);
        System.out.print("Первый ящик яблок после переноса: ");
        orangeBox.printContents();
        System.out.print("Второй ящик яблок после переноса: ");
        anotherOrangeBox.printContents();
    }
}
