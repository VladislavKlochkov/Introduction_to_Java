package lesson2;

public class MainClassFromLessonTwo {
    public static void main(String[] args) {
//        returnLengthN();
        stringCompression();
    }

    private static void returnLengthN() {
        int n = 7;
        String a = "a";
        String b = "B";
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                c.append(a);
            } else {
                c.append(b);
            }
        }
        System.out.println(c);
    }

    private static void stringCompression() {
        String str = "aaaabbbcddr";
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                res.append(str.charAt(i)).append(count > 1 ? count : "");
//                if (count > 1) {
//                    res.append(count);
//                }
                count = 0;
            }
            count++;
        }
        res.append(str.charAt(str.length() - 1)).append(count > 1 ? count : "");
        System.out.println(res);
    }
}