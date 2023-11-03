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

 /**
  * 複素数を表すクラス
  */
class Complex {
    // 複素数の実部
    private double real = 0.0;

    // 複素数の虚部
    private double imag = 0.0;

    /**
     * コンストラクター
     */
    public Complex() {
    }

    /**
     * コンストラクター
     * @param real 実部
     */
    public Complex(double real) {
        // 実部が NaN の場合は NaN を設定する
        if (real == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.real = real;
    }

    /**
     * コンストラクター
     * @param real 実部
     * @param imag 虚部
     */
    public Complex(double real, double imag) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (real == Double.NaN || imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.real = real;
        this.imag = imag;
    }

    /**
     * コンストラクター
     * @param complex 複素数
     */
    public Complex(Complex complex) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (complex.real == Double.NaN || complex.imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.real = complex.real;
        this.imag = complex.imag;
    }

    /**
     * 実部を返す
     * @return 実部
     */
    public double getReal() {
        return this.real;
    }

    /**
     * 虚部を返す
     * @return 虚部
     */
    public double getImag() {
        return this.imag;
    }

    /**
     * 実部を設定する
     * @param real 実部
     */
    public void setReal(double real) {
        // 実部が NaN の場合は NaN を設定する
        if (real == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.real = real;
    }

    /**
     * 虚部を設定する
     * @param imag 虚部
     */
    public void setImag(double imag) {
        // 虚部が NaN の場合は NaN を設定する
        if (imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.imag = imag;
    }

    /**
     * 複素数を設定する
     * @param real 実部
     * @param imag 虚部
     */
    public void set(double real, double imag) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (real == Double.NaN || imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.real = real;
        this.imag = imag;
    }

    /**
     * 複素数を設定する
     * @param complex 複素数
     */
    public void set(Complex complex) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (complex.real == Double.NaN || complex.imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            return;
        }
        this.real = complex.real;
        this.imag = complex.imag;
    }

    /**
     * 実数と複素数の和を返す
     * @param real 実数
     * @param complex 複素数
     * @return 実数と複素数の和
     */
    public static Complex plus(double real, Complex complex) {
        return new Complex(real + complex.real, complex.imag);
    }

    /**
     * 複素数と実数の和を返す
     * @param complex 複素数
     * @param real 実数
     * @return 複素数と実数の和
     */
    public static Complex plus(Complex complex, double real) {
        return new Complex(complex.real + real, complex.imag);
    }

    /**
     * 複素数と複素数の和を返す
     * @param complex1 複素数
     * @param complex2 複素数
     * @return 複素数と複素数の和
     */
    public static Complex plus(Complex complex1, Complex complex2) {
        return new Complex(complex1.real + complex2.real, complex1.imag + complex2.imag);
    }

    /**
     * 実数と複素数の差を返す
     * @param real 実数
     * @param complex 複素数
     * @return 実数と複素数の差
     */
    public static Complex minus(double real, Complex complex) {
        return new Complex(real - complex.real, -complex.imag);
    }

    /**
     * 複素数と実数の差を返す
     * @param complex 複素数
     * @param real 実数
     * @return 複素数と実数の差
     */
    public static Complex minus(Complex complex, double real) {
        return new Complex(complex.real - real, complex.imag);
    }

    /**
     * 複素数と複素数の差を返す
     * @param complex1 複素数
     * @param complex2 複素数
     * @return 複素数と複素数の差
     */
    public static Complex minus(Complex complex1, Complex complex2) {
        return new Complex(complex1.real - complex2.real, complex1.imag - complex2.imag);
    }

    /**
     * 実数と複素数の積を返す
     * @param real 実数
     * @param complex 複素数
     * @return 実数と複素数の積
     */
    public static Complex times(double real, Complex complex) {
        return new Complex(real * complex.real, real * complex.imag);
    }

    /**
     * 複素数と実数の積を返す
     * @param complex 複素数
     * @param real 実数
     * @return 複素数と実数の積
     */
    public static Complex times(Complex complex, double real) {
        return new Complex(real * complex.real, real * complex.imag);
    }

    /**
     * 複素数と複素数の積を返す
     * @param complex1 複素数
     * @param complex2 複素数
     * @return 複素数と複素数の積
     */
    public static Complex times(Complex complex1, Complex complex2) {
        return new Complex(complex1.real * complex2.real - complex1.imag * complex2.imag,
                complex1.real * complex2.imag + complex1.imag * complex2.real);
    }

    /**
     * 実数を複素数で割った商を返す
     * @param real 実数
     * @param complex 複素数
     * @return 実数を複素数で割った商
     */
    public static Complex over(double real, Complex complex) {
        return new Complex((real * complex.real) / (complex.real * complex.real + complex.imag * complex.imag),
                (-real * complex.imag) / (complex.real * complex.real + complex.imag * complex.imag));
    }

    /**
     * 複素数を実数で割った商を返す
     * @param complex 複素数
     * @param real 実数
     * @return 複素数を実数で割った商
     */
    public static Complex over(Complex complex, double real) {
        return new Complex(complex.real / real, complex.imag / real);
    }

    /**
     * 複素数を複素数で割った商を返す
     * @param complex1 複素数
     * @param complex2 複素数
     * @return 複素数を複素数で割った商
     */
    public static Complex over(Complex complex1, Complex complex2) {
        return new Complex((complex1.real * complex2.real + complex1.imag * complex2.imag)
                / (complex2.real * complex2.real + complex2.imag * complex2.imag),
                (complex1.imag * complex2.real - complex1.real * complex2.imag)
                        / (complex2.real * complex2.real + complex2.imag * complex2.imag));
    }

    /**
     * 実数との和
     * @param real 実数
     * @return 実数との和
     */
    public Complex plus(double real) {
        return Complex.plus(this, real);
    }

    /**
     * 複素数との和
     * @param complex 複素数
     * @return 複素数との和
     */
    public Complex plus(Complex complex) {
        return Complex.plus(this, complex);
    }

    /**
     * 実数との差
     * @param real 実数
     * @return 実数との差
     */
    public Complex minus(double real) {
        return Complex.minus(this, real);
    }

    /**
     * 複素数との差
     * @param complex 複素数
     * @return 複素数との差
     */
    public Complex minus(Complex complex) {
        return Complex.minus(this, complex);
    }

    /**
     * 実数との積
     * @param real 実数
     * @return 実数との積
     */
    public Complex times(double real) {
        return Complex.times(this, real);
    }

    /**
     * 複素数との積
     * @param complex 複素数
     * @return 複素数との積
     */
    public Complex times(Complex complex) {
        return Complex.times(this, complex);
    }

    /**
     * 実数で割った商
     * @param real 実数
     * @return 実数で割った商
     */
    public Complex over(double real) {
        return Complex.over(this, real);
    }

    /**
     * 複素数で割った商
     * @param complex 複素数
     * @return 複素数で割った商
     */
    public Complex over(Complex complex) {
        return Complex.over(this, complex);
    }
        
    /**
     * 複素数を標準出力する
     * @param complex 標準出力する複素数
     */
    public static void disp(Complex complex) {
        if (complex.real == Double.NaN || complex.imag == Double.NaN) {
            System.out.println("NaN");
            return;
        }

        if (complex.imag >= 0) {
            System.out.println(complex.real + " + " + complex.imag + "i");
        } else {
            System.out.println(complex.real + " - " + (-complex.imag) + "i");
        }
    }

    /**
     * 複素数を標準出力する
     */
    public void disp() {
        Complex.disp(this);
    }
}

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

            System.out.println("  虚部 = 0 とします．");

            z3 = new Complex(real, 0);
        } else {
            System.out.println("!!!入力値が不正です．デフォルト値を設定します．");
            z3 = new Complex();
        }

        System.out.println("z4:");
        System.out.println("  実部 = 虚部 = 0 とします． ");

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
