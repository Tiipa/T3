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

    public static void main(String[] args) {
        System.out.println("Input");
        String str = new Scanner(System.in).nextLine();
        System.out.println("Output");
        String[] mass = str.split(" ");
        if (mass.length >2 && mass.length <4) {
            if (checkRome(mass)) System.out.println(romeArifmetic(mass));
            else System.out.println(arabArifmetic(mass));
        }
        else System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
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
        if (checkX == true && checkY == true) {
            if (x > 10 || y >10) {
                System.out.println("Превышено значение операнда, введите от I до X.");
                System.exit(1);
            }
            return true;
        } else return false;
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
        if (c < 0) {
            return "В римской системе нет отрицательных чисел.";
        }
            return s;
    }
    static  String arabArifmetic(String[] mass) {
        try {
            String otvet = "";
            x = Integer.parseInt(mass[0]);
            y = Integer.parseInt(mass[2]);
            if (x > 10 || y >10 || x < 1 || y < 1) {
                System.out.println("Превышено значение операнда, введите от 1 до 10.");
                System.exit(1);}
            switch (mass[1]) {
                case "+":
                    otvet = "" + (x + y);
                    break;
                case "-":
                    otvet = "" + (x - y);
                    break;
                case "*":
                    otvet = "" + (x * y);
                    break;
                case "/":
                    otvet = "" + (x / y);
                    break;
            }
            return otvet;
        } catch (NumberFormatException e) {
            return "Используются одновременно разные системы исчесления.";
        }
    }
}
