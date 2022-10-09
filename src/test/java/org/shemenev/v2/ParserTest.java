package org.shemenev.v2;


import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

/**
 * Тест для {@link Parser}
 */
public class ParserTest {
    @Test
    public void should_parse_file() throws URISyntaxException {
        // Location-Independent Access to Resources это про getResources
        // https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html
        Parser parser = new Parser();
        URL url = Parser.class.getResource("data sample.md");
        Path path = Paths.get(url.toURI());
        List<Record> records = parser.parse(path);
        Assert.assertEquals(18, records.size());
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_if_there_is_no_such_file(){
        Parser parser = new Parser();
        Path path = Paths.get("C:\\путь\\файл.md");
        List<Record> records = parser.parse(path);
    }

    @Test
    public void should_throw_exception_if_there_is_no_such_file_v2(){
        Parser parser = new Parser();
        boolean wasThrown = false;
        Path path = Paths.get("C:\\путь\\файл.md");
        try{
            List<Record> records = parser.parse(path);
        } catch (IllegalStateException exception) {
            wasThrown = true;
        }

        Assert.assertTrue(wasThrown);
    }

    /**
     * 1) Нужно заставить тест работать
     * Для этого
     * 1) переопреелить equals
     * 2) переопределить toString
     *
     * @throws URISyntaxException
     */
    @Test
    public void should_read_expected_records() throws URISyntaxException{
        Parser parser = new Parser();
        URL url = Parser.class.getResource("shortDataSample.md");
        Path path = Paths.get(url.toURI());
        List<Record> parsedRecords = parser.parse(path);

        List<Record> expectedRecords = List.of(
                new Record(1, LocalTime.of(10, 5, 0), "inbox", "начало"),
                new Record(2, LocalTime.of(10, 48,0), "break", "empty"),
                new Record(3, LocalTime.of(19, 20, 0), "ID-1872", "делаю задачу"),
                new Record(4, LocalTime.of(20, 1, 0), "end", "empty")
        );

        Assert.assertEquals(expectedRecords, parsedRecords);
    }
}
