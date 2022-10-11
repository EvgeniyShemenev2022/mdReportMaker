package org.shemenev;

import org.shemenev.v2.Record;
import org.junit.Test;

import java.time.LocalTime;

public class MyQuestionsTest {
    /**
     * Выполняет парсинг файла
     * * находит в нем таблицу
     * * каждую строку таблицы превращает в {@link Record}
     * <p>
     * Данный текст используется программой
     * <a href="https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html"> javadoc</a>
     * строка <@param pathToFile путь к файлу> нарушает правила синтаксиса javadoc
     *
     * @param pathToFile путь к файлу
     * @return список строк
     */
    public static void main(String[] args) {
        System.out.println(LocalTime.of(10, 5, 0));
    }

    @org.junit.Test
    public void what_happens_with_reference_without_name() {
        new Record(1, LocalTime.now(), "task", "desc");

        // ПАМЯТЬ
        // служебные классы
        // твои классы
        // Record.class
        // начинает выполняться твой код
        // куча
        // ================
        // Record@72039485
        // ================
        // Стек
        // пустой
    }

    @Test
    public void what_happens_with_reference_with_name() {
        Record record = new Record(1, LocalTime.now(), "task", "desc");
        // ПАМЯТЬ
        // служебные классы
        // твои классы
        // Record.class
        // начинает выполняться твой код
        // куча
        // ================
        // Record@72039485
        // ================
        // Стек
        // record = 72039485
    }
}
