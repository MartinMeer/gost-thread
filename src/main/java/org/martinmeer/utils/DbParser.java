package org.martinmeer.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class DbParser {

    private final Path path;

    public DbParser(Path path) {
        this.path = path;
    }

    public static List<Double> parseTxt(Path path) {
        try {
            Scanner scanner = new Scanner(path);
            List<Double> dataList = new LinkedList<>();
            String[] data = scanner.nextLine().split(",");
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals("null")) {
                    dataList.add(null);
                }
                dataList.add(Double.valueOf(data[i]));
            }
            scanner.close();
            return dataList;
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Double> parseYaml(Path path) {
        return new HashMap<>();
    }
}
