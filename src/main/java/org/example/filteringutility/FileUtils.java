package org.example.filteringutility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            if (Files.exists(path)) {
                lines = Files.readAllLines(path);
                System.out.println("Файл успешно прочитан. Количество строк: " + lines.size());
            } else {
                System.err.println("Файл не найден: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return lines;
    }

    public static void writeToFile(String filePath, List<?> data, boolean append) {
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Создан новый файл: " + filePath);
            }

            for (Object item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}

