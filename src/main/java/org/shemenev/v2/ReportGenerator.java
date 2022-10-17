package org.shemenev.v2;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Генерирует отчет
 */
public class ReportGenerator {

    Map<String, Duration> tasksMap = new HashMap<>();
    Map<String, Duration> noBreaksMap = new HashMap<>();
    /**
     * Преобразует список рекордов в мапу следующего вида
     * ключ(Название задачи) -> продолжительность задачи
     *
     * @param records рекорды
     * @return Map<String, Duration>
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

    /**
     * этот метод считает полный раб.день и
     * день без перерывав,
     * результат помещает в отдельную карту
     * @return Map<String, Duration>
     */
    public Map<String, Duration> noBreaksGenerate(Map<String, Duration> tasksMap) {

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


