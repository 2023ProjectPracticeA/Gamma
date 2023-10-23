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

    // 統計データのタイトル
    String title = "";

    // 統計データの数値
    double[] numbers = new double[0];

    while (isLoop) {
      // メニューを表示
      println("数字を入力してください．");
      println("1: 統計データのタイトルの入力");
      println("2: 統計データの数値の入力");
      println("3: 統計データの表示");
      println("4: 並び替え");
      println("5: グラフ表示付き並び替え");
      println("6: テスト");
      println("0: 終了");
      print(">> ");

      // 入力が整数であるかを確認し、それに応じて処理する
      if (scanner.hasNextInt()) {
        // 整数値を格納
        int input = scanner.nextInt();

        // 入力された値に応じて処理を分岐
        switch (input) {
          case 1:
            // 統計データのタイトルの入力
            title = inputTitle(scanner);
            break;

          case 2:
            // 統計データの数値の入力
            numbers = inputNumbers(scanner);
            break;

          case 3:
            // 統計データの表示
            disp(title, numbers);
            break;

          case 4:
            // 並び替え
            sortMenu(numbers, scanner, false);
            break;

          case 5:
            // グラフ表示付き並び替え
            sortMenu(numbers, scanner, true);
            break;

          case 6:
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
   * 統計データのタイトルの入力
   */
  public static String inputTitle(Scanner scanner) {
    println("統計データのタイトルを入力して下さい．");
    print(">> ");
    return scanner.next();
  }

  /**
   * 統計データの数値の入力
   */
  public static double[] inputNumbers(Scanner scanner) {
    // デフォルトのデータ個数
    int defaultCount = 5;

    // ユーザから入力されるデータの個数を格納する変数
    int count = defaultCount;

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

    return numbers;
  }

  public static void sortMenu(double[] numbers, Scanner scanner, boolean isVisual) {
    // メニューのループを制御するフラグ
    boolean isLoop = true;

    while (isLoop) {
      // メニューを表示
      println("数字を入力してください．");
      println("1: バブルソート");
      println("2: 選択ソート");
      println("3: 挿入ソート");
      println("0: 戻る");
      print(">> ");

      // 入力が整数であるかを確認し、それに応じて処理する
      if (scanner.hasNextInt()) {
        // 整数値を格納
        int input = scanner.nextInt();

        // 入力された値に応じて処理を分岐
        switch (input) {
          case 1:
            // バブルソート
            bubbleSort(numbers, isVisual);
            break;

          case 2:
            // 選択ソート
            selectionSort(numbers, isVisual);
            break;

          case 3:
            // 挿入ソート
            insertionSort(numbers, isVisual);
            break;

          case 0:
            // メニューに戻る
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
  }

  /**
   * バブルソート
   * 
   * @param numbers 入力されたデータ
   */
  public static void bubbleSort(double[] numbers, boolean isVisual) {
    // バブルソートのループを制御するフラグ
    boolean isLoop = true;

    // バブルソートのループ
    while (isLoop) {
      // バブルソートのループを終了するかを制御するフラグ
      boolean isEnd = true;

      // バブルソートのループ
      for (int i = 0; i < numbers.length - 1; i++) {
        // 隣り合う要素を比較し、順序が逆なら交換
        if (numbers[i] > numbers[i + 1]) {
          double temp = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = temp;

          // 交換が行われたので、ループを継続
          isEnd = false;
        }
      }

      // 交換が行われなかった場合、ループを終了
      if (isEnd) {
        isLoop = false;
      }

      // グラフを表示
      if (isVisual) {
        printGraph(numbers);
      }
    }
  }

  /**
   * 選択ソート
   * 
   * @param numbers 入力されたデータ
   */
  public static void selectionSort(double[] numbers, boolean isVisual) {
    // 選択ソートのループ
    for (int i = 0; i < numbers.length - 1; i++) {
      // 最小値のインデックスを格納する変数
      int minIndex = i;

      // 最小値のインデックスを探索
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[j] < numbers[minIndex]) {
          minIndex = j;
        }
      }

      // 最小値のインデックスが i でない場合、最小値と i 番目の要素を交換
      if (minIndex != i) {
        double temp = numbers[i];
        numbers[i] = numbers[minIndex];
        numbers[minIndex] = temp;
      }

      // グラフを表示
      if (isVisual) {
        printGraph(numbers);
      }
    }
  }

  /**
   * 挿入ソート
   * 
   * @param numbers 入力されたデータ
   */
  public static void insertionSort(double[] numbers, boolean isVisual) {
    // 挿入ソートのループ
    for (int i = 1; i < numbers.length; i++) {
      // 挿入する値を格納する変数
      double temp = numbers[i];

      // 挿入する位置を探索
      int j = i - 1;
      while (j >= 0 && numbers[j] > temp) {
        numbers[j + 1] = numbers[j];
        j--;
      }

      // 挿入する値を挿入
      numbers[j + 1] = temp;

      // グラフを表示
      if (isVisual) {
        printGraph(numbers);
      }
    }
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
    boolean invalid = false;

    if (title.length() == 0) {
      println("!!!タイトルが入力されていません．");
      invalid = true;
    }

    if (numbers.length == 0) {
      println("!!!データが入力されていません．");
      invalid = true;
    }

    if (invalid) {
      return;
    }

    double average = calcAve(numbers);
    double max = calcMax(numbers);
    double min = calcMin(numbers);
    double std = calcStd(numbers);

    println("***** " + title + " *****");
    println("最大値 = " + max);
    println("最小値 = " + min);
    println("平均 = " + average);
    println("標準偏差 = " + std);

    printGraph(numbers);
  }

  /**
   * 桁数を求める
   * 
   * @param number 桁数を求める数値
   * @return 桁数
   */
  public static int digitCount(double number) {
    int count = 0;

    if (number < 0) {
      number *= -1;
    }

    while (number >= 1) {
      number /= 10;
      count++;
    }
    return count;
  }

  /**
   * 棒グラフの表示
   * 
   * @param numbers 表示するデータ
   */
  public static void printGraph(double[] numbers) {
    double maxValue = calcMax(numbers);
    double minValue = calcMin(numbers);
    int intMinValue = (int) minValue;

    if (minValue < 0) {
      intMinValue--;
    } else {
      intMinValue = 0;
    }

    String spaces = "";
    for (int i = 0; i < digitCount(numbers.length); i++) {
      spaces += " ";
    }

    // インデックスの表示
    for (int i = 0; i < numbers.length; i++) {
      String s = i + "";
      print(s);
      print(" ");
      for (int j = 0; j < spaces.length() - s.length(); j++) {
        print(" ");
      }
    }

    println("");

    // 縦方向の描画のため、最大値からデクリメントしながら行ごとに描画
    for (int row = (int) maxValue + 1; row > intMinValue; row--) {
      for (int col = 0; col < numbers.length; col++) {
        if (row < 0) {
          if (numbers[col] < 0 && numbers[col] <= row) {
            print("█");
            print(spaces);
          } else {
            print(" ");
            print(spaces);
          }
        } else {
          if (numbers[col] >= row) {
            print("█");
            print(spaces);
          } else {
            print(" ");
            print(spaces);
          }
        }

      }
      println("");
    }

    String[] numbersString = new String[numbers.length];
    int maxLength = 0;

    // 棒の下に値を表示するため、値を文字列に変換
    for (int i = 0; i < numbers.length; i++) {
      String s = numbers[i] + "";
      numbersString[i] = s;

      if (s.length() > maxLength) {
        maxLength = s.length();
      }
    }

    for (int i = 0; i < maxLength; i++) {
      // 棒の下に値を表示
      for (int j = 0; j < numbers.length; j++) {
        if (numbersString[j].length() > i) {
          print(numbersString[j].charAt(i) + "");
        } else {
          print(" ");
        }
        print(spaces);
      }
      println("");
    }
    println("");
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

    assertEqual("pow(2, 3)", 8.0, pow(2, 3));

    assertEqual("pow(2, -3)", 1.0 / 8.0, pow(2, -3));

    assertEqual("abs(3)", 3.0, abs(3));

    assertEqual("abs(-3)", 3.0, abs(-3));

    assertEqual("min(3, 5)", 3, min(3, 5));

    assertEqual("min(5, 3)", 3, min(5, 3));

    assertEqual("max(3, 5)", 5, max(3, 5));

    assertEqual("max(5, 3)", 5, max(5, 3));

    assertEqual("factorial(3)", 6, factorial(3));

    assertEqual("factorial(5)", 120, factorial(5));

    assertEqual("exp(0)", 1.0, exp(0));

    assertEqual("exp(1)", Math.E, exp(1));

    assertEqual("ln(1)", 0.0, ln(1));

    assertEqual("ln(e)", 1.0, ln(Math.E));

    assertEqual("ln(exp(1))", 1.0, ln(exp(1)));

    assertEqual("polynomialRegression([1, 2, 3], [1, 4, 9], 1)", 0.0,
        polynomialRegression(new double[] { 1, 2, 3 }, new double[] { 1, 4, 9 }, 1)[0]);

    assertEqual("polynomialRegression([1, 2, 3], [1, 4, 9], 1)", 1.0,
        polynomialRegression(new double[] { 1, 2, 3 }, new double[] { 1, 4, 9 }, 1)[1]);

    assertEqual("polynomialRegression([1, 2, 3], [1, 4, 9], 2)", 0.0,
        polynomialRegression(new double[] { 1, 2, 3 }, new double[] { 1, 4, 9 }, 2)[0]);

    assertEqual("polynomialRegression([1, 2, 3], [1, 4, 9], 2)", 0.0,
        polynomialRegression(new double[] { 1, 2, 3 }, new double[] { 1, 4, 9 }, 2)[1]);

    assertEqual("polynomialRegression([1, 2, 3], [1, 4, 9], 2)", 1.0,
        polynomialRegression(new double[] { 1, 2, 3 }, new double[] { 1, 4, 9 }, 2)[2]);

    assertEqual("polynomialRegression([1, 2, 3], [1, 4, 9], 3)", 0.0,
        polynomialRegression(new double[] { 1, 2, 3 }, new double[] { 1, 4, 9 }, 3)[0]);
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
   * 
   * @param x 入力値
   * @return x の絶対値
   */
  public static double abs(double x) {
    return x < 0 ? -x : x;
  }

  /**
   * 与えられた数の最小値を計算します。
   * 
   * @param x 入力値
   * @param y 入力値
   * @return x と y の最小値
   */
  public static int min(int x, int y) {
    return x < y ? x : y;
  }

  /**
   * 与えられた数の最大値を計算します。
   * 
   * @param x 入力値
   * @param y 入力値
   * @return x と y の最大値
   */
  public static int max(int x, int y) {
    return x > y ? x : y;
  }

  /**
   * 与えられた数の階乗を計算します。
   * 
   * @param n 入力値
   * @return n の階乗
   */
  public static long factorial(int n) {
    long result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  /**
   * 指数関数を計算します。
   * 
   * @param x 入力値
   * @return exp(x)
   */
  public static double exp(double x) {
    // 初項は 1.0
    double sum = 1.0;
    double lastSum;
    double term = x;
    int i = 1;
    do {
      // 前の和を保存
      lastSum = sum;

      // 新しい項を加える
      sum += term;
      i++;

      // 新しい項を計算
      term = pow(x, i) / factorial(i);

      // 和の変化がなくなるまで続ける
    } while (lastSum != sum);

    return sum;
  }

  /**
   * 自然対数を計算します。
   * 
   * @param x 入力値
   * @return ln(x)
   */
  public static double ln(double x) {
    double y = x - 1;
    double result = 0.0;
    double lastResult;
    int i = 1;

    do {
      lastResult = result;

      double term = pow(y, i) / i;
      if (i % 2 == 0) {
        result -= term;
      } else {
        result += term;
      }

      i++;
    } while (i < 100 && lastResult != result);

    return result;
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

      int minRowCol = max(0, i - degree);
      int maxRowCol = min(i, degree);

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
      lnY[i] = ln(y[i]);
    }

    // 1 次多項式回帰を適用
    double[] coefficients = polynomialRegression(x, lnY, 1);

    // 求めた係数からaとbを取得
    double b = coefficients[1];
    double a = exp(coefficients[0]);

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
