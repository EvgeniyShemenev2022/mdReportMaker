package org.shemenev.v2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * Генерирует отчет
 */
public class ReportGenerator {

    /**
     * Преобразует список рекордов в мапу следующего вида
     * ключ(Название задачи) -> продолжительность задачи
     *
     * @param records рекорды
     * @return мапа
     */
    public Map<String, Duration> generate(List<Record> records) {
       throw new NotImplementedException();
    }
}
