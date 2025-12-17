package File_Experiment.Statistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KeywordCounter counter = new KeywordCounter();

        System.out.println("请输入文本文件 keywords.txt 所在目录： ");
        String input = sc.nextLine().trim();

        try {
            counter.loadKeywords(input);
        } catch (Exception e) {
            System.out.println("读取关键字文件失败！");
            return;
        }

        System.out.println("请输入Java源程序文件所在目录： ");
        String javaFile = sc.nextLine().trim();

        try {
            counter.countKeywords(javaFile);
            String javaName = new java.io.File(javaFile).getName();
            counter.saveResults(javaName);
            System.out.println("关键字统计完成，结果已保存至 Keywords-" + javaName + ".txt");

            System.out.print("查看使用次数排名前几位关键字？(1-51)：");
            int topN = sc.nextInt();
            sc.nextLine();
            if (topN < 1 || topN > 51) {
                System.out.println("无效输入！");
                return;
            }
            counter.displayTop(topN);

        } catch (Exception e) {
            System.out.println("错误：" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}