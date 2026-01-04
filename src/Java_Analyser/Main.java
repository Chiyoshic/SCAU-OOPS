package Java_Analyser;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CodeAnalyzer analyzer = new CodeAnalyzer();

        while (true) {
            System.out.println("MENU-----");
            System.out.println("1. 分析目录中的源程序文件");
            System.out.println("2. 查看分析结果");
            System.out.println("0. 退出程序");
            System.out.print("请选择: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("请输入要分析的目录路径: ");
                    String path = scanner.nextLine();
                    File dir = new File(path);

                    if (!dir.exists() || !dir.isDirectory()) {
                        System.out.println("[" + path + "]不是合法的目录名称!");
                    } else {
                        analyzer.resetStats();
                        FileNode result = analyzer.analyzeDirectory(dir);
                        analyzer.writeOutputFormat(result, dir.getAbsolutePath());
                    }
                    break;

                case "2":
                    File resultDir = new File("result");
                    if (!resultDir.exists() || resultDir.listFiles() == null || resultDir.listFiles().length == 0) {
                        System.out.println("还没有分析结果!");
                    } else {
                        System.out.println("可以查看的结果文件有:");
                        File[] results = resultDir.listFiles((d, name) -> name.endsWith(".txt"));
                        if (results != null) {
                            for (int i = 0; i < results.length; i++) {
                                System.out.println((i + 1) + ". " + results[i].getName());
                            }
                            System.out.print("选择要查看的结果文件(0表示放弃): ");
                            try {
                                int fileIndex = Integer.parseInt(scanner.nextLine());
                                if (fileIndex > 0 && fileIndex <= results.length) {
                                    // 读取并打印文件内容
                                    try (BufferedReader br = new BufferedReader(new FileReader(results[fileIndex - 1]))) {
                                        String line;
                                        while ((line = br.readLine()) != null) {
                                            System.out.println(line);
                                        }
                                    }
                                } else if (fileIndex != 0) {
                                    System.out.println("输入编号错误!");
                                }
                            } catch (NumberFormatException | IOException e) {
                                System.out.println("输入无效!");
                            }
                        }
                    }
                    break;

                case "0":
                    System.out.println("程序退出。");
                    scanner.close();
                    return;

                default:
                    System.out.println("无效的选择，请重试。");
            }
            System.out.println();
        }
    }
}
