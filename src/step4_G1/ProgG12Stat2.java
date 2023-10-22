package step4_G1;

// 入出力の関連パッケージをインポート
import java.util.Scanner;

/*
 * 課題番号      ： 第5回 演習問題G1-2
 * ファイル名    ： ProgG12Stat2.java
 * 作成年月日    ： 2023年10月24日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

public class ProgG12Stat2 {

  /**
   * 文字列を表示する
   * 
   * @param message 表示する文字列
   */
  public static void print(String message) {
    System.out.print(message);
  }

  /**
   * 文字列を表示して改行する
   * 
   * @param message 表示する文字列
   */
  public static void println(String message) {
    System.out.println(message);
  }

  /**
   * エントリーポイント
   * 
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    // メニューのループを制御するフラグ
    boolean isLoop = true;

    // ユーザーからの入力を受け取るためのオブジェクト
    Scanner scanner = new Scanner(System.in);

    while (isLoop) {
      // メニューを表示
      println("数字を入力してください．");
      println("1: 統計データの入力と表示");
      println("2: テスト");
      println("0: 終了");
      print(">> ");

      // 入力が整数であるかを確認し、それに応じて処理する
      if (scanner.hasNextInt()) {
        // 整数値を格納
        int input = scanner.nextInt();

        // 入力された値に応じて処理を分岐
        switch (input) {
          case 1:
            // 統計データの入力と表示
            inputAndDisplayStatistics();
            break;

          case 2:
            // テスト
            runTest();
            break;

          case 0:
            // プログラムの終了
            println("終了します．");
            isLoop = false;
            break;

          default:
            // その他の入力
            println("!!!入力値が不正です．");
            break;
        }
      } else {
        println("!!!入力値が不正です．");
      }
    }

    // Scanner オブジェクトを閉じてリソースを解放
    scanner.close();
  }

  /**
   * 統計データの入力と表示
   */
  public static void inputAndDisplayStatistics() {
    // デフォルトのデータ個数
    int defaultCount = 5;

    // ユーザから入力されるデータの個数を格納する変数
    int count = defaultCount;

    // 統計のタイトルの初期値
    String title = "入力データの統計量";

    // ユーザーからの入力を受け取るためのオブジェクト
    Scanner scanner = new Scanner(System.in);

    // 統計のタイトルを尋ねる
    println("統計のタイトルを入力してください：");
    print(">> ");

    // 統計のタイトルを格納
    title = scanner.nextLine();

    // データ数を尋ねる
    println("データ個数を入力して下さい．");
    print(">> ");

    // 入力が整数であるかを確認し、それに応じて処理する
    if (scanner.hasNextInt()) {
      // 整数値を格納
      count = scanner.nextInt();
    } else {
      println("!!!入力値が不正です．データ個数を「5」にします．");

      // 不正な入力をスキップ
      scanner.next();
    }

    // 入力されたデータ数が正であるかを確認
    if (count < 1) {
      println("!!!入力値が不正です．データ個数を「5」にします．");
      count = defaultCount;
    }

    // 入力されるデータを格納する配列
    double[] numbers = new double[count];

    // 指定された数のデータを入力として受け取る
    for (int i = 0; i < count; i++) {
      print(i + 1 + "つ目のデータ >> ");

      // 入力が浮動小数点数であるかを確認し、それに応じて処理する
      if (scanner.hasNextDouble()) {
        // 浮動小数点数を格納
        numbers[i] = scanner.nextDouble();
      } else {
        println("!!!入力値が不正です． データ値を「0」にします．");
        numbers[i] = 0.0;

        // 不正な入力をスキップ
        scanner.next();
      }
    }

    // Scanner オブジェクトを閉じてリソースを解放
    scanner.close();

    // 統計データを表示
    disp(title, numbers);
  }

  /**
   * 平均値の計算
   * 
   * @param numbers 入力されたデータ
   * @return 平均値
   */
  // $\frac{1}{n} \sum_{i=1}^{n} numbers_i$
  public static double calcAve(double[] numbers) {
    // 合計値を格納する変数
    double sum = 0;

    // 拡張 for 文を用いて合計値を計算
    for (double number : numbers) {
      sum += number;
    }

    return sum / numbers.length;
  }

  /**
   * 最大値の計算
   * 
   * @param numbers 入力されたデータ
   * @return 最大値
   */
  // $\max numbers$
  public static double calcMax(double[] numbers) {
    // 最大値を格納する変数
    double max = numbers[0];

    // 拡張 for 文を用いて最大値を計算
    for (double number : numbers) {
      if (number > max) {
        max = number;
      }
    }

    return max;
  }

  /**
   * 最小値の計算
   * 
   * @param numbers 入力されたデータ
   * @return 最小値
   */
  // $\min numbers$
  public static double calcMin(double[] numbers) {
    // 最小値を格納する変数
    double min = numbers[0];

    // 拡張 for 文を用いて最小値を計算
    for (double number : numbers) {
      if (number < min) {
        min = number;
      }
    }

    return min;
  }

  /**
   * 標準偏差の計算
   * 
   * @param numbers 入力されたデータ
   * @return 標準偏差
   */
  // $\sqrt{\frac{1}{n} \sum_{i=1}^{n} (numbers_i - \bar{numbers})^2}$
  public static double calcStd(double[] numbers) {
    // 各要素の偏差の 2 乗の合計値を格納する変数
    double sum = 0;

    // 配列の平均値を格納する変数
    double mean = calcAve(numbers);

    // 拡張 for 文を用いて偏差の 2 乗の合計値を計算
    for (double number : numbers) {
      // 値と平均の差を計算
      double d = number - mean;
      // 偏差の2 乗を計算
      sum += d * d;
    }

    // 2 乗和の平均の平方根を返す
    return Math.sqrt(sum / numbers.length);
  }

  /**
   * 統計データの表示
   * 
   * @param title   統計のタイトル
   * @param numbers 入力されたデータ
   */
  public static void disp(String title, double[] numbers) {
    double average = calcAve(numbers);
    double max = calcMax(numbers);
    double min = calcMin(numbers);
    double std = calcStd(numbers);

    println("***** " + title + " *****");
    println("最大値 = " + max);
    println("最小値 = " + min);
    println("平均 = " + average);
    println("標準偏差 = " + std);
  }

  /**
   * テストを実行する
   */
  public static void runTest() {
    // テストデータ
    double[] testData = { 1.0, 2.0, 3.0, 4.0, 5.0 };

    // テストデータの平均値
    double expectedAve = 3.0;
    assertEqual("平均", expectedAve, calcAve(testData));

    // テストデータの最大値
    double expectedMax = 5.0;
    assertEqual("最大値", expectedMax, calcMax(testData));

    // テストデータの最小値
    double expectedMin = 1.0;
    assertEqual("最小値", expectedMin, calcMin(testData));

    // テストデータの標準偏差
    double expectedStd = Math.sqrt(2.0);
    assertEqual("標準偏差", expectedStd, calcStd(testData));
  }

  /**
   * 期待値と実際の値が等しいかを確認する
   * 
   * @param message  表示するメッセージ
   * @param expected 期待値
   * @param actual   実際の値
   */
  public static void assertEqual(String message, double expected, double actual) {
    // 期待値と実際の値が等しいかを確認
    if (expected == actual) {
      // 等しい場合は OK と表示
      println("OK: " + message);
    } else {
      // 等しくない場合は NG と表示
      println("NG: " + message);

      // 期待値と実際の値を表示
      println("  期待: " + expected);
      println("  実際: " + actual);
    }
  }

  /**
   * 与えられた数のべき乗を計算します。
   *
   * <p>
   * このメソッドは x を n 乗した結果を計算します。
   * n が負の場合、x の逆数の絶対値のべき乗を計算します。
   * 例えば、pow(2, -3) は 1/8 を返します。
   *
   * @param x ベースとなる数値
   * @param n べき乗する指数
   * @return x の n 乗の結果
   * @throws ArithmeticException x が 0 で n が負の場合
   */
  public static double pow(double x, int n) {
    if (x == 0 && n < 0) {
      return Double.NaN;
    }

    if (n < 0) {
      return 1.0 / pow(x, -n);
    }

    double result = 1.0;
    for (int i = 0; i < n; i++) {
      result *= x;
    }
    return result;
  }

  /**
   * 与えられた数の絶対値を計算します。
   * @param x 入力値
   * @return x の絶対値
   */
  public static double abs(double x) {
    return x < 0 ? -x : x;
  }

  /**
   * 与えられた数の最小値を計算します。
   * @param x 入力値
   * @param y 入力値
   * @return x と y の最小値
   */
  public static int min(int x, int y) {
    return x < y ? x : y;
  }

  /**
   * n 次多項式回帰の係数を求める。
   * 与えられたデータ点に基づいて多項式の係数を求める。
   * 
   * @param x      x 座標の配列
   * @param y      y 座標の配列
   * @param degree 求めたい多項式の次数
   * @return 係数の配列。入力が無効の場合は、空の配列を返す。
   */
  public static double[] polynomialRegression(double[] x, double[] y, int degree) {
    // x と y のデータ点の数が異なる場合、または次数が無効な場合、
    // もしくはデータ点の数が次数に対して不十分な場合、空の配列を返す。
    if (x.length != y.length || degree < 0 || x.length < degree + 1) {
      return new double[0];
    }

    int n = x.length;

    // Vandermonde 行列の作成
    double[][] matrix = new double[degree + 1][degree + 1];
    double[] rhs = new double[degree + 1];

    // Vandermonde 行列の各要素を計算
    for (int i = 0; i <= 2 * degree; i++) {
      double sum = 0;
      for (double number : x) {
        sum += pow(number, i);
      }

      int minRowCol = Math.max(0, i - degree);
      int maxRowCol = Math.min(i, degree);

      for (int j = minRowCol; j <= maxRowCol; j++) {
        matrix[i - j][j] = sum;
      }
    }

    // 右辺のベクトルを計算
    for (int i = 0; i <= degree; i++) {
      double sum = 0;
      for (int j = 0; j < n; j++) {
        sum += pow(x[j], i) * y[j];
      }
      rhs[i] = sum;
    }

    // ガウスの消去法を使用して線形方程式を解く
    return gaussianElimination(matrix, rhs);
  }

  /**
   * ガウスの消去法を使用して線形方程式を解く。
   * 
   * @param matrix 係数行列
   * @param rhs    右辺のベクトル
   * @return 解のベクトル
   */
  public static double[] gaussianElimination(double[][] matrix, double[] rhs) {
    int n = rhs.length;

    // 部分的ピボット選択を用いて前進消去を行う。
    for (int i = 0; i < n; i++) {
      int max = i;
      for (int j = i + 1; j < n; j++) {
        if (abs(matrix[j][i]) > abs(matrix[max][i])) {
          max = j;
        }
      }

      // 最大の要素を持つ行と現在の行を交換
      double[] temp = matrix[i];
      matrix[i] = matrix[max];
      matrix[max] = temp;

      double t = rhs[i];
      rhs[i] = rhs[max];
      rhs[max] = t;

      // 前進消去を実行
      for (int j = i + 1; j < n; j++) {
        double factor = matrix[j][i] / matrix[i][i];
        rhs[j] -= factor * rhs[i];
        for (int k = i; k < n; k++) {
          matrix[j][k] -= factor * matrix[i][k];
        }
      }
    }

    // 後退代入を用いて解を求める
    double[] solution = new double[n];
    for (int i = n - 1; i >= 0; i--) {
      double sum = 0.0;
      for (int j = i + 1; j < n; j++) {
        sum += matrix[i][j] * solution[j];
      }
      solution[i] = (rhs[i] - sum) / matrix[i][i];
    }

    return solution;
  }

  /**
   * 指数回帰の係数を求める
   * a * exp^(b * x)
   * [a, b]
   * 
   * @param x x 座標の配列
   * @param y y 座標の配列
   * @return 係数の配列
   */
  public static double[] expRegression(double[] x, double[] y) {
    // y-valuesの自然対数を取る
    double[] lnY = new double[y.length];
    for (int i = 0; i < y.length; i++) {
      if (y[i] <= 0) {
        throw new IllegalArgumentException("y-values must be positive for exp regression");
      }
      lnY[i] = Math.log(y[i]);
    }

    // 1 次多項式回帰を適用
    double[] coefficients = polynomialRegression(x, lnY, 1);

    // 求めた係数からaとbを取得
    double b = coefficients[1];
    double a = Math.exp(coefficients[0]);

    return new double[] { a, b };
  }

  /**
   * x 座標の値に対応する y 座標の値を予測する
   * 
   * @param x            x 座標の値
   * @param coefficients 係数の配列
   * @return 予測される y 座標の値
   */
  public static double polynomialPredict(double x, double[] coefficients) {
    // 予測される y 座標の値を格納
    double y = 0;

    // 予測される y 座標の値を計算
    for (int i = 0; i < coefficients.length; i++) {
      y += coefficients[i] * pow(x, i);
    }
    return y;
  }

  /**
   * 決定係数を求める
   * 
   * @param x            x 座標の配列
   * @param y            y 座標の配列
   * @param coefficients 係数の配列
   * @return 決定係数
   */
  public static double coefficientOfDetermination(double[] x, double[] y, double[] coefficients) {
    double rss = 0;
    for (int i = 0; i < x.length; i++) {
      double error = y[i] - polynomialPredict(x[i], coefficients);
      rss += error * error;
    }

    double yMean = 0;
    for (double value : y) {
      yMean += value;
    }
    yMean /= y.length;

    double tss = 0;
    for (double value : y) {
      double diff = value - yMean;
      tss += diff * diff;
    }

    return 1 - rss / tss;
  }

  /**
   * 平均二乗誤差を求める
   * 
   * @param x            x 座標の配列
   * @param y            y 座標の配列
   * @param coefficients 係数の配列
   * @return 平均二乗誤差
   */
  public static double meanSquaredError(double[] x, double[] y, double[] coefficients) {
    if (x.length != y.length) {
      throw new IllegalArgumentException("xValues and yValues must have the same length");
    }

    double totalError = 0.0;
    for (int i = 0; i < x.length; i++) {
      double predictedY = polynomialPredict(x[i], coefficients);
      totalError += pow(y[i] - predictedY, 2);
    }

    return totalError / x.length;
  }

  /**
   * 平均絶対誤差を求める
   * 
   * @param x            x 座標の配列
   * @param y            y 座標の配列
   * @param coefficients 係数の配列
   * @return 平均絶対誤差
   */
  public static double meanAbsoluteError(double[] x, double[] y, double[] coefficients) {
    if (x.length != y.length) {
      throw new IllegalArgumentException("x and y arrays must have the same length");
    }

    double totalError = 0;
    for (int i = 0; i < x.length; i++) {
      double estimatedY = polynomialPredict(x[i], coefficients);
      totalError += abs(y[i] - estimatedY);
    }
    return totalError / x.length;
  }
}
