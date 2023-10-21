package step4_G1;

// 入出力の関連パッケージをインポート
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 課題番号      ： 第5回 演習問題G1-2
 * ファイル名    ： ProgG12Stat2.java
 * 作成年月日    ： 2023年10月24日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

public class ProgG12Stat2 {

  // 文字列を表示する
  public static void print(String message) {
    System.out.print(message);
  }

  // 文字列を表示して改行する
  public static void println(String message) {
    System.out.println(message);
  }

  public static void main(String[] args) throws IOException {
    // デフォルトのデータ個数
    int defaultCount = 5;

    // ユーザから入力されるデータの個数を格納する変数
    int count = defaultCount;

    // 統計のタイトルの初期値
    String title = "入力データの統計量";

    // ユーザからの入力を受け取るためのオブジェクト
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 統計のタイトルの入力
    println("統計のタイトルを入力してください：");
    print(">> ");
    title = reader.readLine();

    // データ個数の入力受付
    println("データ個数を入力して下さい．");
    print(">> ");

    // 入力されたデータ個数の入力とエラーハンドリング
    try {
      count = Integer.parseInt(reader.readLine());
    } catch (NumberFormatException e) {
      println("!!!入力値が不正です．データ個数を「5」にします．");
    }

    // データ個数が 1 未満の場合のエラーハンドリング
    if (count < 1) {
      println("!!!入力値が不正です．データ個数を「5」にします．");
      count = defaultCount;
    }

    // 入力されるデータを格納する配列
    double[] numbers = new double[count];

    // 数値の入力
    for (int i = 0; i < count; i++) {
      try {
        print(i + 1 + "つ目のデータ >> ");
        numbers[i] = Double.parseDouble(reader.readLine());
      } catch (NumberFormatException e) {
        println("!!!入力値が不正です． データ値を「0」にします．");
        numbers[i] = 0.0;
      }
    }

    disp(title, calcAve(numbers), calcMax(numbers), calcMin(numbers), calcStd(numbers));
  }

  // 統計データの表示
  public static double calcAve(double[] numbers) {
    // 合計値を格納する変数
    double sum = 0;

    for (double num : numbers) {
      sum += num;
    }

    return sum / numbers.length;
  }

  // 最大値の計算
  public static double calcMax(double[] numbers) {
    // 最大値を格納する変数
    double max = numbers[0];

    for (double num : numbers) {
      if (num > max) {
        max = num;
      }
    }

    return max;
  }

  // 最小値の計算
  public static double calcMin(double[] numbers) {
    // 最小値を格納する変数
    double min = numbers[0];

    for (double number : numbers) {
      if (number < min) {
        min = number;
      }
    }

    return min;
  }

  // 標準偏差の計算
  public static double calcStd(double[] numbers) {
    // 各要素の偏差の 2 乗の合計値を格納する変数
    double sum = 0;

    // 配列の平均値を格納する変数
    double mean = calcAve(numbers);

    for (double number : numbers) {
      // 値と平均の差を計算
      double d = number - mean;
      // 偏差の2 乗を計算
      sum += d * d;
    }

    // 2 乗和の平均の平方根を返す
    return Math.sqrt(sum / numbers.length);
  }

  // 統計データの表示
  public static void disp(String title, double average, double max, double min, double std) {
    println("***** " + title + " *****");
    println("最大値 = " + max);
    println("最小値 = " + min);
    println("平均 = " + average);
    println("標準偏差 = " + std);
  }
}
