package org.shemenev.v2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Генерирует отчет
 */
public class ReportGenerator {

    public static void main(String[] args) {
        List<Record> example = List.of(
                new Record(1, LocalTime.of(10, 0, 0), "inbox", "начало"),
                new Record(2, LocalTime.of(10, 30, 0), "break", "empty"),
                new Record(3, LocalTime.of(11, 10, 0), "ID-1872", "делаю задачу"),
                new Record(4, LocalTime.of(12, 0, 0), "inbox", "porn is good"),
                new Record(5, LocalTime.of(14, 0, 0), "end", "empty")
        );

        Map<String, Duration> exampleMap = new ReportGenerator().generate(example);
        Map<String, Duration> exampleMap2 = new ReportGenerator().noBreaksGenerate(exampleMap);

        System.out.println(exampleMap);
        System.out.println(exampleMap2);
    }

    Map<String, Duration> tasksMap = new HashMap<>();
    /**
     * Преобразует список рекордов в мапу следующего вида
     * ключ(Название задачи) -> продолжительность задачи
     *
     * @param records рекорды
     * @return мапа
     */

    public Map<String, Duration> generate(List<Record> records) {

        for (int i = 1; i < records.size(); i++) {
            Duration durationTime = Duration.between(records.get(i - 1).getTime(), records.get(i).getTime());
            String currentTask = records.get(i - 1).getTaskName();
            Duration alreadySavedTime;

            if (!tasksMap.containsKey(currentTask)) {
                tasksMap.put(currentTask, durationTime);
            } else {
                alreadySavedTime = tasksMap.get(currentTask);
                tasksMap.replace(currentTask, durationTime.plus(alreadySavedTime));   // map( task, duration )
            }
        }
        return tasksMap;
    }

    public Map<String, Duration> noBreaksGenerate(Map<String, Duration> tasksMap) {

        Map<String, Duration> noBreaksMap = new HashMap<>();
        Duration withoutBreaks = Duration.ZERO;
        noBreaksMap.put("без перерывов", withoutBreaks);

        for (String key : tasksMap.keySet()) {
            if (!key.equals("break")) {
                withoutBreaks = withoutBreaks.plus(tasksMap.get(key));
                noBreaksMap.replace("без перерывов", withoutBreaks);
            }
        }
        Duration allTime = tasksMap.get("break").plus(noBreaksMap.get("без перерывов"));
        noBreaksMap.put("всего", allTime);

        return noBreaksMap;
    }
}


