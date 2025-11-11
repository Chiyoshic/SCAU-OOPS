package File.Property.Entity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEntity {
    private String name;
    private String path;
    private long size;
    private Date lastModified;
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;
    private boolean hidden;
    private String extension;

    public FileEntity(File file) {
        this.name = file.getName();
        this.path = file.getAbsolutePath();
        this.size = file.length();
        this.lastModified = new Date(file.lastModified());
        this.canRead = file.canRead();
        this.canWrite = file.canWrite();
        this.canExecute = file.canExecute();
        this.hidden = file.isHidden();

        int dotIndex = name.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < name.length() - 1) {
            this.extension = name.substring(dotIndex + 1);
        } else {
            this.extension = "无";
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String type = extension.equals("无") ? "文件(无)" : "文件(." + extension + ")";
        return String.format(
                "输入一个文件名称或目录名： %s\n" +
                        "目标名称：\t%s\n" +
                        "--------------------------------------------\n" +
                        "目标类型：\t%s\n" +
                        "所在位置：\t%s\n" +
                        "文件大小：\t%,d 字节\n" +
                        "修改时间：\t%s\n" +
                        "目标属性：\n" +
                        "\t可读：\t%s\n" +
                        "\t可写：\t%s\n" +
                        "\t可运行：\t%s\n" +
                        "\t隐藏：\t%s\n" +
                        "--------------------------------------------",
                path, name, type, path, size, sdf.format(lastModified),
                canRead, canWrite, canExecute, hidden
        );
    }
}
