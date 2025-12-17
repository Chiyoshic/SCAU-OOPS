package File_Experiment.Property.Entity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryEntity {
    private String name;
    private String path;
    private long size;           // 所有文件大小之和
    private int fileCount;       // 所有文件个数
    private int dirCount;        // 所有子目录个数
    private Date lastModified;
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;
    private boolean hidden;

    public DirectoryEntity(File dir) {
        this.name = dir.getName();
        this.path = dir.getAbsolutePath();
        this.lastModified = new Date(dir.lastModified());
        this.canRead = dir.canRead();
        this.canWrite = dir.canWrite();
        this.canExecute = dir.canExecute();
        this.hidden = dir.isHidden();

        calculateSizeAndCount(dir);
    }

    private void calculateSizeAndCount(File dir) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File f : files) {
            if (f.isDirectory()) {
                dirCount++;
                calculateSizeAndCount(f); // 递归
            } else {
                fileCount++;
                size += f.length();
            }
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format(
                "输入一个文件名称或目录名： %s\n" +
                        "目标名称：\t%s\n" +
                        "--------------------------------------------\n" +
                        "目标类型：\t目录\n" +
                        "所在位置：\t%s\n" +
                        "目录大小：\t%,d 字节\n" +
                        "修改时间：\t%s\n" +
                        "包含文件：\t%d 个\n" +
                        "包含目录：\t%d 个\n" +
                        "目标属性：\n" +
                        "\t可写：\t%s\n" +
                        "\t可读：\t%s\n" +
                        "\t可运行：\t%s\n" +
                        "\t隐藏：\t%s\n" +
                        "--------------------------------------------",
                path, name, path, size, sdf.format(lastModified),
                fileCount, dirCount,
                canWrite, canRead, canExecute, hidden
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getDirCount() {
        return dirCount;
    }

    public void setDirCount(int dirCount) {
        this.dirCount = dirCount;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanWrite() {
        return canWrite;
    }

    public void setCanWrite(boolean canWrite) {
        this.canWrite = canWrite;
    }

    public boolean isCanExecute() {
        return canExecute;
    }

    public void setCanExecute(boolean canExecute) {
        this.canExecute = canExecute;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
