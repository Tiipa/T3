import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String[] rome={"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    static int x = 0;
    static int y = 0;
    private static boolean checkX;
    private static boolean checkY;

    public static void main(String[] args) {
        System.out.println("Input");
        String str = new Scanner(System.in).nextLine();
        System.out.println("Output");
        String[] mass = str.split(" ");
        if (mass.length == 3) {
            if (checkRome(mass)) System.out.println(romeArifmetic(mass));
            else System.out.println(arabArifmetic(mass));
        }
        if (mass.length !=3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    System.exit(0);
                }
            }
        }
    static boolean checkRome(String[] mass) {
        boolean checkX = false;
        boolean checkY = false;
        for (int i = 0; i < rome.length; i++) {
            if (mass[0].equals(rome[i])) {
                x = i;
                checkX = true;
            }
            if (mass[2].equals(rome[i])) {
                y = i;
                checkY = true;
            }
        }
        if ((checkX == true && checkY == false) || (checkX == false && checkY == true)) {
            try { throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Используются одновременно разные системы счисления.");
                System.exit(0);}}
        if (checkX && checkY == true) {
            return true;
        }
        else return false;
    }

    static String romeArifmetic(String[] mass) {
        String s = "";
        int c = 0;
        switch (mass[1]) {
            case "+":
                c = x + y;
                for (int i = 0; i < rome.length; i++) {
                    if (i == c) {
                        s = rome[i];
                    }
                }
                break;
            case "-":
                c = x - y;
                for (int i = 0; i < rome.length; i++) {
                    if (i == c) {
                        s = rome[i];
                    }
                }
                break;
            case "*":
                c = x * y;
                for (int i = 0; i < rome.length; i++) {
                    if (i == c) {
                        s = rome[i];
                    }
                }
                break;
            case "/":
                c = x / y;
                for (int i = 0; i < rome.length; i++) {
                    if (i == c) {
                        s = rome[i];
                    }
                }
                break;
        }
            if (x > 10 || y >10 || x < 1 || y < 1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Не корректное значение операнда, введите от I до X.");}
                System.exit(0);
            }
        if (c<1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("В Римской системе не отрицательных чисел и 0.");}
            System.exit(0);
        }
            return s;
    }
    static  String arabArifmetic(String[] mass)  {
            String otvet = "";
            x = Integer.parseInt(mass[0]);
            y = Integer.parseInt(mass[2]);
            switch (mass[1]) {
                case "+" -> otvet = "" + (x + y);
                case "-" -> otvet = "" + (x - y);
                case "*" -> otvet = "" + (x * y);
                case "/" -> otvet = "" + (x / y);
            }
        if (x > 10 || y >10 || x < 1 || y < 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Не корректное значение операнда, введите от 1 до 10.");
            System.exit(0);}
            }
            return otvet;
        }
}
