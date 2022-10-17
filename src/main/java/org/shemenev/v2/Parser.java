package org.shemenev.v2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Нужен что бы представить файл в удобном виде(список {@link Record}) для дальнейшей работы
 */

public class Parser {
    public List<Record> parse(Path pathToFile) {
        try {
            if(Files.notExists(pathToFile)) {
                throw new FileNotFoundException("Hello. There is no such file:" + pathToFile + " Buy!");
            }

            return Files.lines(pathToFile)
                    .filter(line -> line.startsWith("|"))
                    .filter(line -> !line.contains("|:----|"))
                    .filter(line -> !line.contains("| №   |"))
                    .map(this::recordMapper)
                    .collect(Collectors.toList());
        }
        catch (IOException e) {
            throw new IllegalStateException("Не удалось считать файл: " + pathToFile, e);
        }
    }

    private Record recordMapper(String line) {

        List<String> columns = Arrays.stream(line.split("\\|"))
                .map(column -> column.strip())
                .filter(column -> !column.isEmpty())
                .toList();

        Integer lineNumber = Integer.parseInt(columns.get(0));
        LocalTime time = LocalTime.parse(columns.get(1));
        String taskName = columns.get(2);
        String description = columns.size() == 4 ? columns.get(3) : "empty";

        return new Record(lineNumber, time, taskName, description);
    }
}

