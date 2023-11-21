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

        int degree = getValidatedNaturalNumberInput(scanner, "方程式の次数 >> ");

        double a, b, c;

        switch (degree) {
            case 1:
                Complex2 aComplex, bComplex;
                System.out.println("係数が複素数の一次方程式を解きます．");
                System.out.println("係数を入力して下さい．");
                System.out.println("x の係数");
                a = getValidatedDoubleInput(scanner, " 実部 >>");
                b = getValidatedDoubleInput(scanner, " 虚部 >> ");
                aComplex = new Complex2(a, b);
                if (aComplex.equals(new Complex2(0))) {
                    System.out.println("x の係数が 0 です．");
                    System.out.println("一次方程式ではありません．");
                    System.out.println("デフォルト値 '1' を使用します。");
                    aComplex = new Complex2(1);
                }
                System.out.println("定数項");
                a = getValidatedDoubleInput(scanner, " 実部 >>");
                b = getValidatedDoubleInput(scanner, " 虚部 >> ");
                bComplex = new Complex2(a, b);
                LinEq linEquation = new LinEq(aComplex, bComplex);
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
                System.out.println("多項式方程式を解きます．");
                System.out.println("係数を入力して下さい．");
                double[] coefficients = new double[degree + 1];
                for (int i = degree; i >= 0; i--) {
                    coefficients[i] = getValidatedDoubleInput(scanner, "x" + toSuperscript(i) + " の係数 >> ");
                }
                PolynomialEquation polyEquation = new PolynomialEquation(coefficients);
                polyEquation.solve();
                System.out.println();
                System.out.println("方程式：");
                polyEquation.dispEq();
                System.out.println();
                polyEquation.dispAns();
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

    public static String toSuperscript(int num) {
        String str = String.valueOf(num);
        String superscript = "";
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '0': superscript += "⁰"; break;
                case '1': superscript += "¹"; break;
                case '2': superscript += "²"; break;
                case '3': superscript += "³"; break;
                case '4': superscript += "⁴"; break;
                case '5': superscript += "⁵"; break;
                case '6': superscript += "⁶"; break;
                case '7': superscript += "⁷"; break;
                case '8': superscript += "⁸"; break;
                case '9': superscript += "⁹"; break;
            }
        }
        return superscript;
    }
}