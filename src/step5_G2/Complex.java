package step5_G2;

/*
 * 課題番号      ： 第5回 演習問題G2-1
 * ファイル名    ： Complex.java
 * 作成年月日    ： 2023年10月31日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

 /**
  * 複素数を表すクラス
  */
public class Complex {
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
        this.real = real;
    }

    /**
     * コンストラクター
     * @param real 実部
     * @param imag 虚部
     */
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * コンストラクター
     * @param complex 複素数
     */
    public Complex(Complex complex) {
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
        this.real = real;
    }

    /**
     * 虚部を設定する
     * @param imag 虚部
     */
    public void setImag(double imag) {
        this.imag = imag;
    }

    /**
     * 複素数を設定する
     * @param real 実部
     * @param imag 虚部
     */
    public void set(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * 複素数を設定する
     * @param complex 複素数
     */
    public void set(Complex complex) {
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
