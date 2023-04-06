package lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClassFromLessonFive {
    public static void main(String[] args) {
        String number = "MMCMXCIX";
        System.out.println(fromRomanToArabic(number));
    }
    private static int fromRomanToArabic(String num) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("I", 1);
        numbers.put("V", 5);
        numbers.put("X", 10);
        numbers.put("L", 50);
        numbers.put("C", 100);
        numbers.put("D", 500);
        numbers.put("M", 1000);

        int sumNum = 0;
        int next = -1;
        for (int i = 0; i < num.length() - 1; i++) {
            int current = numbers.get(num.charAt(i) + "");
            next = numbers.get(num.charAt(i + 1) + "");
            if (current < next) {
                sumNum -= current;
            } else {
                sumNum += current;
            }
        }
        sumNum += next;
        return sumNum;
    }
}