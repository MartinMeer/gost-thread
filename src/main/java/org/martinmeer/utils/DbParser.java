package org.martinmeer.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class DbParser {

    public DbParser(Path path) {
    }

    public static List<Double> parseTxt(Path path) {
        try {
            Scanner scanner = new Scanner(path);
            List<Double> dataList = new LinkedList<>();
            String[] data = scanner.nextLine().split(",");
            for (String datum : data) {
                if (datum.equals("null")) {
                    dataList.add(null);
                }
                dataList.add(Double.valueOf(datum));
            }
            scanner.close();
            return dataList;
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<Double>> parseYaml(Path path) {
        File file = path.toFile();
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(file);
            Map<String, List<Double>> parsed = (Map<String, List<Double>>) yaml.load(inputStream);
            return parsed;
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

