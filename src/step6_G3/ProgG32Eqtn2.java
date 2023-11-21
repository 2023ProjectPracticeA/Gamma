package step6_G3;

import java.util.Scanner;

/*
 * 課題番号      ： 第8回 演習問題G3-2
 * ファイル名    ： ProgG31Eqtn2.java
 * 作成年月日    ： 2023年11月21日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

public class ProgG32Eqtn2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("方程式の次数 >> ");
        int degree = getValidatedNaturalNumberInput(scanner, "方程式の次数 >> ");

        double a, b, c;

        switch (degree) {
            case 1:
                System.out.println("一次方程式を解きます．");
                System.out.println("係数を入力して下さい．");
                a = getValidatedDoubleInput(scanner, "x の係数 >> ", false);
                b = getValidatedDoubleInput(scanner, "定数項 >> ");
                LinEq linEquation = new LinEq(a, b);
                linEquation.solve();
                System.out.println();
                System.out.println("方程式：");
                linEquation.dispEq();
                System.out.println();
                linEquation.dispAns();
                break;
            case 2:
                System.out.println("二次方程式を解きます．");
                System.out.println("係数を入力して下さい．");
                a = getValidatedDoubleInput(scanner, "x² の係数 >> ", false);
                b = getValidatedDoubleInput(scanner, "x の係数 >> ");
                c = getValidatedDoubleInput(scanner, "定数項 >> ");
                QuadEq quadEquation = new QuadEq(a, b, c);
                quadEquation.solve();
                System.out.println();
                System.out.println("方程式：");
                quadEquation.dispEq();
                System.out.println();
                quadEquation.dispAns();
                break;
            default:
                System.out.println("無効な次数です．");
                break;
        }

        scanner.close();
    }

    private static double getValidatedDoubleInput(Scanner scanner, String prompt) {
        return getValidatedDoubleInput(scanner, prompt, true);
    }

    private static double getValidatedDoubleInput(Scanner scanner, String prompt, boolean allowZero) {
        System.out.print(prompt);
        if (scanner.hasNextDouble()) {
            double input = scanner.nextDouble();
            if (input == 0 && !allowZero) {
                System.out.println("0 は無効な入力です。デフォルト値 '1' を使用します。");
                return 1.0;
            }
            return input;
        } else {
            System.out.println("無効な入力が検出されました。デフォルト値 '0' を使用します。");
            scanner.nextLine();
            return 0;
        }
    }

    private static int getValidatedNaturalNumberInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("0 以下は無効な入力です。デフォルト値 '1' を使用します。");
                return 1;
            }
            return input;
        } else {
            System.out.println("無効な入力が検出されました。デフォルト値 '1' を使用します。");
            scanner.nextLine();
            return 1;
        }
    }
}