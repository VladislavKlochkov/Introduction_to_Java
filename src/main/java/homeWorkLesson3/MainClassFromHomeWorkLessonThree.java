package homeWorkLesson3;

import java.io.FileNotFoundException;
import java.util.*;

public class MainClassFromHomeWorkLessonThree {
    public static void main(String[] args) {
        List<Integer> lst = generateRandomIntegerNumbersList();
        if (lst == null) {
            System.out.println("Некорректный ввод данных");
        } else {
            System.out.println(lst);
            removeEvenNumbersInList(lst);
            findMinMaxAverageNumber(lst);
            System.out.println(lst);
        }

        finishTaskTwoSemThreeAndRemoveDuplicateElements();

        List<String> lst1 = List.of("a", "5", "P", "^^", "7", "3", "Hello!");
        System.out.println(lst1);
        findAndRemoveIntegers(lst1);
    }

    //1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
    private static List<Integer> generateRandomIntegerNumbersList() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите длину списка: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            return null;
        } else {
            System.out.print("Введите минимальное значение списка: ");
            int minNumber = scanner.nextInt();
            System.out.print("Введите максимальное значение списка: ");
            int maxNumber = scanner.nextInt();
            if (minNumber > maxNumber) {
                return null;
            } else {
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                    list.add(random.nextInt(minNumber, maxNumber + 1));
                }
            }
        }
        return list;
    }

    private static List<Integer> removeEvenNumbersInList(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        return list;
    }

    //2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
    private static void findMinMaxAverageNumber(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        int min = list.get(0);
        int max = list.get(0);
        int sum = 0;

        for (Integer item : list) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
            sum += item;
        }
        double average = (double) sum / list.size();
        sb.append("Минимальное значение: ")
                .append(min)
                .append("; ")
                .append("Максимальное значение: ")
                .append(max)
                .append("; ")
                .append("Среднее арифметическое: ")
                .append(average)
                .append(". ");
        System.out.println(sb);
    }

    //3. Доделать задание 2 с семинара. Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
    private static void finishTaskTwoSemThreeAndRemoveDuplicateElements() {
        List<String> planetNames = List
                .of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(planetNames.get(random.nextInt(9)));
        }
        System.out.println(list);

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        System.out.println(list);
        int count = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                count++;
            } else {
                sb.append(list.get(i))
                        .append(": ")
                        .append(count)
                        .append("; ");
                count = 1;
            }
        }
        sb.append(list.get(list.size() - 1))
                .append(": ")
                .append(count)
                .append(".");
        System.out.println(sb);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
                i--;
            }
        }

////        Без использования list.sort(Comparator.naturalOrder());

//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i).equals(list.get(j))) {
//                    list.remove(j);
//                    j--;
//            }
//            }
//        }

        System.out.println(list);
    }

    //4*. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
    // Пройти по списку, найти и удалить целые числа.
    private static void findAndRemoveIntegers(List<String> list) {
        List<String> listOfIntegers = new ArrayList<>(list);
        for (int i = 0; i < listOfIntegers.size(); i++) {
            String item = listOfIntegers.get(i);
            try {
                Integer.parseInt(item);
                listOfIntegers.remove(item);
                i--;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println(listOfIntegers);
    }
}