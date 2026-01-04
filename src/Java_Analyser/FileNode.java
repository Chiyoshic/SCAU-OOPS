package Java_Analyser;

import java.util.ArrayList;
import java.util.List;

public class FileNode implements Comparable<FileNode> {
    public String name;
    public boolean isDirectory;
    public long totalLines;
    public long blankLines;
    public long lengthBytes;
    public List<FileNode> children;

    public FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.children = new ArrayList<>();
        this.totalLines = 0;
        this.blankLines = 0;
        this.lengthBytes = 0;
    }

    @Override
    public int compareTo(FileNode other) {
        if (this.isDirectory && !other.isDirectory) {
            return -1;
        } else if (!this.isDirectory && other.isDirectory) {
            return 1;
        } else {
            return this.name.compareToIgnoreCase(other.name);
        }
    }
}