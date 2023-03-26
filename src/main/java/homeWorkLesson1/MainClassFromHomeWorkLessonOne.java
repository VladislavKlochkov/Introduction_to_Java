package homeWorkLesson1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MainClassFromHomeWorkLessonOne {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("Вы задали массив: " + Arrays.toString(array));
        int minEl = findMinElemInArray(array);
        int maxEl = findMaxElemInArray(array);
        System.out.println("Минимальный элемент массива: " + minEl);
        System.out.println("Максимальный элемент массива: " + maxEl);

//        int[] nums = {7, 3, 2, 2, 1, 3, 1, 3};
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] resArr = moveElementsToEnd(nums, val);
        System.out.println(Arrays.toString(resArr));

        inputNameAndPrintGreeting();
    }

    //    task01: Задать одномерный массив и найти в нем минимальный и максимальный элементы.
    private static int[] createArray() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите количество элементов в массиве: ");
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Введите " + (i + 1) + " элемент массива: ");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    private static int findMinElemInArray(int[] arr) {
        int minElem = arr[0];
        for (int i : arr) {
            if (i < minElem) {
                minElem = i;
            }
        }
        return minElem;
    }

    private static int findMaxElemInArray(int[] arr) {
        int maxElem = arr[0];
        for (int i : arr) {
            if (i > maxElem) {
                maxElem = i;
            }
        }
        return maxElem;
    }

    //    task02: Дан массив nums = [3,2,2,3] и число val = 3.
    // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    // Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

    private static int[] moveElementsToEnd(int[] arr, int value) {
        int leftVal = 0;
        int rightVal = arr.length - 1;
        int item;
        while (leftVal < rightVal) {
            if (arr[rightVal] == value) {
                rightVal--;
            }
            if (arr[leftVal] == value) {
                item = arr[leftVal];
                arr[leftVal] = arr[rightVal];
                arr[rightVal] = item;
            }
            leftVal++;
        }
        return arr;
    }

    //    task03: *. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
    //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
    //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
    //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

    private static void inputNameAndPrintGreeting() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите имя: ");
        String name = in.nextLine();
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.printf("Доброе утро, %s", name + "!");
        }
        if (hour >= 12 && hour < 18) {
            System.out.printf("Добрый день, %s", name + "!");
        }
        if (hour >= 18 && hour < 23) {
            System.out.printf("Добрый вечер, %s", name + "!");
        }
        if (hour == 23 || hour < 5) {
            System.out.printf("Доброй ночи, %s", name + "!");
        }
    }
}