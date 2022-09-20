import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        // Задание 1
        // Составить алгоритм: если введенное число больше 7, то вывести “Привет”
        getHello();

        // Задание 2
        // Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести “Привет, Вячеслав”,
        // если нет, то вывести "Нет такого имени"
        getName();

        // Задание 3
        // Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3
        int[] intArray = initRandomArray(1, 20, 30);
        System.out.println("--- Начальной массив ---");
        System.out.println(Arrays.toString(intArray));

        int[] multipleOf3Array = multipleOf3(intArray);
        System.out.println("\r\n---- Массив кратных 3 ---");
        System.out.println(Arrays.toString(multipleOf3Array));


        // Задание 4
        // Дана скобочная последовательность: [((())()(())]]
        // Можно ли считать эту последовательность правильной?

        // Ответ - неправильная последовательность скобок
        // Вариант 1 - убрать 2ую и предпоследнюю скобку. Получится "[(())()(())]"
        // Вариант 2 - Поменять 2ую скобку с "(" на "[". Получится "[[(())()(())]]"
        // Вариант 3 - Поменять предпоследнюю скобку с "]" на ")". Получится "[((())()(()))]"
    }

    /**
     * Вывод приветствия, при значении больше 7
     */
    private static void getHello(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = in.nextInt();

        if (num > 7)
            System.out.println("Привет");
        System.out.print("\r\n");
    }

    /**
     * Вывод имени
     */
    private static void getName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();

        if (Objects.equals(name, "Вячеслав"))
            System.out.println("Привет, " + name);
        else
            System.out.println("Нет такого имени");

        System.out.print("\r\n");
    }

    /**
     * Генерация массива случайных чисел
     * @param min минимальное значение числа
     * @param max максимальное значение числа
     * @param arraySize размер массива
     * @return готовый массив случайных чисел
     */
    private static int[] initRandomArray(int min, int max, int arraySize) {
        int[] nums = new int[arraySize];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt((max - min) + 1) + min;
        }
        return nums;
    }

    /**
     * Взять элементы массива кратные 3
     * @param intArray начальный массив
     * @return конечный массив, значений кратных 3
     */
    private static int[] multipleOf3(int[] intArray) {
        // 1ой проход цикла
        // Считаем кол-во кратных 3, для создания статистического массива
        int multipleCount = 0;
        for (int i : intArray) {
            if (i % 3 == 0)
                multipleCount++;
        }

        int[] multipleNums = new int[multipleCount];

        // 2ой проход цикла
        // Записываем кратные 3 в новый массив
        int j = 0;
        for (int i : intArray) {
            if (i % 3 == 0) {
                multipleNums[j] = i;
                j++;
            }
        }

        return multipleNums;

        // Также можно было реализовать в один проход с динамичским массивом ArrayList
    }

}
