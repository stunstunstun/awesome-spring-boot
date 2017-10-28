package com.stunstun.spring;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author minhyeok
 */
public class FileUtilsTests {

    @Test
    public void getByteArray() throws IOException {
        byte[] bytes = FileUtils.getByteArray(getClass(), "data.json");
        assertThat(new String(bytes)).isEqualTo("{\"name\": \"Minhyeok\"}");
    }

    @Test
    public void readFileAndCreateMap() throws IOException {
        byte[] bytes = FileUtils.getByteArray(getClass(), "article.txt");
        String article = new String(bytes);
        article = article.replaceAll(System.lineSeparator(), " ");

        Map<String, Long> map = Stream.of(article.split(" ")).collect(groupingBy(
                Function.identity(),
                counting()));

        assertThat(map.containsKey("Article")).isTrue();
    }
}
