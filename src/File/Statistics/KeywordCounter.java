package File.Statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordCounter {
    private List<String> keywords;
    private Map<String, Integer> counts;

    public KeywordCounter() {
        keywords = new ArrayList<>();
        counts = new HashMap<>();
    }

    public void loadKeywords(String filePath) throws IOException {
        File kwFile = new File(filePath);
        if (!kwFile.exists()) {
            throw new IOException("Keywords file not found: " + filePath);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(kwFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String kw = line.trim();
                if (!kw.isEmpty()) {
                    keywords.add(kw);
                    counts.put(kw, 0);
                }
            }
        }
    }

    public void countKeywords(String javaFilePath) throws IOException {
        File javaFile = new File(javaFilePath);
        if (!javaFile.exists()) {
            throw new IOException("Java file not found: " + javaFilePath);
        }
        if (!javaFile.isFile()) {
            throw new IOException("Not a file: " + javaFilePath);
        }
        String name = javaFile.getName();
        if (!name.endsWith(".java")) {
            throw new IOException("Not a Java file: " + javaFilePath);
        }

        String content = Files.readString(Path.of(javaFilePath));
        for (String kw : keywords) {
            Pattern p = Pattern.compile("\\b" + Pattern.quote(kw) + "\\b");
            Matcher m = p.matcher(content);
            int cnt = 0;
            while (m.find()) {
                cnt++;
            }
            counts.put(kw, cnt);
        }
    }

    public void saveResults(String javaFileName) throws IOException {
        String outFile = "Keywords-" + javaFileName + ".txt";
        List<KeywordResult> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            results.add(new KeywordResult(entry.getKey(), entry.getValue()));
        }
        Collections.sort(results);

        Files.writeString(Path.of(outFile), "");
        for (KeywordResult res : results) {
            Files.writeString(Path.of(outFile), res.toString() + "\n", java.nio.file.StandardOpenOption.APPEND);
        }
    }

    public void displayTop(int n) {
        List<KeywordResult> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            results.add(new KeywordResult(entry.getKey(), entry.getValue()));
        }
        Collections.sort(results);

        System.out.println("前 " + n + " 位关键字使用次数统计：");
        for (int i = 0; i < Math.min(n, results.size()); i++) {
            KeywordResult res = results.get(i);
            System.out.println(res.getKeyword() + "\t" + res.getCount());
        }
    }
}