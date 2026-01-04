package Java_Analyser;

import java.io.*;
import java.util.Collections;

public class CodeAnalyzer {
    // 统计总结果的变量
    private long totalFiles = 0;
    private long grandTotalLines = 0;
    private long grandTotalBlankLines = 0;
    private long grandTotalBytes = 0;

    // 递归分析目录
    public FileNode analyzeDirectory(File dir) {
        FileNode node = new FileNode(dir.getName(), true);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归处理子目录
                    FileNode childDir = analyzeDirectory(file);
                    node.children.add(childDir);
                } else if (file.getName().endsWith(".java")) {
                    // 处理Java文件
                    FileNode childFile = analyzeFile(file);
                    node.children.add(childFile);

                    // 累加到全局统计
                    totalFiles++;
                    grandTotalLines += childFile.totalLines;
                    grandTotalBlankLines += childFile.blankLines;
                    grandTotalBytes += childFile.lengthBytes;
                }
            }
        }
        // 排序：目录优先，文件名升序
        Collections.sort(node.children);
        return node;
    }

    // 分析单个文件
    private FileNode analyzeFile(File file) {
        FileNode node = new FileNode(file.getName(), false);
        node.lengthBytes = file.length();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                node.totalLines++;
                if (line.trim().isEmpty()) {
                    node.blankLines++;
                }
            }
        } catch (IOException e) {
            System.err.println("读取文件出错: " + file.getAbsolutePath());
        }
        return node;
    }

    // 专门用于打印结果的辅助方法
    public void writeOutputFormat(FileNode rootNode, String originalPath) {
        File resultDir = new File("result");
        if (!resultDir.exists()) {
            resultDir.mkdir();
        }

        String fileName = rootNode.name + ".txt";
        File resultFile = new File(resultDir, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write("[" + originalPath + "] Result:");
            writer.newLine();
            writer.newLine();
            writer.write("Files detail:");
            writer.newLine();

            // 【修改点1】直接打印根节点，而不是遍历它的children
            // 这样就能显示顶层的 +rmi 目录
            printTree(writer, rootNode, 0);

            writer.newLine();
            writer.write("Total:");
            writer.newLine();
            writer.write(totalFiles + " Java Files");
            writer.newLine();
            writer.write(grandTotalLines + " lines in files");
            writer.newLine();
            writer.write(grandTotalBlankLines + " blank lines");
            writer.newLine();
            writer.write(grandTotalBytes + " bytes");

            System.out.println("分析结果已保存: " + resultFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printTree(BufferedWriter writer, FileNode node, int level) throws IOException {
        StringBuilder indent = new StringBuilder();
        for(int i=0; i<level; i++) indent.append("    ");

        if (node.isDirectory) {
            writer.write(indent.toString() + "+" + node.name);
            writer.newLine();
            for (FileNode child : node.children) {
                printTree(writer, child, level + 1);
            }
        } else {
            String namePart = indent.toString() + "-" + node.name;

            // 格式说明：
            // %-55s : 左对齐，占用55个字符宽度（放置文件名），不足补空格，超过则顺延
            // %-7s  : 左对齐，固定显示 "Total:"
            // %-5d  : 左对齐，数字宽度5
            // %-8s  : 左对齐，固定显示 "Blank:"
            // %-4d  : 左对齐，数字宽度4
            // %10d  : 右对齐，字节数宽度10

            String line = String.format("%-55s %-7s %-5d, %-8s %-4d, %10d Bytes",
                    namePart,
                    "Total:", node.totalLines,
                    "Blank:", node.blankLines,
                    node.lengthBytes);

            writer.write(line);
            writer.newLine();
        }
    }

    public void resetStats() {
        totalFiles = 0;
        grandTotalLines = 0;
        grandTotalBlankLines = 0;
        grandTotalBytes = 0;
    }
}
