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

    // 保存结果到文件
    public void saveResult(FileNode rootNode, String originalPath) {
        File resultDir = new File("result");
        if (!resultDir.exists()) {
            resultDir.mkdir();
        }

        String fileName = rootNode.name + ".txt";
        File resultFile = new File(resultDir, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            // 写入头部
            writer.write("[" + originalPath + "] Result:");
            writer.newLine();
            writer.newLine(); // 空行
            writer.write("Files detail:");
            writer.newLine();

            // 递归写入树状结构
            writeNodeRecursive(writer, rootNode, 0);

            // 写入底部汇总
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
            writer.newLine();

            System.out.println("分析完成！结果已保存至: " + resultFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("保存结果文件失败: " + e.getMessage());
        }
    }

    private void writeNodeRecursive(BufferedWriter writer, FileNode node, int indentLevel) throws IOException {
        // 构建缩进字符串
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            indent.append("    ");
        }

        // 根目录通常不打印自身的 "+name"，根据PDF示例，根目录本身不直接作为一行输出，
        // 而是直接输出其下的子节点。但如果这是一个递归调用中的子目录，则需要打印。

        if (indentLevel > 0 || !node.isDirectory) {
            // 逻辑调整：如果是顶层调用（analyzeDirectory返回的根），我们通常在外部循环它的children。
            // 这里为了简化递归，我们假设传入的是要打印的节点。
        }
    }

    // 专门用于打印结果的辅助方法，匹配PDF格式
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

            // 遍历根节点的子节点开始打印，因为PDF示例中"Files detail:"下面直接是内容
            for(FileNode child : rootNode.children) {
                printTree(writer, child, 0);
            }

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
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<level; i++) sb.append("    "); // 缩进4空格

        if (node.isDirectory) {
            sb.append("+").append(node.name);
            writer.write(sb.toString());
            writer.newLine();
            for (FileNode child : node.children) {
                printTree(writer, child, level + 1);
            }
        } else {
            sb.append("-").append(node.name).append(" Total: ")
                    .append(node.totalLines).append(", Blank: ")
                    .append(node.blankLines).append(", ")
                    .append(node.lengthBytes).append(" Bytes");
            writer.write(sb.toString());
            writer.newLine();
        }
    }

    // 重置统计数据
    public void resetStats() {
        totalFiles = 0;
        grandTotalLines = 0;
        grandTotalBlankLines = 0;
        grandTotalBytes = 0;
    }
}
