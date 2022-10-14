package org.shemenev.v2;

import org.junit.Assert;
import org.junit.Test;

import java.net.NetworkInterface;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.junit.Assert.*;

public class ReportGeneratorTest {

    @Test
    public void should_generate_report() {
        List<Record> records = List.of(
                new Record(1, LocalTime.of(10, 0, 0), "inbox", "начало"),
                new Record(2, LocalTime.of(10, 30, 0), "break", "empty"),
                new Record(3, LocalTime.of(11, 10, 0), "ID-1872", "делаю задачу"),
                new Record(4, LocalTime.of(12, 0, 0), "end", "empty")
        );
        Map<String, Duration> actual = new ReportGenerator().generate(records);

        Map<String, Duration> expectedMap = Map.ofEntries(
                Map.entry("inbox", Duration.of(30, MINUTES)),
                Map.entry("break", Duration.of(40, MINUTES)),
                Map.entry("ID-1872", Duration.of(50, MINUTES))
        );

        Assert.assertTrue(actual.keySet().equals(expectedMap.keySet()));
        Assert.assertTrue(actual.values().equals(expectedMap.values()));
    }
}