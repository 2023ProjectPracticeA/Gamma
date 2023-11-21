package step6_G3;

/*
 * 課題番号      ： 第8回 演習問題G3-2
 * ファイル名    ： LinEq.java
 * 作成年月日    ： 2023年11月21日
 * 学生番号・氏名：
 * グループ      ： Γ
 */


enum SolutionType {
    ONE_REAL_SOLUTION,
    NO_SOLUTION
}

public class LinEq implements EqSolver {
    private final int DEGREE = 1;
    private double a, b;
    private Complex2 x;
    private SolutionType solutionType;

    public LinEq(double a, double b) {
        this.a = a;
        this.b = b;
        this.solutionType = SolutionType.NO_SOLUTION;

        solve();
    }

    @Override
    public void solve() {
        x = new Complex2(-b / a, 0);
        solutionType = SolutionType.ONE_REAL_SOLUTION;
    }

    public String toString() {
        String s = a + "x ";

        if (b < 0) {
            s += "- " + Math.abs(b);
        } else {
            s += "+ " + b;
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
            case ONE_REAL_SOLUTION:
                System.out.println("解: 一つの実数解です．");
                x.disp();
                break;

            case NO_SOLUTION:
                System.out.println("解: まだ解かれていません．");
                break;

            default:
                break;
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Complex2 getX() {
        return x;
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
}
