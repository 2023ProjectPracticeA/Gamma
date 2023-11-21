package step6_G3;

/*
 * 課題番号      ： 第8回 演習問題G3-2
 * ファイル名    ： LinEq.java
 * 作成年月日    ： 2023年11月21日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

enum LinEqSolutionType {
    ONE_REAL_SOLUTION,
    NO_SOLUTION
}

public class LinEq implements EqSolver {
    private final int DEGREE = 1;
    private Complex2 a, b;
    private Complex2 x;
    private LinEqSolutionType solutionType;

    public LinEq(Complex2 a, Complex2 b) {
        this.a = a;
        this.b = b;
        this.solutionType = LinEqSolutionType.NO_SOLUTION;

        solve();
    }

    @Override
    public void solve() {
        x = new Complex2(-1);
        x.times(b);
        x.over(a);
        solutionType = LinEqSolutionType.ONE_REAL_SOLUTION;
    }

    public String toString() {
        return "(" + a.toString() + ")" + "x " + b.toString() + " = 0";
    }

    @Override
    public void dispEq() {
        System.out.println(toString());
    }

    @Override
    public void dispAns() {
        switch (solutionType) {
            case ONE_REAL_SOLUTION:
                if (x.isPurelyReal()) {
                    System.out.println("解: 一つの実数解です．");
                } else {
                    System.out.println("解: 一つの複素数解です．");
                }
                x.disp();
                break;

            case NO_SOLUTION:
                System.out.println("解: まだ解かれていません．");
                break;

            default:
                break;
        }
    }

    public Complex2 getA() {
        return a;
    }

    public Complex2 getB() {
        return b;
    }

    public Complex2 getX() {
        return x;
    }

    public LinEqSolutionType getSolutionType() {
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
}
