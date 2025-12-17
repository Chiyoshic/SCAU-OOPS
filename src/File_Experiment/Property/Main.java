package File_Experiment.Property;

import File_Experiment.Property.Entity.DirectoryEntity;
import File_Experiment.Property.Entity.FileEntity;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个文件名称或目录名： ");
        String input = scanner.nextLine().trim();

        File file = new File(input);

        try {
            if (!file.exists()) {
                System.out.println("输入一个文件名称或目录名： " + input);
                System.out.println("目标名称：\t" + (file.getName().isEmpty() ? input : file.getName()));
                System.out.println("--------------------------------------------");
                System.out.println("错误：指定的路径不存在！");
                System.out.println("--------------------------------------------");
                return;
            }

            if (file.isDirectory()) {
                DirectoryEntity dirEntity = new DirectoryEntity(file);
                System.out.println(dirEntity);
            } else if (file.isFile()) {
                FileEntity fileEntity = new FileEntity(file);
                System.out.println(fileEntity);
            }

        } catch (Exception e) {
            System.out.println("输入一个文件名称或目录名： " + input);
            System.out.println("目标名称：\t" + (file.getName().isEmpty() ? input : file.getName()));
            System.out.println("--------------------------------------------");
            System.out.println("错误：访问路径时发生异常！");
            System.out.println("--------------------------------------------");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}