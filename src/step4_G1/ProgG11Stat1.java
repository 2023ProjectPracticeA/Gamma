package step4_G1; 
 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
 
/* 
 * 課題番号      ： 第4回 演習問題G1-1 
 * ファイル名    ： ProgG11Stat1.java 
 * 作成年月日    ： 2023年10月17日 
 * 学生番号・氏名： 
 * グループ      ： Γ 
 */ 
 
public class ProgG11Stat1 { 
    public static void main(String[] args) throws IOException { 
        int defaultCount = 5; 
        int count = defaultCount; 
        String title = "入力データの統計量"; 
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
 
        System.out.println("統計のタイトルを入力してください："); 
        System.out.print(">> "); 
        title = reader.readLine(); 
 
        System.out.println("データ個数を入力して下さい．"); 
        System.out.print(">> "); 
 
        try { 
            count = Integer.parseInt(reader.readLine()); 
        } catch (NumberFormatException e) { 
            System.out.println("!!!入力値が不正です．データ個数を「5」にします．"); 
        } 
 
        if(count < 1) { 
            System.out.println("!!!入力値が不正です．データ個数を「5」にします．"); 
            count = defaultCount; 
        } 
 
        double[] numbers = new double[count]; 
 
        for (int i = 0; i < count; i++) { 
            try { 
                System.out.print(i + 1 + "つ目のデータ >> "); 
                numbers[i] = Double.parseDouble(reader.readLine()); 
            } catch (NumberFormatException e) { 
                System.out.println("!!!入力値が不正です． データ値を「0」にします．"); 
                numbers[i] = 0.0; 
            } 
        } 
        disp(title, calcAve(numbers), calcMax(numbers), calcMin(numbers), calcStd(numbers)); 
    } 
 
    public static double calcAve(double[] numbers) { 
        double sum = 0; 
        for (double num : numbers) { 
            sum += num; 
        } 
        return sum / numbers.length; 
    } 
 
    public static double calcMax(double[] numbers) { 
        double max = numbers[0]; 
        for (double num : numbers) { 
            if (num > max) { 
                max = num; 
            } 
        } 
        return max; 
    } 
 
    public static double calcMin(double[] numbers) { 
        double min = numbers[0]; 
        for (double number : numbers) { 
            if (number < min) { 
                min = number; 
            } 
        } 
        return min; 
    } 
 
    public static double calcStd(double[] numbers) { 
        double sum = 0; 
        double mean = calcAve(numbers); 
        for (double number : numbers) { 
            double d = number - mean; 
            sum += d * d; 
        } 
        return Math.sqrt(sum / numbers.length); 
    } 
 
    public static void disp(String title, double average, double max, double min, double std) { 
        System.out.println("***** " + title + " *****"); 
        System.out.println("最大値 = " + max); 
        System.out.println("最小値 = " + min); 
        System.out.println("平均 = " + average); 
        System.out.println("標準偏差 = " + std); 
    } 
} 
 