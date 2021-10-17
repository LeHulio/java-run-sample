package ru.tuanviet.javabox.parsers;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import ru.tuanviet.javabox.DetailedNews;
import ru.tuanviet.javabox.HttpClient;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonObjectParserTest {

    JsonObjectParser objectParser;

    @Before
    public void setUp() {
        objectParser = new JsonObjectParser();

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfNull() {
        DetailedNews news = objectParser.jsonObjectParser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfEmpty() {
        DetailedNews news = objectParser.jsonObjectParser("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfNotValidArgument() {
        DetailedNews news = objectParser.jsonObjectParser("asd");
    }


    @Test
    public void shouldParseToDetailedNews() throws IOException {
        String pathToJsonObject = "C:\\Users\\alexm\\IdeaProjects\\java-run-sample\\src\\test\\resources\\__files\\topNews\\jsonObject\\json-object.json";
        DetailedNews news = objectParser.jsonObjectParser(fileReader(pathToJsonObject));
        System.out.println(news);
        assertThat(news.getScore()).isEqualTo("6");

    }


    private String fileReader(String fileName) throws IOException {
        String line;
        StringBuilder sb;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            sb = new StringBuilder();
            line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }
        }

        return sb.toString();

    }



}