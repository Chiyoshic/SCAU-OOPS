package File.Statistics;

public class KeywordResult implements Comparable<KeywordResult> {
    private String keyword;
    private int count;

    public KeywordResult(String keyword, int count) {
        this.keyword = keyword;
        this.count = count;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(KeywordResult other) {
        if (this.count != other.count) {
            return Integer.compare(other.count, this.count);
        }
        return this.keyword.compareTo(other.keyword);
    }

    @Override
    public String toString() {
        return keyword + " " + count;
    }
}
