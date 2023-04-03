package lesson4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MainClassFromLessonFour {
    public static void main(String[] args) {
        getUserStringAndRemoveIndex();
    }
    private static void getUserStringAndRemoveIndex() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> ll = new LinkedList<>();
        while (true) {
            System.out.printf("Введите текст-позицию: ");
            String text = in.nextLine();
            String[] array = text.split("\\~");
            System.out.println(Arrays.toString(array));
            int index = Integer.parseInt(array[1]);
            String value = array[0];
            if (value.equals("print")) {
                if (ll.get(index) == null) {
                    System.out.println("Значения нет");
                } else {
                    System.out.println(ll.get(index));
                    ll.remove(index);
                }
            } else {
                if (index < ll.size()) {
                    ll.set(index, value);
                } else {
                    for (int i = ll.size(); i < index - 1; i++) {
                        ll.add(null);
                    }
                    ll.add(value);
                }
            }
            System.out.println(ll);
        }
    }
}