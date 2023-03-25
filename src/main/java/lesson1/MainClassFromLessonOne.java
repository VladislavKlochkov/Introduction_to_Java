package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
//        ex0();
//        inputNameAndPrint();
//        getRandomArrMaxCount();
        int n = getRandomArrMaxCount(10);
        System.out.println(n);
    }

    //    task00
    private static void ex0() {
        System.out.println("Hello, world!");
    }

    //    task01
    private static void inputNameAndPrint() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите имя: ");
        String name = in.nextLine();
        System.out.printf("Привет, %s!%n", name);
    }
//    task02 version1
//    private static void getRandomArrMaxCount() {
//        int[] arr = new int[]{1,1,0,0,1,1,1};
//        int count = 0;
//        int maxCount = 0;
//        for (int num : arr) {
//            if(num == 1){
//                count++;
//                if(count>maxCount){
//                    maxCount = count;
//                }
//            }
//            else{
//                count = 0;
//            }
//        }
//        System.out.printf("Большая последовательность = %s", maxCount);
//    }

    //    task02 version2
    private static int getRandomArrMaxCount(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2); // 0-1
//            arr[i] = random.nextInt(3, 10); // 3-9
        }
        int count = 0;
        int maxCount = 0;
        for (int num : arr) {
            if (num == 1) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        return maxCount;
    }
}