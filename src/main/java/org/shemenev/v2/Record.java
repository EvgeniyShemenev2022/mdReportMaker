package org.shemenev.v2;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Одна строка таблицы из отчета программиста
 * <p>
 * Строка должна иметь вид
 * | 7   | 14:17 | review     | [M] ID-1839 Рефакторинг парсинга на SAX  |
 * <p>
 * * 4 столбца
 * ** 0) чимло - обязательно
 * ** 1) время в формате ISO-8601 (час:минуты) - обязательное
 * ** 2) текст(название задачи) - обязательное
 * ** 3) текст(описание) - опциональный
 */
public class Record extends Object {
    private Integer lineNumber;
    private LocalTime time;
    private String taskName;
    private String description;

    public Record(Integer lineNumber, LocalTime time, String taskName, String description) {
        this.lineNumber = lineNumber;
        this.time = time;
        this.taskName = taskName;
        this.description = description;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return getLineNumber().equals(record.getLineNumber())
                && getTime().equals(record.getTime())
                && getTaskName().equals(record.getTaskName())
                && getDescription().equals(record.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLineNumber(), getTime(), getTaskName(), getDescription());
    }

    @Override
    public String toString() {
        return "Record{" +
                "lineNumber=" + lineNumber +
                ", time=" + time +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

/*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Record otherRecord = (Record) obj;
        return lineNumber.equals(otherRecord.getLineNumber()) &&
                time.equals(otherRecord.getTime()) &&
                taskName.equals(otherRecord.getTaskName()) &&
                description.equals(otherRecord.getDescription());
    }*/


