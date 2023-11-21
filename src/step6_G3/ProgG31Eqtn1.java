package step6_G3;

import java.util.Scanner;

/*
 * 課題番号      ： 第7回 演習問題G3-1
 * ファイル名    ： ProgG31Eqtn1.java
 * 作成年月日    ： 2023年11月14日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

enum SolutionType {
    TWO_REAL_SOLUTIONS,
    ONE_REPEATED_SOLUTION,
    COMPLEX_SOLUTIONS,
    NO_SOLUTION
}

interface EqSolver {
    void solve();

    void dispEq();

    void dispAns();
}

class QuadEq implements EqSolver {
    private final int DEGREE = 2;
    private double a, b, c;
    private Complex2 x1, x2;
    private SolutionType solutionType;

    public QuadEq(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.solutionType = SolutionType.NO_SOLUTION;

        solve();
    }

    @Override
    public void solve() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            x1 = new Complex2((-b + Math.sqrt(discriminant)) / (2 * a), 0);
            x2 = new Complex2((-b - Math.sqrt(discriminant)) / (2 * a), 0);
            solutionType = SolutionType.TWO_REAL_SOLUTIONS;
        } else if (discriminant == 0) {
            x1 = x2 = new Complex2(-b / (2 * a), 0);
            solutionType = SolutionType.ONE_REPEATED_SOLUTION;
        } else if (discriminant < 0) {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            x1 = new Complex2(realPart, imaginaryPart);
            x2 = new Complex2(realPart, -imaginaryPart);
            solutionType = SolutionType.COMPLEX_SOLUTIONS;
        }
    }

    public String toString() {
        String s = a + "x² ";

        if (b < 0) {
            s += "- " + Math.abs(b) + "x ";
        } else {
            s += "+ " + b + "x ";
        }

        if (c < 0) {
            s += "- " + Math.abs(c);
        } else {
            s += "+ " + c;
        }

        return s + " = 0";
    }

    @Override
    public void dispEq() {
        System.out.println(toString());
    }

    @Override
    public void dispAns() {
        switch (solutionType) {
        case TWO_REAL_SOLUTIONS:
            System.out.println("解: 2 つの実数解です．");
            x1.disp();
            x2.disp();
            break;

        case ONE_REPEATED_SOLUTION:
            System.out.println("解: 重解です．");
            x1.disp();
            x2.disp();
            break;

        case COMPLEX_SOLUTIONS:
            System.out.println("解: 複素数解です．");
            x1.disp();
            x2.disp();
            break;
            
        case NO_SOLUTION:
            System.out.println("解: まだ解かれていません．");
            break;
    }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public Complex2 getX1() {
        return x1;
    }

    public Complex2 getX2() {
        return x2;
    }

    public SolutionType getSolutionType() {
        return solutionType;
    }

    public int getDegree() {
        return DEGREE;
    }

    public void setA(double a) {
        this.a = a;
        solve();
    }

    public void setB(double b) {
        this.b = b;
        solve();
    }

    public void setC(double c) {
        this.c = c;
        solve();
    }
}

public class ProgG31Eqtn1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("2 次方程式を解きます．");
        System.out.println("係数を入力して下さい．");

        double a = getValidatedInput(scanner, "x²の係数 >> ");

        if (a == 0) {
            System.out.println("x²の係数が0です．");
            System.out.println("2次方程式ではありません．");
            System.out.println("デフォルト値 '1' を使用します。");
            a = 1;
        }

        double b = getValidatedInput(scanner, "xの係数 >> ");
        double c = getValidatedInput(scanner, "定数項 >> ");

        QuadEq equation = new QuadEq(a, b, c);

        equation.solve();

        System.out.println();

        System.out.println("方程式：");
        equation.dispEq();

        System.out.println();
        equation.dispAns();

        scanner.close();
    }

    private static double getValidatedInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            System.out.println("無効な入力が検出されました。デフォルト値 '1' を使用します。");
            scanner.next();
            return 1.0;
        }
    }
}
