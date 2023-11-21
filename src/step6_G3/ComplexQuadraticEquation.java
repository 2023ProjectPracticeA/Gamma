package step6_G3;

/*
 * 課題番号      ： 第8回 演習問題G3-2
 * ファイル名    ： ComplexQuadraticEquation.java
 * 作成年月日    ： 2023年11月21日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

enum ComplexQuadraticEquationSolutionType {
    TWO_REAL_SOLUTIONS,
    TWO_COMPLEX_SOLUTIONS,
    ONE_REAL_REPEATED_SOLUTION,
    ONE_PURELY_IMAGINARY_REPEATED_SOLUTION,
    ONE_COMPLEX_REPEATED_SOLUTION,
    ONE_REAL_ONE_COMPLEX_SOLUTION,
    NO_SOLUTION
}

public class ComplexQuadraticEquation implements EqSolver {
    private final int DEGREE = 2;
    private Complex2 a, b, c;
    private Complex2 x1, x2;
    private ComplexQuadraticEquationSolutionType solutionType;

    public ComplexQuadraticEquation(Complex2 a, Complex2 b, Complex2 c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.solutionType = ComplexQuadraticEquationSolutionType.NO_SOLUTION;

        solve();
    }

    @Override
    public void solve() {
        Complex2 discriminant = b.timesPure(b).minusPure(a.timesPure(c).timesPure(4));
        x1 = new Complex2(-1).timesPure(b).plusPure(discriminant.sqrt()).overPure(a.timesPure(2));
        x2 = new Complex2(-1).timesPure(b).minusPure(discriminant.sqrt()).overPure(a.timesPure(2));

        if (x1.equals(x2)) {
            if (x1.isPurelyReal()) {
                solutionType = ComplexQuadraticEquationSolutionType.ONE_REAL_REPEATED_SOLUTION;
            } else if (x1.isPurelyImaginary()) {
                solutionType = ComplexQuadraticEquationSolutionType.ONE_PURELY_IMAGINARY_REPEATED_SOLUTION;
            }else{
                solutionType = ComplexQuadraticEquationSolutionType.ONE_COMPLEX_REPEATED_SOLUTION;
            }
        } else {
            if (x1.isPurelyImaginary() && x2.isPurelyImaginary()) {
                solutionType = ComplexQuadraticEquationSolutionType.TWO_REAL_SOLUTIONS;
            } else if (x1.isPurelyImaginary() && x2.isPurelyImaginary()) {
                solutionType = ComplexQuadraticEquationSolutionType.TWO_COMPLEX_SOLUTIONS;
            } else {
                solutionType = ComplexQuadraticEquationSolutionType.ONE_REAL_ONE_COMPLEX_SOLUTION;
            }
        }
    }

    public String toString() {
        String s = "(" + a.toString() + ")" + "x² ";
        s += "(" + b.toString() + ")" + "x ";
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
                System.out.println("解: 2 つの解です．");
                x1.disp();
                x2.disp();
                break;
                
            case TWO_COMPLEX_SOLUTIONS:
                System.out.println("解: 2 つの解です．");
                x1.disp();
                x2.disp();
                break;

            case ONE_REAL_REPEATED_SOLUTION:
                System.out.println("解: 重解です．");
                x1.disp();
                break;

            case ONE_PURELY_IMAGINARY_REPEATED_SOLUTION:
                System.out.println("解: 重解です．");
                x1.disp();
                break;

            case ONE_COMPLEX_REPEATED_SOLUTION:
                System.out.println("解: 重解です．");
                x1.disp();
                break;

            case ONE_REAL_ONE_COMPLEX_SOLUTION:
                System.out.println("解: 重解です．");
                x1.disp();
                x2.disp();
                break;

            case NO_SOLUTION:
                System.out.println("解: まだ解かれていません．");
                break;
        }
    }

    public Complex2 getA() {
        return a;
    }

    public Complex2 getB() {
        return b;
    }

    public Complex2 getC() {
        return c;
    }

    public Complex2 getX1() {
        return x1;
    }

    public Complex2 getX2() {
        return x2;
    }

    public ComplexQuadraticEquationSolutionType getSolutionType() {
        return solutionType;
    }

    public int getDegree() {
        return DEGREE;
    }

    public void setA(Complex2 a) {
        this.a = a;
        solve();
    }

    public void setB(Complex2 b) {
        this.b = b;
        solve();
    }

    public void setC(Complex2 c) {
        this.c = c;
        solve();
    }

}
