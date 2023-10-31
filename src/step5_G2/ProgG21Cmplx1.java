package step5_G2;

// 入力のパッケージをインポート
import java.util.Scanner;

/*
 * 課題番号      ： 第5回 演習問題G2-1
 * ファイル名    ： ProgG21Cmplx1.java
 * 作成年月日    ： 2023年10月31日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

public class ProgG21Cmplx1 {
    /**
     * 複素共役を返す
     * 
     * @param complex 複素数
     * @return 複素共役
     */
    public static Complex conj(Complex complex) {
        return new Complex(complex.getReal(), -complex.getImag());
    }

    /**
     * 複素数の絶対値を返す
     * 
     * @param complex 複素数
     * @return 絶対値
     */
    public static double abs(Complex complex) {
        return Math.sqrt(complex.getReal() * complex.getReal() + complex.getImag() * complex.getImag());
    }

    /**
     * エントリーポイント
     * 
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // 複素数を 4 つ定義

        // 複素数 z1
        Complex z1;

        // 複素数 z2
        Complex z2;

        // 複素数 z3
        Complex z3;

        // 複素数 z4
        Complex z4;

        // 実数 a
        double a = 0.0;

        // 入力を受け付けるオブジェクトを生成
        Scanner scanner = new Scanner(System.in);

        System.out.println("＿/＿/＿/ データ入力 ＿/＿/＿/ ");
        System.out.println();

        System.out.println("複素数を4つ定義します． ");

        System.out.println("z1:");
        System.out.print("  実部 = ");

        // 実部を入力
        if (scanner.hasNextDouble()) {
            double real = scanner.nextDouble();

            System.out.print("  虚部 = ");

            // 虚部を入力
            if (scanner.hasNextDouble()) {
                double imag = scanner.nextDouble();
                z1 = new Complex(real, imag);
            } else {
                System.out.println("!!!入力値が不正です．デフォルト値を設定します．");
                z1 = new Complex();
            }
        } else {
            System.out.println("!!!入力値が不正です．デフォルト値を設定します．");

            System.out.print("  虚部 = ");

            // 虚部を入力
            if (scanner.hasNextDouble()) {
                double imag = scanner.nextDouble();
                z1 = new Complex(0, imag);
            } else {
                System.out.println("!!!入力値が不正です．デフォルト値を設定します．");
                z1 = new Complex();
            }
        }

        System.out.println("z2:");
        System.out.print("  実部 = ");

        // 実部を入力
        if (scanner.hasNextDouble()) {
            double real = scanner.nextDouble();

            System.out.print("  虚部 = ");

            // 虚部を入力
            if (scanner.hasNextDouble()) {
                double imag = scanner.nextDouble();
                z2 = new Complex(real, imag);
            } else {
                System.out.println("!!!入力値が不正です．デフォルト値を設定します．");
                z2 = new Complex();
            }
        } else {
            System.out.println("!!!入力値が不正です．デフォルト値を設定します．");

            System.out.print("  虚部 = ");

            // 虚部を入力
            if (scanner.hasNextDouble()) {
                double imag = scanner.nextDouble();
                z2 = new Complex(0, imag);
            } else {
                System.out.println("!!!入力値が不正です．デフォルト値を設定します．");
                z2 = new Complex();
            }
        }

        System.out.println("z3:");
        System.out.print("  実部 = ");

        // 実部を入力
        if (scanner.hasNextDouble()) {
            double real = scanner.nextDouble();

            System.out.print("  虚部 = 0 とします．");

            z3 = new Complex(real, 0);
        } else {
            System.out.println("!!!入力値が不正です．デフォルト値を設定します．");
            z3 = new Complex();
        }

        System.out.println("z4:");
        System.out.print("  実部 = 虚部 = 0 とします． ");

        z4 = new Complex(0, 0);

        System.out.println();

        System.out.println("実数を1つ定義します．");
        System.out.print("  実数a = ");

        // 実数を入力
        if (scanner.hasNextDouble()) {
            a = scanner.nextDouble();
        } else {
            System.out.println("!!!入力値が不正です．デフォルト値「0.0」を設定します．");
        }

        // 入力を閉じる
        scanner.close();

        System.out.println();

        System.out.println("＿/＿/＿/ データ出力 ＿/＿/＿/ ");
        System.out.println();

        System.out.println("複素数の入力値");

        System.out.println("  z1 = ");
        z1.disp();

        System.out.println("  z2 = ");
        z2.disp();

        System.out.println("  z3 = ");
        z3.disp();

        System.out.println("  z4 = ");
        z4.disp();

        System.out.println();

        System.out.println("複素共役値");

        System.out.println("  z1* = ");
        conj(z1).disp();

        System.out.println("  z2* = ");
        conj(z2).disp();

        System.out.println("  z3* = ");
        conj(z3).disp();

        System.out.println("  z4* = ");
        conj(z4).disp();

        System.out.println();

        System.out.println("絶対値");

        System.out.println("  |z1| = " + abs(z1));

        System.out.println("  |z2| = " + abs(z2));

        System.out.println("  |z3| = " + abs(z3));

        System.out.println("  |z4| = " + abs(z4));

        System.out.println();

        System.out.println("実数との四則演算");

        System.out.println("  z1 + a = ");
        z1.plus(a).disp();

        System.out.println("  z2 - a = ");
        z2.minus(a).disp();

        System.out.println("  z1 x a = ");
        z1.times(a).disp();

        System.out.println("  z2 / a = ");

        // 0 で割ることはできない
        if (a == 0) {
            System.out.println("!!!0で割ることはできません．");
        } else {
            z2.over(a).disp();
        }

        System.out.println();

        System.out.println("複素数同士の四則演算");

        System.out.println("  z1 + z2 = ");
        z1.plus(z2).disp();

        System.out.println("  z1 - z2 = ");
        z1.minus(z2).disp();

        System.out.println("  z1 x z2 = ");
        z1.times(z2).disp();

        System.out.println("  z1 / z2 = ");

        // 0 で割ることはできない
        if (z2.getReal() == 0 && z2.getImag() == 0) {
            System.out.println("!!!0で割ることはできません．");
        } else {
            z1.over(z2).disp();
        }
    }
}
