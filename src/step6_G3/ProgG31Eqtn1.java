package step6_G3;

/*
 * 課題番号      ： 第7回 演習問題G3-1
 * ファイル名    ： ProgG31Eqtn1.java
 * 作成年月日    ： 2023年11月14日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

/**
 * 複素数の拡張を表す数を表すクラス
 */
class Complex2 {
    // 複素数の拡張を表す数の実部
    private double real = 0.0;

    // 複素数の拡張を表す数の第一虚部
    private double imag = 0.0;

    // 複素数の拡張を表す数の第二虚部
    private double j = 0.0;

    // 複素数の拡張を表す数の第三虚部
    private double k = 0.0;

    /**
     * コンストラクター
     */
    public Complex2() {
    }

    /**
     * コンストラクター
     * 
     * @param real 実部
     */
    public Complex2(double real) {
        // 実部が NaN の場合は NaN を設定する
        if (real == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.real = real;
    }

    /**
     * コンストラクター
     * 
     * @param real 複素数の実部
     * @param imag 複素数の虚部
     */
    public Complex2(double real, double imag) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (real == Double.NaN || imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }

        this.real = real;
        this.imag = imag;
    }

    /**
     * コンストラクター
     * 
     * @param real 複素数の拡張を表す数の実部
     * @param imag 複素数の拡張を表す数の第一虚部
     * @param j    複素数の拡張を表す数の第二虚部
     * @param k    複素数の拡張を表す数の第三虚部
     */
    public Complex2(double real, double imag, double j, double k) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (real == Double.NaN || imag == Double.NaN || j == Double.NaN || k == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.real = real;
        this.imag = imag;
        this.j = j;
        this.k = k;
    }

    /**
     * コンストラクター
     * 
     * @param complex 複素数の拡張を表す数
     */
    public Complex2(Complex2 complex) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (complex.real == Double.NaN || complex.imag == Double.NaN || complex.j == Double.NaN
                || complex.k == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.real = complex.real;
        this.imag = complex.imag;
        this.j = complex.j;
        this.k = complex.k;
    }

    /**
     * 実部を返す
     * 
     * @return 実部
     */
    public double getReal() {
        return real;
    }

    /**
     * 第一虚部を返す
     * 
     * @return 第一虚部
     */
    public double getImag() {
        return imag;
    }

    /**
     * 第二虚部を返す
     * 
     * @return 第二虚部
     */
    public double getJ() {
        return j;
    }

    /**
     * 第三虚部を返す
     * 
     * @return 第三虚部
     */
    public double getK() {
        return k;
    }

    /**
     * 複素数の拡張を表す数の実部を設定する
     * 
     * @param real 複素数の拡張を表す数の実部
     */
    public void setReal(double real) {
        // NaN の場合は NaN を設定する
        if (real == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.real = real;
    }

    /**
     * 複素数の拡張を表す数の第一虚部を設定する
     * 
     * @param imag 複素数の拡張を表す数の第一虚部
     */
    public void setImag(double imag) {
        // NaN の場合は NaN を設定する
        if (imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.imag = imag;
    }

    /**
     * 複素数の拡張を表す数の第二虚部を設定する
     * 
     * @param j 複素数の拡張を表す数の第二虚部
     */
    public void setJ(double j) {
        // NaN の場合は NaN を設定する
        if (j == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.j = j;
    }

    /**
     * 複素数の拡張を表す数の第三虚部を設定する
     * 
     * @param k 複素数の拡張を表す数の第三虚部
     */
    public void setK(double k) {
        // NaN の場合は NaN を設定する
        if (k == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.k = k;
    }

    /**
     * 複素数の拡張を表す数の実部と第一虚部を設定する
     * 
     * @param real 複素数の拡張を表す数の実部
     * @param imag 複素数の拡張を表す数の第一虚部
     */
    public void setComplex(double real, double imag) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (real == Double.NaN || imag == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.real = real;
        this.imag = imag;
    }

    /**
     * 複素数の拡張を表す数を設定する
     * 
     * @param real 複素数の拡張を表す数の実部
     * @param imag 複素数の拡張を表す数の第一虚部
     * @param j    複素数の拡張を表す数の第二虚部
     * @param k    複素数の拡張を表す数の第三虚部
     */
    public void set(double real, double imag, double j, double k) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (real == Double.NaN || imag == Double.NaN || j == Double.NaN || k == Double.NaN) {
            this.real = Double.NaN;
            this.imag = Double.NaN;
            this.j = Double.NaN;
            this.k = Double.NaN;
            return;
        }
        this.real = real;
        this.imag = imag;
        this.j = j;
        this.k = k;
    }

    /**
     * 複素数の拡張を表す数を設定する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public void set(Complex2 complex) {
        // 実部または虚部が NaN の場合は NaN を設定する
        if (complex.real == Double.NaN || complex.imag == Double.NaN || complex.j == Double.NaN
                || complex.k == Double.NaN) {
            real = Double.NaN;
            imag = Double.NaN;
            j = Double.NaN;
            k = Double.NaN;
            return;
        }
        real = complex.real;
        imag = complex.imag;
        j = complex.j;
        k = complex.k;
    }

    /**
     * 実数と複素数の拡張を表す数の和を返す
     * 
     * @param real    実数
     * @param complex 複素数の拡張を表す数
     * @return 実数と複素数の拡張を表す数の和
     */
    public static Complex2 plus(double real, Complex2 complex) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 実数と複素数の拡張を表す数の和を設定する
        newComplex.plus(real);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数と実数の和を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @param real    実数
     * @return 複素数の拡張を表す数と実数の和
     */
    public static Complex2 plus(Complex2 complex, double real) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 複素数の拡張を表す数と実数の和を設定する
        newComplex.plus(real);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数と複素数の拡張を表す数の和を返す
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 複素数の拡張を表す数と複素数の拡張を表す数の和
     */
    public static Complex2 plus(Complex2 complex1, Complex2 complex2) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex1);

        // 複素数の拡張を表す数と複素数の拡張を表す数の和を設定する
        newComplex.plus(complex2);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 実数と複素数の拡張を表す数の差を返す
     * 
     * @param real    実数
     * @param complex 複素数の拡張を表す数
     * @return 実数と複素数の拡張を表す数の差
     */
    public static Complex2 minus(double real, Complex2 complex) {
        return new Complex2(real - complex.real, complex.imag, complex.j, complex.k);
    }

    /**
     * 複素数の拡張を表す数と実数の差を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @param real    実数
     * @return 複素数の拡張を表す数と実数の差
     */
    public static Complex2 minus(Complex2 complex, double real) {
        return new Complex2(complex.real - real, complex.imag, complex.j, complex.k);
    }

    /**
     * 複素数の拡張を表す数と複素数の拡張を表す数の差を返す
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 複素数の拡張を表す数と複素数の拡張を表す数の差
     */
    public static Complex2 minus(Complex2 complex1, Complex2 complex2) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex1);

        // 複素数の拡張を表す数と複素数の拡張を表す数の差を設定する
        newComplex.minus(complex2);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 実数と複素数の拡張を表す数の積を返す
     * 
     * @param real    実数
     * @param complex 複素数の拡張を表す数
     * @return 実数と複素数の拡張を表す数の積
     */
    public static Complex2 times(double real, Complex2 complex) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 実数と複素数の拡張を表す数の積を設定する
        newComplex.times(real);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数と実数の積を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @param real    実数
     * @return 複素数の拡張を表す数と実数の積
     */
    public static Complex2 times(Complex2 complex, double real) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 複素数の拡張を表す数と実数の積を設定する
        newComplex.times(real);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数と複素数の拡張を表す数の積を返す
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 複素数の拡張を表す数と複素数の拡張を表す数の積
     */
    public static Complex2 times(Complex2 complex1, Complex2 complex2) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex1);

        // 複素数の拡張を表す数と複素数の拡張を表す数の積を設定する
        newComplex.times(complex2);

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 実数を複素数の拡張を表す数で割った商を返す
     * 
     * @param real    実数
     * @param complex 複素数の拡張を表す数
     * @return 実数を複素数の拡張を表す数で割った商
     */
    public static Complex2 over(double real, Complex2 complex) {
        return new Complex2(real / complex.real, real / complex.imag, real / complex.j, real / complex.k);
    }

    /**
     * 複素数の拡張を表す数を実数で割った商を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @param real    実数
     * @return 複素数の拡張を表す数を実数で割った商
     */
    public static Complex2 over(Complex2 complex, double real) {
        return new Complex2(complex.real / real, complex.imag / real, complex.j / real, complex.k / real);
    }

    /**
     * 複素数の拡張を表す数を複素数の拡張を表す数で割った商を返す
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 複素数の拡張を表す数を複素数の拡張を表す数で割った商
     */
    public static Complex2 over(Complex2 complex1, Complex2 complex2) {
        return Complex2.times(complex1, Complex2.inv(complex2));
    }

    /**
     * 実数との和を返す
     * 
     * @param real 実数
     * @return 実数との和
     */
    public Complex2 plusPure(double real) {
        return Complex2.plus(this, real);
    }

    /**
     * 複素数の拡張を表す数との和を返す
     * オブジェクトを変更しない
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数との和
     */
    public Complex2 plusPure(Complex2 complex) {
        return Complex2.plus(this, complex);
    }

    /**
     * 実数との差を返す
     * オブジェクトを変更しない
     * 
     * @param real 実数
     * @return 実数との差
     */
    public Complex2 minusPure(double real) {
        return Complex2.minus(this, real);
    }

    /**
     * 複素数の拡張を表す数との差を返す
     * オブジェクトを変更しない
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数との差
     */
    public Complex2 minusPure(Complex2 complex) {
        return Complex2.minus(this, complex);
    }

    /**
     * 実数との積を返す
     * オブジェクトを変更しない
     * 
     * @param real 実数
     * @return 実数との積
     */
    public Complex2 timesPure(double real) {
        return Complex2.times(this, real);
    }

    /**
     * 複素数の拡張を表す数との積を返す
     * オブジェクトを変更しない
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数との積
     */
    public Complex2 timesPure(Complex2 complex) {
        return Complex2.times(this, complex);
    }

    /**
     * 実数で割った商を返す
     * オブジェクトを変更しない
     * 
     * @param real 実数
     * @return 実数で割った商
     */
    public Complex2 overPure(double real) {
        return Complex2.over(this, real);
    }

    /**
     * 複素数の拡張を表す数で割った商を返す
     * オブジェクトを変更しない
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数で割った商
     */
    public Complex2 overPure(Complex2 complex) {
        return Complex2.over(this, complex);
    }

    /**
     * 実数との和を設定する
     * 
     * @param real
     */
    public void plus(double real) {
        setReal(real + real);
    }

    /**
     * 複素数の拡張を表す数との和を設定する
     * 
     * @param real 実部
     * @param imag 第一虚部
     * @param j    第二虚部
     * @param k    第三虚部
     */
    public void plus(double real, double imag, double j, double k) {
        setReal(this.real + real);
        setImag(this.imag + imag);
        setJ(this.j + j);
        setK(this.k + k);
    }

    /**
     * 複素数の拡張を表す数との和を設定する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public void plus(Complex2 complex) {
        plus(complex.real, complex.imag, complex.j, complex.k);
    }

    /**
     * 実数との差を設定する
     * 
     * @param real 実数
     */
    public void minus(double real) {
        this.setReal(this.real - real);
    }

    /**
     * 複素数の拡張を表す数との差を設定する
     * 
     * @param real 実部
     * @param imag 第一虚部
     * @param j    第二虚部
     * @param k    第三虚部
     */
    public void minus(double real, double imag, double j, double k) {
        setReal(this.real - real);
        setImag(this.imag - imag);
        setJ(this.j - j);
        setK(this.k - k);
    }

    /**
     * 複素数の拡張を表す数との差を設定する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public void minus(Complex2 complex) {
        minus(complex.real, complex.imag, complex.j, complex.k);
    }

    /**
     * 実数との積を設定する
     * 
     * @param real 実数
     */
    public void times(double real) {
        setReal(real * real);
        setImag(real * imag);
        setJ(real * j);
        setK(real * k);
    }

    /**
     * 複素数の拡張を表す数との積を設定する
     * 
     * @param real 実部
     * @param imag 第一虚部
     * @param j    第二虚部
     * @param k    第三虚部
     */
    public void times(double real, double imag, double j, double k) {
        double newReal = this.real * real - this.imag * imag - this.j * j - this.k * k;
        double newImag = this.real * imag + this.imag * real + this.j * k - this.k * j;
        double newJ = this.real * j + this.imag * k + this.j * real + this.k * imag;
        double newK = this.real * k - this.imag * j + this.j * imag + this.k * real;

        setReal(newReal);
        setImag(newImag);
        setJ(newJ);
        setK(newK);
    }

    /**
     * 複素数の拡張を表す数との積を設定する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public void times(Complex2 complex) {
        times(complex.real, complex.imag, complex.j, complex.k);
    }

    /**
     * 実数で割った商を設定する
     * 
     * @param real 実数
     */
    public void over(double real) {
        setReal(this.real / real);
        setImag(imag / real);
        setJ(j / real);
        setK(k / real);
    }

    public void over(double real, double imag, double j, double k) {
        // 絶対値
        double abs = Math.sqrt(real * real + imag * imag + j * j + k * k);

        // 絶対値の二乗
        double absSquare = abs * abs;

        // 実数で割った商を設定する
        double newReal = (this.real * real + this.imag * imag + this.j * j + this.k * k) / absSquare;
        double newImag = (this.imag * real - this.real * imag - this.j * k + this.k * j) / absSquare;
        double newJ = (this.j * real - this.real * j + this.imag * k - this.k * imag) / absSquare;
        double newK = (this.k * real - this.real * k - this.imag * j + this.j * imag) / absSquare;

        setReal(newReal);
        setImag(newImag);
        setJ(newJ);
        setK(newK);
    }

    /**
     * 複素数の拡張を表す数で割った商を設定する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public void over(Complex2 complex) {
        over(complex.real, complex.imag, complex.j, complex.k);
    }

    /**
     * 複素数の拡張を表す数の共役を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数の共役
     */
    public static Complex2 conj(Complex2 complex) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 複素数の拡張を表す数の共役を設定する
        newComplex.conj();

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数の共役を返す
     * オブジェクトを変更しない
     * 
     * @return 複素数の拡張を表す数の共役
     */
    public Complex2 conjPure() {
        return Complex2.conj(this);
    }

    /**
     * 複素数の拡張を表す数の共役を設定する
     */
    public void conj() {
        setImag(-imag);
        setJ(-j);
        setK(-k);
    }

    /**
     * 複素数の拡張を表す数の絶対値を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数の絶対値
     */
    public static double abs(Complex2 complex) {
        return Math.sqrt(complex.real * complex.real + complex.imag * complex.imag + complex.j * complex.j
                + complex.k * complex.k);
    }

    /**
     * 複素数の拡張を表す数の絶対値を返す
     * 
     * @return 複素数の拡張を表す数の絶対値
     */
    public double abs() {
        return Complex2.abs(this);
    }

    /**
     * 複素数の拡張を表す数の逆数を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数の逆数
     */
    public static Complex2 inv(Complex2 complex) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 複素数の拡張を表す数の逆数を設定する
        newComplex.inv();

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数の逆数を返す
     * オブジェクトを変更しない
     * 
     * @return 複素数の拡張を表す数の逆数
     */
    public Complex2 invPure() {
        return Complex2.inv(this);
    }

    /**
     * 複素数の拡張を表す数の逆数を設定する
     */
    public void inv() {
        // 絶対値
        double abs = Complex2.abs(this);

        // 絶対値の二乗
        double absSquare = abs * abs;

        // 複素数の拡張を表す数の逆数を設定する
        setReal(real / absSquare);
        setImag(-imag / absSquare);
        setJ(-j / absSquare);
        setK(-k / absSquare);
    }

    /**
     * 複素数の拡張を表す数の内積を返す
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 複素数の拡張を表す数の内積
     */
    public static double dot(Complex2 complex1, Complex2 complex2) {
        return complex1.real * complex2.real + complex1.imag * complex2.imag + complex1.j * complex2.j
                + complex1.k * complex2.k;
    }

    /**
     * 複素数の拡張を表す数の内積を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数の内積
     */
    public double dot(Complex2 complex) {
        return Complex2.dot(this, complex);
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして偏角を返す
     * -π から π までの値を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の偏角
     */
    public static double arg(Complex2 complex) {
        // Math.atan2 は逆正接を返す
        // Math.atan2 は Math.atan2(y, x) で y/x の偏角を返す
        // Math.atan も逆正接を返すが、-π/2 <= Math.atan(x) <= π/2 であり、象限を考慮しない
        // Math.atan2 は -π <= Math.atan2(y, x) <= π であり、象限を考慮する
        return Math.atan2(complex.imag, complex.real);
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして偏角を返す
     * -π から π までの値を返す
     * 
     * @return 複素数の偏角
     */
    public double arg() {
        return Complex2.arg(this);
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして偏角を返す
     * -180° から 180° までの値を返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の偏角
     */
    public static double argDegree(Complex2 complex) {
        return Complex2.arg(complex) * 180.0 / Math.PI;
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして偏角を返す
     * -180° から 180° までの値を返す
     * 
     * @return 複素数の偏角
     */
    public double argDegree() {
        return Complex2.argDegree(this);
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして極形式で標準出力に出力する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public static void printPolar(Complex2 complex) {
        System.out.println("r = " + Complex2.abs(complex) + ", θ = " + Complex2.arg(complex));
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして極形式で標準出力に出力する
     */
    public void printPolar() {
        Complex2.printPolar(this);
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして極形式で標準出力に出力する
     * 偏角は度数法で表示する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public static void printPolarDegree(Complex2 complex) {
        System.out.println("r = " + Complex2.abs(complex) + ", θ = " + Complex2.argDegree(complex) + "°");
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして極形式で標準出力に出力する
     * 偏角は度数法で表示する
     */
    public void printPolarDegree() {
        Complex2.printPolarDegree(this);
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして指数形式で標準出力に出力する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public static void printExponential(Complex2 complex) {
        System.out.println("r = " + Complex2.abs(complex) + ", θ = " + Complex2.arg(complex));
    }

    /**
     * 複素数の拡張を表す数を複素数とみなして指数形式で標準出力に出力する
     */
    public void printExponential() {
        Complex2.printExponential(this);
    }

    /**
     * 複素数の拡張を表す数を文字列に変換する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public static String toString(Complex2 complex) {
        if (complex.real == Double.NaN || complex.imag == Double.NaN || complex.j == Double.NaN
                || complex.k == Double.NaN) {
            return "NaN";
        }
        String str = "";

        if (complex.real != 0.0) {
            str += complex.real;
        }

        if (complex.imag != 0.0) {
            if (complex.imag > 0.0) {
                if (complex.real != 0.0) {
                    str += " + ";
                }
            } else {
                str += " - ";
            }
            str += Math.abs(complex.imag) + "i";
        }

        if (complex.j != 0.0) {
            if (complex.j > 0.0) {
                if (complex.real != 0.0 || complex.imag != 0.0) {
                    str += " + ";
                }
            } else {
                str += " - ";
            }
            str += Math.abs(complex.j) + "j";
        }

        if (complex.k != 0.0) {
            if (complex.k > 0.0) {
                if (complex.real != 0.0 || complex.imag != 0.0 || complex.j != 0.0) {
                    str += " + ";
                }
            } else {
                str += " - ";
            }
            str += Math.abs(complex.k) + "k";
        }

        if (str.equals("")) {
            str = "0.0";
        }

        return str;
    }

    /**
     * 複素数の拡張を表す数を文字列に変換する
     * 
     * @return 複素数の拡張を表す数を文字列に変換したもの
     */
    public String toString() {
        return Complex2.toString(this);
    }

    /**
     * 複素数の拡張を表す数を標準出力に出力する
     * 
     * @param complex 複素数の拡張を表す数
     */
    public static void disp(Complex2 complex) {
        System.out.println(complex.toString());
    }

    /**
     * 複素数の拡張を表す数を標準出力に出力する
     */
    public void disp() {
        Complex2.disp(this);
    }

    /**
     * 実数と複素数の拡張を表す数が等しいかどうかを返す
     * 
     * @param real    実数
     * @param complex 複素数の拡張を表す数
     * @return 実数と複素数の拡張を表す数が等しいかどうか
     */
    public static boolean equals(double real, Complex2 complex) {
        if (Double.isNaN(real) || complex.isNaN()) {
            return false;
        }
        return real == complex.real && complex.imag == 0.0 && complex.j == 0.0 && complex.k == 0.0;
    }

    /**
     * 複素数の拡張を表す数と実数が等しいかどうかを返す
     * 
     * @param complex 複素数の拡張を表す数
     * @param real    実数
     * @return 複素数の拡張を表す数と実数が等しいかどうか
     */
    public static boolean equals(Complex2 complex, double real) {
        return Complex2.equals(real, complex);
    }

    /**
     * 実数と複素数の拡張を表す数が等しいかどうかを返す
     * 
     * @param real 実数
     * @return 実数と複素数の拡張を表す数が等しいかどうか
     */
    public boolean equals(double real) {
        return Complex2.equals(real, this);
    }

    /**
     * 複素数の拡張を表す数どうしの値が等しいかどうかを返す
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 複素数の拡張を表す数どうしの値が等しいかどうか
     */
    public static boolean equals(Complex2 complex1, Complex2 complex2) {
        if (complex1.isNaN() || complex2.isNaN()) {
            return false;
        }
        return complex1.real == complex2.real
                && complex1.imag == complex2.imag
                && complex1.j == complex2.j
                && complex1.k == complex2.k;
    }

    /**
     * 複素数の拡張を表す数どうしの値が等しいかどうかを返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数どうしの値が等しいかどうか
     */
    public boolean equals(Complex2 complex) {
        return Complex2.equals(this, complex);
    }

    /**
     * 複素数の拡張を表す数が純粋な実数かどうかを返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数が純粋な実数かどうか
     */
    public static boolean isPurelyReal(Complex2 complex) {
        return complex.imag == 0.0 && complex.j == 0.0 && complex.k == 0.0;
    }

    /**
     * 複素数の拡張を表す数が純粋な実数かどうかを返す
     * 
     * @return 複素数の拡張を表す数が純粋な実数かどうか
     */
    public boolean isPurelyReal() {
        return Complex2.isPurelyReal(this);
    }

    /**
     * 複素数の拡張を表す数が純粋な虚数かどうかを返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数が純粋な虚数かどうか
     */
    public static boolean isPurelyImaginary(Complex2 complex) {
        return complex.real == 0.0 && complex.j == 0.0 && complex.k == 0.0;
    }

    /**
     * 複素数の拡張を表す数が純粋な虚数かどうかを返す
     * 
     * @return 複素数の拡張を表す数が純粋な虚数かどうか
     */
    public boolean isPurelyImaginary() {
        return Complex2.isPurelyImaginary(this);
    }

    /**
     * 複素数の拡張を表す数が純粋な複素数かどうかを返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数が純粋な複素数かどうか
     */
    public static boolean isPurelyComplex(Complex2 complex) {
        return complex.j == 0.0 && complex.k == 0.0;
    }

    /**
     * 複素数の拡張を表す数が純粋な複素数かどうかを返す
     * 
     * @return 複素数の拡張を表す数が純粋な複素数かどうか
     */
    public boolean isPurelyComplex() {
        return Complex2.isPurelyComplex(this);
    }

    /**
     * 複素数の拡張を表す数が NaN かどうかを返す
     * 
     * @param complex 複素数の拡張を表す数
     * @return 複素数の拡張を表す数が NaN かどうか
     */
    public static boolean isNaN(Complex2 complex) {
        return Double.isNaN(complex.real) || Double.isNaN(complex.imag) || Double.isNaN(complex.j)
                || Double.isNaN(complex.k);
    }

    /**
     * 複素数の拡張を表す数が NaN かどうかを返す
     * 
     * @return 複素数の拡張を表す数が NaN かどうか
     */
    public boolean isNaN() {
        return Complex2.isNaN(this);
    }

    /**
     * 複素数の拡張を表す数を回転させる
     * 
     * @param complex1    複素数の拡張を表す数
     * @param complex2    複素数の拡張を表す数
     * @param complex2Inv 複素数の拡張を表す数の逆数
     * @return 回転させた複素数の拡張を表す数
     */
    public static Complex2 rotate(Complex2 complex1, Complex2 complex2, Complex2 complex2Inv) {
        Complex2 complex = Complex2.times(complex2, complex1);
        complex.times(complex2Inv);
        return complex;
    }

    /**
     * 複素数の拡張を表す数を回転させる
     * 
     * @param complex    複素数の拡張を表す数
     * @param complexInv 複素数の拡張を表す数の逆数
     * @return 回転させた複素数の拡張を表す数
     */
    public Complex2 rotatePure(Complex2 complex, Complex2 complexInv) {
        return Complex2.rotate(this, complex, complexInv);
    }

    /**
     * 複素数の拡張を表す数を回転させる
     * 
     * @param complex1 複素数の拡張を表す数
     * @param complex2 複素数の拡張を表す数
     * @return 回転させた複素数の拡張を表す数
     */
    public static Complex2 rotate(Complex2 complex1, Complex2 complex2) {
        return Complex2.rotate(complex1, complex2, Complex2.inv(complex2));
    }

    /**
     * 複素数の拡張を表す数を回転させる
     * オブジェクトを変更しない
     * 
     * @param complex 複素数の拡張を表す数
     * @return 回転させた複素数の拡張を表す数
     */
    public Complex2 rotatePure(Complex2 complex) {
        return Complex2.rotate(this, complex);
    }

    /**
     * 複素数の拡張を表す数を正規化する
     * 
     * @param complex 複素数の拡張を表す数
     * @return 正規化した複素数の拡張を表す数
     */
    public static Complex2 normalize(Complex2 complex) {
        // 新しいオブジェクトを生成する
        Complex2 newComplex = new Complex2(complex);

        // 複素数の拡張を表す数を正規化する
        newComplex.normalize();

        // 新しく生成したオブジェクトを返す
        return newComplex;
    }

    /**
     * 複素数の拡張を表す数を正規化する
     * オブジェクトを変更しない
     * 
     * @return 正規化した複素数の拡張を表す数
     */
    public Complex2 normalizePure() {
        return Complex2.normalize(this);
    }

    /**
     * 複素数の拡張を表す数を正規化する
     */
    public void normalize() {
        // 絶対値
        double abs = abs();

        over(abs);
    }

    /**
     * オイラー角から X 軸、Y 軸、Z 軸の順序で複素数の拡張を表す数を返す
     * 
     * @param roll  ロール角
     * @param pitch ピッチ角
     * @param yaw   ヨー角
     * @return 複素数の拡張を表す数
     */
    public static Complex2 fromEulerXYZ(double roll, double pitch, double yaw) {
        double rollHalf = Math.toRadians(roll) / 2;
        double pitchHalf = Math.toRadians(pitch) / 2;
        double yawHalf = Math.toRadians(yaw) / 2;

        double sinRollHalf = Math.sin(rollHalf);
        double cosRollHalf = Math.cos(rollHalf);
        double sinPitchHalf = Math.sin(pitchHalf);
        double cosPitchHalf = Math.cos(pitchHalf);
        double sinYawHalf = Math.sin(yawHalf);
        double cosYawHalf = Math.cos(yawHalf);

        double w = cosRollHalf * cosPitchHalf * cosYawHalf - sinRollHalf * sinPitchHalf * sinYawHalf;
        double x = sinRollHalf * cosPitchHalf * cosYawHalf + cosRollHalf * sinPitchHalf * sinYawHalf;
        double y = cosRollHalf * sinPitchHalf * cosYawHalf - sinRollHalf * cosPitchHalf * sinYawHalf;
        double z = cosRollHalf * cosPitchHalf * sinYawHalf + sinRollHalf * sinPitchHalf * cosYawHalf;

        return new Complex2(w, x, y, z);
    }
}

public class ProgG31Eqtn1 {
    
}
